/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entidades.Cita;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author alega
 */
public interface ICitaDAO {
    
    public void agendarCita(Cita cita) throws PersistenciaException;
    
    public void agendarCitaEmergencia(Cita cita) throws PersistenciaException;
    
    public void cancelarCita(Cita cita) throws PersistenciaException;
    
    public List<Cita> obtenerCitasMedico(int id_medico) throws PersistenciaException;
    
    public List<Cita> obtenerCitasPaciente(int id_paciente) throws PersistenciaException;
    
}
