/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalTime;

/**
 * La clase HorariosAtencionDTO representa un objeto de transferencia de datos
 * utilizado para almacenar información sobre los horarios de atención de los médicos.
 * Incluye detalles sobre el día de la semana, la hora de entrada, la hora de salida
 * y el médico asociado a ese horario.
 * 
 * @author alega
 */
public class HorariosAtencionDTO {

    private int id_horario;
    private String dia;
    private LocalTime hora_entrada;
    private LocalTime hora_salida;
    private MedicoDTO medico;

    /**
     * Constructor vacío de HorariosAtencionDTO.
     */
    public HorariosAtencionDTO() {
    }

    /**
     * Constructor de HorariosAtencionDTO con todos los parámetros.
     * 
     * @param id_horario El ID del horario.
     * @param dia El día de la semana para el horario de atención.
     * @param hora_entrada La hora de entrada del médico.
     * @param hora_salida La hora de salida del médico.
     * @param medico El médico asociado a este horario.
     */
    public HorariosAtencionDTO(int id_horario, String dia, LocalTime hora_entrada, LocalTime hora_salida, MedicoDTO medico) {
        this.id_horario = id_horario;
        this.dia = dia;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.medico = medico;
    }

    /**
     * Constructor de HorariosAtencionDTO sin ID de horario.
     * 
     * @param dia El día de la semana para el horario de atención.
     * @param hora_entrada La hora de entrada del médico.
     * @param hora_salida La hora de salida del médico.
     * @param medico El médico asociado a este horario.
     */
    public HorariosAtencionDTO(String dia, LocalTime hora_entrada, LocalTime hora_salida, MedicoDTO medico) {
        this.dia = dia;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.medico = medico;
    }

    /**
     * Obtiene el ID del horario.
     * 
     * @return El ID del horario.
     */
    public int getId_horario() {
        return id_horario;
    }

    /**
     * Establece el ID del horario.
     * 
     * @param id_horario El nuevo ID del horario.
     */
    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    /**
     * Obtiene el día de la semana para el horario de atención.
     * 
     * @return El día de la semana.
     */
    public String getDia() {
        return dia;
    }

    /**
     * Establece el día de la semana para el horario de atención.
     * 
     * @param dia El nuevo día de la semana.
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     * Obtiene la hora de entrada del médico.
     * 
     * @return La hora de entrada.
     */
    public LocalTime getHora_entrada() {
        return hora_entrada;
    }

    /**
     * Establece la hora de entrada del médico.
     * 
     * @param hora_entrada La nueva hora de entrada.
     */
    public void setHora_entrada(LocalTime hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    /**
     * Obtiene la hora de salida del médico.
     * 
     * @return La hora de salida.
     */
    public LocalTime getHora_salida() {
        return hora_salida;
    }

    /**
     * Establece la hora de salida del médico.
     * 
     * @param hora_salida La nueva hora de salida.
     */
    public void setHora_salida(LocalTime hora_salida) {
        this.hora_salida = hora_salida;
    }

    /**
     * Obtiene el médico asociado a este horario.
     * 
     * @return El médico asociado.
     */
    public MedicoDTO getMedico() {
        return medico;
    }

    /**
     * Establece el médico asociado a este horario.
     * 
     * @param medico El nuevo médico asociado.
     */
    public void setMedico(MedicoDTO medico) {
        this.medico = medico;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto HorariosAtencionDTO.
     * 
     * @return Una cadena que representa el objeto HorariosAtencionDTO.
     */
    @Override
    public String toString() {
        return "HorariosAtencionDTO{" + "id_horario=" + id_horario + ", dia=" + dia + ", hora_entrada=" + hora_entrada + ", hora_salida=" + hora_salida + ", medico=" + medico + '}';
    }
}
