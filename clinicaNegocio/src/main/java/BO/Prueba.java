/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BO;

import DTO.CitaDTO;
import DTO.ConsultaDTO;
import DTO.MedicoDTO;
import DTO.PacienteDTO;
import DTO.UsuarioDTO;
import com.sun.tools.javac.Main;
import conexion.Conexion;
import conexion.IConexion;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
    public static void main(String[] args) throws ParseException, SQLException {
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
        // prueba para iniciar sesion, si funciona
        try {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setNombre("carlos_perez2");
            usuarioDTO.setContrasenia("nuevacontrasenia1234"); 
            
            UsuarioBO usuarioBO = new UsuarioBO(conexion);
            
            if (usuarioBO.iniciarSesion(usuarioDTO)) {
                System.out.println("Inicio de sesión exitoso.");
            } else {
                System.out.println("Credenciales incorrectas.");
            }
        } catch (NegocioException | PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al iniciar sesión: " + ex.getMessage(), ex);
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
        
        /**
        // prueba para dar de baja médico, se probaron todos los escenarios y si funciona correctamente
        try {
            MedicoDTO medico = new MedicoDTO();
            medico.setId_medico(3);

            MedicoBO medicoBO = new MedicoBO(conexion);
            
            medicoBO.desactivarMedico(medico);
            System.out.println("Baja de médico realizada con éxito");
        } catch (NegocioException | PersistenciaException e) {
            System.out.println("Error al dar de baja médico: " + e.getMessage());
        }
        **/
        
        /**
        // prueba para activar médico, se probaron todos los escenarios y si funciona correctamente
        try {
            MedicoDTO medico = new MedicoDTO();
            medico.setId_medico(3);

            MedicoBO medicoBO = new MedicoBO(conexion);

            medicoBO.activarMedico(medico);
            System.out.println("Activación de médico realizada con éxito");
        } catch (NegocioException | PersistenciaException e) {
            System.out.println("Error al activar médico: " + e.getMessage());
        }
        **/
        
        /**
        // prueba para obtener las citas de un médico (agenda)
        try {
            CitaBO citaBO = new CitaBO(conexion);
            
            List<CitaDTO> citas = citaBO.obtenerCitasMedico(2);
            System.out.println("Citas del médico: ");
            for (CitaDTO c : citas) {
                System.out.println(c);
            }
            
        } catch (NegocioException | PersistenciaException e) {
            System.out.println("Error al obtener citas del médico: " + e.getMessage());
        }
        **/
        
        /**
        // prueba para realizar una consulta, si jaló 
        try {
            CitaDTO cita = new CitaDTO();
            cita.setId_cita(33);
            
            ConsultaDTO consulta = new ConsultaDTO();
            consulta.setFecha_hora(new Timestamp(System.currentTimeMillis()));
            consulta.setDiagnostico("Estrés por el proyecto de BD.");
            consulta.setTratamiento("Dormir un mes.");
            consulta.setObservaciones("El paciente se encuentra MUY grave.");
            consulta.setCita(cita);
            
            ConsultaBO consultaBO = new ConsultaBO(conexion);
            consultaBO.realizarConsulta(consulta);
            System.out.println("Consulta realizada con éxito");
        } catch (NegocioException | PersistenciaException e) {
            System.out.println("Error al realizar la consulta: " + e.getMessage());
        }
        **/
        
        /**
        // prueba para obtener las citas programadas de los pacientes
        try {
            CitaBO citaBO = new CitaBO(conexion);

            List<CitaDTO> citas = citaBO.obtenerCitasPaciente(6);
            System.out.println("Citas próximas del páciente: ");
            for (CitaDTO c : citas) {
                System.out.println(c);
            }
            
        } catch (NegocioException | PersistenciaException e) {
            System.out.println("Error al obtener citas del paciente: " + e.getMessage());
        }
        **/
        
        /**
        // prueba para obtener las consultas de los pacientes
        try {
            ConsultaBO consultaBO = new ConsultaBO(conexion);
            
            List<ConsultaDTO> consultas = consultaBO.obtenerHistorialConsultas(5, null, null, null);
            
            for (ConsultaDTO c : consultas) {
                System.out.println(c);
            }
            
        } catch (NegocioException | PersistenciaException e) {
            System.out.println("Error al obtener consultas del paciente: " + e.getMessage());
        }
        **/
        
        /**
        // prueba para obtener el historial de consultas (médicos)
        try {
            ConsultaBO consultaBO = new ConsultaBO(conexion);
            
            List<ConsultaDTO> consultas = consultaBO.obtenerHistorialConsultasMedicos(2, 5);
            
            for (ConsultaDTO c : consultas) {
                System.out.println(c);
            }
            
        } catch (NegocioException | PersistenciaException e) {
            System.out.println("Error al obtener el historial de consultas: " + e.getMessage());
        }
        **/
    }
    
}
