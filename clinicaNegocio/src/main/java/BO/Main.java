/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BO;

import DAO.CitaDAO;
import conexion.Conexion;
import entidades.Cita;
import entidades.Medico;
import entidades.Paciente;
import entidades.Usuario;
import excepciones.PersistenciaException;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author PC Gamer
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Conexion conexion = new Conexion();
            CitaDAO citaDAO = new CitaDAO(conexion);

            Usuario usuarioPaciente = new Usuario(1, "usuarioPaciente", "123");

            Paciente paciente = new Paciente(1, "Jonh", "Wick", "Perez", "Calle Roja",
                    Date.valueOf("1990-05-15"), "5551234567", "jonh.wick@gmail.com", usuarioPaciente);

            Usuario usuarioMedico = new Usuario(2, "usuarioMedico", "123");

            Medico medico = new Medico(2, "Anakin", "Skywalker", "Rodriguez", "123456", "Cardiologia", "Activo", usuarioMedico);

            // Agendar cita normal
            Timestamp fechaHora = Timestamp.valueOf("2025-02-21 08:00:00");
            Cita cita = new Cita(fechaHora, "Pendiente", "F123456", medico, paciente);
            citaDAO.agendarCita(cita);
            System.out.println("Cita normal agendada correctamente.");

            //Agregar horario de atencion
            // Agendar cita de emergencia
            Cita citaEmergencia = new Cita(null, "Emergencia", "F123457", null, paciente);
            citaDAO.agendarCitaEmergencia(citaEmergencia);
            System.out.println("Cita de emergencia agendada correctamente.");

        } catch (PersistenciaException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
