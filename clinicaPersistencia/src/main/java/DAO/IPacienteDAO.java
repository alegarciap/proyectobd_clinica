/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entidades.Paciente;
import excepciones.PersistenciaException;
import java.sql.SQLException;

/**
 * Interfaz para la gestión de pacientes en el sistema.
 * 
 * Define los métodos necesarios para registrar, obtener y actualizar la información de los pacientes.
 * 
 * @author alega
 */
public interface IPacienteDAO {
    
    /**
     * Registra un nuevo paciente en el sistema.
     * 
     * @param paciente Objeto Paciente con la información a registrar.
     * @throws PersistenciaException Si ocurre un error en la operación de persistencia.
     */
    public void registrarPaciente(Paciente paciente) throws PersistenciaException;
    
    /**
     * Obtiene la información de un paciente a partir de su ID de usuario.
     * 
     * @param id_usuario ID del usuario asociado al paciente.
     * @return Objeto Paciente con la información obtenida.
     * @throws SQLException Si ocurre un error en la consulta a la base de datos.
     * @throws PersistenciaException Si ocurre un error en la persistencia de datos.
     */
    public Paciente obtenerPaciente(int id_usuario) throws SQLException, PersistenciaException;
    
    /**
     * Actualiza la información de un paciente en el sistema.
     * 
     * @param paciente Objeto Paciente con la información actualizada.
     * @throws PersistenciaException Si ocurre un error en la operación de persistencia.
     */
    public void actualizarPaciente(Paciente paciente) throws PersistenciaException;
    
}
