/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.IConexion;
import entidades.Paciente;
import entidades.Usuario;
import excepciones.PersistenciaException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase PacienteDAO proporciona métodos para manejar la persistencia de datos de pacientes 
 * y usuarios en una base de datos. Implementa la interfaz IPacienteDAO.
 * 
 * @author Abraham Coronel
 */
public class PacienteDAO implements IPacienteDAO {

    IConexion conexion;

    /**
     * Constructor de la clase PacienteDAO.
     * 
     * @param conexion La conexión a la base de datos.
     */
    public PacienteDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Registra un nuevo paciente en la base de datos.
     * 
     * @param paciente El objeto Paciente que contiene la información del paciente a registrar.
     * @throws PersistenciaException Si ocurre un error al registrar el paciente en la base de datos.
     */
    @Override
    public void registrarPaciente(Paciente paciente) throws PersistenciaException {
        String comandoSQLUsuario = "insert into usuarios(id_usuario, nombre, contrasenia) values (?,?,?);";
        String comandoSQLPaciente = "insert into pacientes(id_paciente, nombre, apellido_paterno, apellido_materno, direccion, fecha_nacimiento, telefono, correo) "
                + "values (?,?,?,?,?,?,?,?);";
        
        try (Connection con = conexion.crearConexion()) { 
            con.setAutoCommit(false);
            
            // encriptar contraseña
            String contraseniaEncriptada = getMD5(paciente.getUsuario().getContrasenia());
            
            try (PreparedStatement stUsuario = con.prepareStatement(comandoSQLUsuario, Statement.RETURN_GENERATED_KEYS)) {
                stUsuario.setInt(1, paciente.getUsuario().getId_usuario());
                stUsuario.setString(2, paciente.getUsuario().getNombre());
                stUsuario.setString(3, contraseniaEncriptada);
                stUsuario.executeUpdate();
                
                try (ResultSet rs = stUsuario.getGeneratedKeys()) {
                    if (!rs.next()) {
                        throw new PersistenciaException("Error: No se pudo obtener el ID del usuario.");
                    }
                    
                    int idUsuario = rs.getInt(1);
                    
                    try (PreparedStatement stPaciente = con.prepareStatement(comandoSQLPaciente)) {
                        stPaciente.setInt(1, idUsuario);
                        stPaciente.setString(2, paciente.getNombre());
                        stPaciente.setString(3, paciente.getApellido_paterno());
                        stPaciente.setString(4, paciente.getApellido_materno());
                        stPaciente.setString(5, paciente.getDireccion());
                        stPaciente.setDate(6, (Date) paciente.getFecha_nacimiento());
                        stPaciente.setString(7, paciente.getTelefono());
                        stPaciente.setString(8, paciente.getCorreo());
                        
                        stPaciente.executeUpdate();
                    }
                }
            }
            con.commit();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error: No se pudo registrar el paciente.", ex);
        }
    }

    /**
     * Obtiene un paciente de la base de datos según el ID del usuario.
     * 
     * @param id_usuario El ID del usuario del paciente a obtener.
     * @return Un objeto Paciente que contiene la información del paciente, o null si no se encuentra.
     * @throws SQLException Si ocurre un error de SQL al obtener el paciente.
     * @throws PersistenciaException Si ocurre un error al acceder a los datos de persistencia.
     */
    @Override
    public Paciente obtenerPaciente(int id_usuario) throws SQLException, PersistenciaException {
        String comandoSQL = "select * from pacientes p "
                + "join usuarios u on p.id_paciente = u.id_usuario "
                + "where p.id_paciente = ?";

        try (Connection con = conexion.crearConexion(); PreparedStatement st = con.prepareStatement(comandoSQL)) {
            st.setInt(1, id_usuario);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Paciente paciente = new Paciente();
                    paciente.setId_paciente(rs.getInt("id_paciente"));
                    paciente.setNombre(rs.getString("nombre"));
                    paciente.setApellido_paterno(rs.getString("apellido_paterno"));
                    paciente.setApellido_materno(rs.getString("apellido_materno"));
                    paciente.setDireccion(rs.getString("direccion"));
                    paciente.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                    paciente.setTelefono(rs.getString("telefono"));
                    paciente.setCorreo(rs.getString("correo"));

                    Usuario usuario = new Usuario();
                    usuario.setId_usuario(rs.getInt("id_usuario"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setContrasenia(rs.getString("contrasenia"));

                    paciente.setUsuario(usuario);

                    return paciente;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al obtener paciente.", ex);
        }
        return null;
    }

    /**
     * Actualiza la información de un paciente en la base de datos.
     * 
     * @param paciente El objeto Paciente que contiene la nueva información del paciente.
     * @throws PersistenciaException Si ocurre un error al actualizar los datos del paciente.
     */
    @Override
    public void actualizarPaciente(Paciente paciente) throws PersistenciaException {
        String comandoSQL = "call actualizar_paciente(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // encriptar la nueva contraseña 
        String contraseniaEncriptada = null;
        if (paciente.getUsuario().getContrasenia() != null && !paciente.getUsuario().getContrasenia().isEmpty()) {
            contraseniaEncriptada = getMD5(paciente.getUsuario().getContrasenia());
        }

        try (Connection con = this.conexion.crearConexion(); CallableStatement cb = con.prepareCall(comandoSQL)) {
            cb.setInt(1, paciente.getId_paciente());
            cb.setString(2, paciente.getNombre());
            cb.setString(3, paciente.getApellido_paterno());
            cb.setString(4, paciente.getApellido_materno());
            cb.setString(5, paciente.getDireccion());
            cb.setString(6, paciente.getTelefono());
            cb.setString(7, paciente.getCorreo());
            cb.setString(8, paciente.getUsuario().getNombre());
            cb.setString(9, contraseniaEncriptada);

            cb.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new PersistenciaException("Error al actualizar los datos del paciente.", e);
        }
    }

    /**
     * Calcula el hash MD5 de una cadena de texto.
     * 
     * @param input La cadena de texto a encriptar.
     * @return La representación en formato hexadecimal del hash MD5.
     */
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al calcular MD5.", e);
        }
    }
}
