/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entidades.Cita;
import excepciones.PersistenciaException;

/**
 *
 * @author alega
 */
public interface ICitaDAO {
    
    public boolean agendarCita(Cita cita) throws PersistenciaException;
    
    public boolean agendarCitaEmergencia(Cita cita) throws PersistenciaException;
    
}
