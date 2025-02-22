/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BO;

import DTO.CitaDTO;
import DTO.MedicoDTO;
import DTO.PacienteDTO;
import DTO.UsuarioDTO;
import com.sun.tools.javac.Main;
import conexion.Conexion;
import conexion.IConexion;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alega
 */
public class Prueba {
    
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        IConexion conexion = new Conexion();
        
        /**
        // prueba para registrar paciente
        try {
            Logger logger = Logger.getLogger(Main.class.getName());

            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId_usuario(0); // se genera automáticamente en la BD
            usuarioDTO.setNombre("usuarioPrueba2");
            usuarioDTO.setContrasenia("12345678");

            PacienteDTO pacienteDTO = new PacienteDTO();
            pacienteDTO.setNombre("Axel");
            pacienteDTO.setApellido_paterno("Sauced");
            pacienteDTO.setApellido_materno("Preciado");
            pacienteDTO.setDireccion("Calle Anónima 485");
            pacienteDTO.setFecha_nacimiento(Date.valueOf("2005-03-22"));
            pacienteDTO.setTelefono("7854123650");
            pacienteDTO.setCorreo("axel.sauceda@gmail.com");
            pacienteDTO.setUsuario(usuarioDTO);
            
            PacienteBO pacienteBO = new PacienteBO(conexion);
            pacienteBO.registrarPaciente(pacienteDTO);
            System.out.println("Paciente registrado con éxito.");
        } catch (NegocioException ex) {
            logger.log(Level.SEVERE, "Error de negocio: " + ex.getMessage(), ex);
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error de persistencia: " + ex.getMessage(), ex);
        }
        **/
        
        /**
        // prueba para iniciar sesion
        try {
            UsuarioBO usuarioBO = new UsuarioBO(conexion);
            String nombreUsuario = "usuarioPrueba2";
            String contrasenia = "12345678";
            
            UsuarioDTO usuarioDTO2 = usuarioBO.autenticarUsuario(nombreUsuario, contrasenia);
            System.out.println("Inicio de sesión existoso.");
        } catch (NegocioException ex) {
            logger.log(Level.SEVERE, "Error de negocio: " + ex.getMessage(), ex);
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error de persistencia: " + ex.getMessage(), ex);
        }
        **/
        
        /**
        // prueba agendar cita normal
        try {
            PacienteDTO paciente = new PacienteDTO();
            paciente.setId_paciente(7);
            
            MedicoDTO medico = new MedicoDTO();
            medico.setId_medico(2);
            
            CitaDTO citaDTO = new CitaDTO();
            citaDTO.setFecha_hora(Timestamp.valueOf("2025-02-24 11:00:00")); // 22 no trabaja
            citaDTO.setPaciente(paciente); // 4 inactivo
            citaDTO.setMedico(medico);
            
            CitaBO citaBO = new CitaBO(conexion);
            citaBO.agendarCita(citaDTO);
            System.out.println("Cita agendada correctamente.");

        } catch (NegocioException | PersistenciaException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, "Error al agendar la cita", ex);
        }
        **/
        
        /**
        // prueba agendar cita de emergencia
        try {
            PacienteDTO paciente = new PacienteDTO();
            paciente.setId_paciente(25);
            
            CitaDTO citaEmergencia = new CitaDTO();
            citaEmergencia.setPaciente(paciente); 
            
            CitaBO citaBO = new CitaBO(conexion);
            
            citaBO.agendarCitaEmergencia(citaEmergencia);
            System.out.println("Cita de emergencia agendada con éxito.");
        } catch (NegocioException | PersistenciaException e) {
            System.err.println("Error al agendar la cita de emergencia: " + e.getMessage());
        }
        **/
        
        /**
        // prueba actualizar paciente con un paciente que no tiene citas
        try {
            PacienteDTO pacienteDTO = new PacienteDTO();
            pacienteDTO.setId_paciente(32);
            pacienteDTO.setNombre("Carlos");
            pacienteDTO.setApellido_paterno("Pérez");
            pacienteDTO.setApellido_materno("Gómez");
            pacienteDTO.setDireccion("Calle 456");
            pacienteDTO.setTelefono("2015369874");
            pacienteDTO.setCorreo("carlos.perez@gmail.com");

            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setNombre("carlos_perez");
            usuarioDTO.setContrasenia("nuevacontrasenia123");
            pacienteDTO.setUsuario(usuarioDTO);
            
            PacienteBO pacienteBO = new PacienteBO(conexion);
            
            pacienteBO.actualizarPaciente(pacienteDTO);

            System.out.println("Datos del paciente actualizados correctamente.");
        } catch (NegocioException | PersistenciaException e) {
            System.out.println("Error al actualizar los datos del paciente: " + e.getMessage());
        }
        **/
        
        /**
        // prueba actualizar paciente con un paciente que si tiene citas
        try {
            PacienteDTO pacienteDTO = new PacienteDTO();
            pacienteDTO.setId_paciente(6);
            pacienteDTO.setNombre("Carlos");
            pacienteDTO.setApellido_paterno("Pérez");
            pacienteDTO.setApellido_materno("Gómez");
            pacienteDTO.setDireccion("Calle 456");
            pacienteDTO.setTelefono("2015369874");
            pacienteDTO.setCorreo("carlos.perez2@gmail.com");

            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setNombre("carlos_perez2");
            usuarioDTO.setContrasenia("nuevacontrasenia1234");
            pacienteDTO.setUsuario(usuarioDTO);
            
            PacienteBO pacienteBO = new PacienteBO(conexion);
            
            pacienteBO.actualizarPaciente(pacienteDTO);

            System.out.println("Datos del paciente actualizados correctamente.");
        } catch (NegocioException | PersistenciaException e) {
            System.out.println("Error al actualizar los datos del paciente: " + e.getMessage());
        }
        **/
        
        /**
        // prueba cancelar cita, se probaron todos los escenarios y si funciona correctamente
        try {
            PacienteDTO paciente = new PacienteDTO();
            paciente.setId_paciente(7);
            
            CitaDTO cita = new CitaDTO();
            cita.setId_cita(31);
            cita.setPaciente(paciente);
            
            CitaBO citaBO = new CitaBO(conexion);
            
            citaBO.cancelarCita(cita);
            System.out.println("Cita cancelada con éxito");
        } catch (NegocioException | PersistenciaException e) {
            System.out.println("Error al cancelar la cita: " + e.getMessage());
        }
        **/
        
        // prueba para
    }
    
}
