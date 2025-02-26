/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalTime;

/**
 * Representa el horario de atención de un médico en la clínica. Contiene 
 * información sobre el día, la hora de entrada, la hora de salida y el 
 * médico asociado.
 * 
 * @author alega
 */
public class HorariosAtencion {
    
    /**
     * Identificador único del horario de atención.
     */
    private int id_horario;
    
    /**
     * Día de la semana en el que aplica el horario de atención.
     */
    private String dia;
    
    /**
     * Hora de entrada del médico.
     */
    private LocalTime hora_entrada;
    
    /**
     * Hora de salida del médico.
     */
    private LocalTime hora_salida;
    
    /**
     * Médico asociado al horario de atención.
     */
    private Medico medico;

    /**
     * Constructor por defecto.
     */
    public HorariosAtencion() {
    }

    /**
     * Constructor con todos los atributos.
     * 
     * @param id_horario Identificador único del horario de atención.
     * @param dia Día de la semana en que aplica el horario.
     * @param hora_entrada Hora de entrada del médico.
     * @param hora_salida Hora de salida del médico.
     * @param medico Médico asociado al horario.
     */
    public HorariosAtencion(int id_horario, String dia, LocalTime hora_entrada, LocalTime hora_salida, Medico medico) {
        this.id_horario = id_horario;
        this.dia = dia;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.medico = medico;
    }

    /**
     * Constructor sin identificador de horario (para registros nuevos).
     * 
     * @param dia Día de la semana en que aplica el horario.
     * @param hora_entrada Hora de entrada del médico.
     * @param hora_salida Hora de salida del médico.
     * @param medico Médico asociado al horario.
     */
    public HorariosAtencion(String dia, LocalTime hora_entrada, LocalTime hora_salida, Medico medico) {
        this.dia = dia;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.medico = medico;
    }

    /**
     * Obtiene el identificador único del horario de atención.
     * 
     * @return Identificador del horario.
     */
    public int getId_horario() {
        return id_horario;
    }

    /**
     * Establece el identificador único del horario de atención.
     * 
     * @param id_horario Nuevo identificador del horario.
     */
    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    /**
     * Obtiene el día de la semana en que aplica el horario.
     * 
     * @return Día de la semana.
     */
    public String getDia() {
        return dia;
    }

    /**
     * Establece el día de la semana en que aplica el horario.
     * 
     * @param dia Nuevo día de la semana.
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     * Obtiene la hora de entrada del médico.
     * 
     * @return Hora de entrada.
     */
    public LocalTime getHora_entrada() {
        return hora_entrada;
    }

    /**
     * Establece la hora de entrada del médico.
     * 
     * @param hora_entrada Nueva hora de entrada.
     */
    public void setHora_entrada(LocalTime hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    /**
     * Obtiene la hora de salida del médico.
     * 
     * @return Hora de salida.
     */
    public LocalTime getHora_salida() {
        return hora_salida;
    }

    /**
     * Establece la hora de salida del médico.
     * 
     * @param hora_salida Nueva hora de salida.
     */
    public void setHora_salida(LocalTime hora_salida) {
        this.hora_salida = hora_salida;
    }

    /**
     * Obtiene el médico asociado al horario de atención.
     * 
     * @return Médico asociado.
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * Establece el médico asociado al horario de atención.
     * 
     * @param medico Nuevo médico asociado.
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * Representación en cadena del horario de atención.
     * 
     * @return Una cadena con los valores de los atributos del horario.
     */
    @Override
    public String toString() {
        return "HorariosAtencion{" + 
                "id_horario=" + id_horario + 
                ", dia=" + dia + 
                ", hora_entrada=" + hora_entrada + 
                ", hora_salida=" + hora_salida + 
                ", medico=" + medico + 
                '}';
    }
}
