/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Timestamp;

/**
 * La clase CitaDTO representa un objeto de transferencia de datos
 * utilizado para almacenar información sobre las citas en el sistema.
 * Incluye detalles sobre la fecha y hora de la cita, el estado, el 
 * folio, el paciente y el médico asociados.
 * 
 * @author alega
 */
public class CitaDTO {

    private int id_cita;
    private Timestamp fecha_hora;
    private String estado;
    private String folio;
    private PacienteDTO paciente;
    private MedicoDTO medico;

    /**
     * Constructor vacío de CitaDTO.
     */
    public CitaDTO() {
    }

    /**
     * Constructor de CitaDTO con todos los parámetros.
     * 
     * @param id_cita El ID de la cita.
     * @param fecha_hora La fecha y hora de la cita.
     * @param estado El estado de la cita.
     * @param folio El folio de la cita.
     * @param paciente El paciente asociado a la cita.
     * @param medico El médico asociado a la cita.
     */
    public CitaDTO(int id_cita, Timestamp fecha_hora, String estado, String folio, PacienteDTO paciente, MedicoDTO medico) {
        this.id_cita = id_cita;
        this.fecha_hora = fecha_hora;
        this.estado = estado;
        this.folio = folio;
        this.paciente = paciente;
        this.medico = medico;
    }

    /**
     * Constructor de CitaDTO sin ID de cita.
     * 
     * @param fecha_hora La fecha y hora de la cita.
     * @param estado El estado de la cita.
     * @param folio El folio de la cita.
     * @param paciente El paciente asociado a la cita.
     * @param medico El médico asociado a la cita.
     */
    public CitaDTO(Timestamp fecha_hora, String estado, String folio, PacienteDTO paciente, MedicoDTO medico) {
        this.fecha_hora = fecha_hora;
        this.estado = estado;
        this.folio = folio;
        this.paciente = paciente;
        this.medico = medico;
    }

    /**
     * Obtiene el ID de la cita.
     * 
     * @return El ID de la cita.
     */
    public int getId_cita() {
        return id_cita;
    }

    /**
     * Establece el ID de la cita.
     * 
     * @param id_cita El nuevo ID de la cita.
     */
    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    /**
     * Obtiene la fecha y hora de la cita.
     * 
     * @return La fecha y hora de la cita.
     */
    public Timestamp getFecha_hora() {
        return fecha_hora;
    }

    /**
     * Establece la fecha y hora de la cita.
     * 
     * @param fecha_hora La nueva fecha y hora de la cita.
     */
    public void setFecha_hora(Timestamp fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    /**
     * Obtiene el estado de la cita.
     * 
     * @return El estado de la cita.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la cita.
     * 
     * @param estado El nuevo estado de la cita.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el folio de la cita.
     * 
     * @return El folio de la cita.
     */
    public String getFolio() {
        return folio;
    }

    /**
     * Establece el folio de la cita.
     * 
     * @param folio El nuevo folio de la cita.
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * Obtiene el paciente asociado a la cita.
     * 
     * @return El paciente asociado a la cita.
     */
    public PacienteDTO getPaciente() {
        return paciente;
    }

    /**
     * Establece el paciente asociado a la cita.
     * 
     * @param paciente El nuevo paciente asociado a la cita.
     */
    public void setPaciente(PacienteDTO paciente) {
        this.paciente = paciente;
    }

    /**
     * Obtiene el médico asociado a la cita.
     * 
     * @return El médico asociado a la cita.
     */
    public MedicoDTO getMedico() {
        return medico;
    }

    /**
     * Establece el médico asociado a la cita.
     * 
     * @param medico El nuevo médico asociado a la cita.
     */
    public void setMedico(MedicoDTO medico) {
        this.medico = medico;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto CitaDTO.
     * 
     * @return Una cadena que representa el objeto CitaDTO.
     */
    @Override
    public String toString() {
        return "CitaDTO{" + "id_cita=" + id_cita + ", fecha_hora=" + fecha_hora + ", estado=" + estado + ", folio=" + folio + ", paciente=" + paciente + ", medico=" + medico + '}';
    }

}
