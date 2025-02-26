/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entidades.Cita;
import excepciones.PersistenciaException;
import java.util.List;

/**
 * Interfaz para la gestión de citas médicas en el sistema.
 * 
 * Define los métodos necesarios para agendar, cancelar y consultar citas médicas.
 * 
 * @author alega
 */
public interface ICitaDAO {
    
    /**
     * Agenda una nueva cita médica.
     * 
     * @param cita Objeto Cita con la información a registrar.
     * @throws PersistenciaException Si ocurre un error en la operación.
     */
    public void agendarCita(Cita cita) throws PersistenciaException;
    
    /**
     * Agenda una cita de emergencia para un paciente.
     * 
     * @param cita Objeto Cita con la información a registrar.
     * @throws PersistenciaException Si ocurre un error en la operación.
     */
    public void agendarCitaEmergencia(Cita cita) throws PersistenciaException;
    
    /**
     * Cancela una cita médica existente.
     * 
     * @param cita Objeto Cita que se desea cancelar.
     * @throws PersistenciaException Si ocurre un error en la operación.
     */
    public void cancelarCita(Cita cita) throws PersistenciaException;
    
    /**
     * Obtiene la lista de citas asignadas a un médico específico.
     * 
     * @param id_medico ID del médico.
     * @return Lista de citas del médico.
     * @throws PersistenciaException Si ocurre un error en la operación.
     */
    public List<Cita> obtenerCitasMedico(int id_medico) throws PersistenciaException;
    
    /**
     * Obtiene la lista de citas asignadas a un paciente específico.
     * 
     * @param id_paciente ID del paciente.
     * @return Lista de citas del paciente.
     * @throws PersistenciaException Si ocurre un error en la operación.
     */
    public List<Cita> obtenerCitasPaciente(int id_paciente) throws PersistenciaException;
    
}
