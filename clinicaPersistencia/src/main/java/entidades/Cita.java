/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.sql.Timestamp;

/**
 * Representa una cita médica en el sistema, incluyendo información sobre la 
 * fecha y hora, estado de la cita, el folio de identificación, y los 
 * participantes (médico y paciente).
 * 
 * @author alega
 */
public class Cita {
    
    /**
     * Identificador único de la cita.
     */
    private int id_cita;
    
    /**
     * Fecha y hora programada para la cita.
     */
    private Timestamp fecha_hora;
    
    /**
     * Estado actual de la cita (por ejemplo, "PENDIENTE", "CANCELADA", "REALIZADA").
     */
    private String estado;
    
    /**
     * Folio único asignado a la cita para su identificación.
     */
    private String folio;
    
    /**
     * Médico asignado a la cita.
     */
    private Medico medico;
    
    /**
     * Paciente que tiene la cita médica.
     */
    private Paciente paciente;

    /**
     * Constructor por defecto.
     */
    public Cita() {
    }

    /**
     * Constructor con todos los atributos.
     * 
     * @param id_cita Identificador único de la cita.
     * @param fecha_hora Fecha y hora programada para la cita.
     * @param estado Estado actual de la cita.
     * @param folio Folio único de la cita.
     * @param medico Médico asignado a la cita.
     * @param paciente Paciente que tiene la cita.
     */
    public Cita(int id_cita, Timestamp fecha_hora, String estado, String folio, Medico medico, Paciente paciente) {
        this.id_cita = id_cita;
        this.fecha_hora = fecha_hora;
        this.estado = estado;
        this.folio = folio;
        this.medico = medico;
        this.paciente = paciente;
    }

    /**
     * Constructor sin el identificador de cita (para registros nuevos).
     * 
     * @param fecha_hora Fecha y hora programada para la cita.
     * @param estado Estado actual de la cita.
     * @param folio Folio único de la cita.
     * @param medico Médico asignado a la cita.
     * @param paciente Paciente que tiene la cita.
     */
    public Cita(Timestamp fecha_hora, String estado, String folio, Medico medico, Paciente paciente) {
        this.fecha_hora = fecha_hora;
        this.estado = estado;
        this.folio = folio;
        this.medico = medico;
        this.paciente = paciente;
    }

    /**
     * Obtiene el identificador único de la cita.
     * 
     * @return Identificador de la cita.
     */
    public int getId_cita() {
        return id_cita;
    }

    /**
     * Establece el identificador único de la cita.
     * 
     * @param id_cita Nuevo identificador de la cita.
     */
    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    /**
     * Obtiene la fecha y hora de la cita.
     * 
     * @return Fecha y hora programada.
     */
    public Timestamp getFecha_hora() {
        return fecha_hora;
    }

    /**
     * Establece la fecha y hora de la cita.
     * 
     * @param fecha_hora Nueva fecha y hora de la cita.
     */
    public void setFecha_hora(Timestamp fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    /**
     * Obtiene el estado actual de la cita.
     * 
     * @return Estado de la cita.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la cita.
     * 
     * @param estado Nuevo estado de la cita.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el folio único de la cita.
     * 
     * @return Folio de la cita.
     */
    public String getFolio() {
        return folio;
    }

    /**
     * Establece el folio único de la cita.
     * 
     * @param folio Nuevo folio de la cita.
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * Obtiene el médico asignado a la cita.
     * 
     * @return Médico de la cita.
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * Establece el médico asignado a la cita.
     * 
     * @param medico Nuevo médico de la cita.
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * Obtiene el paciente que tiene la cita.
     * 
     * @return Paciente de la cita.
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * Establece el paciente de la cita.
     * 
     * @param paciente Nuevo paciente de la cita.
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * Representación en cadena de la cita.
     * 
     * @return Una cadena con los valores de los atributos de la cita.
     */
    @Override
    public String toString() {
        return "Cita{" + 
                "id_cita=" + id_cita + 
                ", fecha_hora=" + fecha_hora + 
                ", estado=" + estado + 
                ", folio=" + folio + 
                ", medico=" + medico + 
                ", paciente=" + paciente + 
                '}';
    }
}
