/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BO;

import DTO.CitaDTO;
import conexion.Conexion;
import conexion.IConexion;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alega
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // prueba agendar cita normal
//        try {
//            IConexion conexion = new Conexion();
//            CitaBO citaBO = new CitaBO(conexion);
//            
//            CitaDTO citaDTO = new CitaDTO();
//            citaDTO.setFecha_hora(Timestamp.valueOf("2025-02-21 11:00:00")); // 22 no trabaja
//            citaDTO.setId_paciente(7); 
//            citaDTO.setId_medico(3); // 4 inactivo
//            
//            citaBO.agendarCita(citaDTO);
//            System.out.println("Cita agendada correctamente.");
//
//        } catch (NegocioException | PersistenciaException ex) {
//            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, "Error al agendar la cita", ex);
//        }
        
        // prueba agendar cita de emergencia
        try {
            IConexion conexion = new Conexion();
            CitaBO citaBO = new CitaBO(conexion);
            
            CitaDTO citaEmergencia = new CitaDTO();
            citaEmergencia.setId_paciente(5); 

            // Intentar agendar la cita de emergencia
            citaBO.agendarCitaEmergencia(citaEmergencia);
            System.out.println("Cita de emergencia agendada con éxito.");
        } catch (NegocioException | PersistenciaException e) {
            System.err.println("Error al agendar la cita de emergencia: " + e.getMessage());
        }
    }
    
}
