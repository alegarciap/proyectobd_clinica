/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.sql.Timestamp;

/**
 * Representa una consulta médica realizada en la clínica. Contiene información
 * sobre la fecha y hora de la consulta, el diagnóstico, el tratamiento 
 * proporcionado, observaciones adicionales y la cita asociada.
 * 
 * @author alega
 */
public class Consulta {
    
    /**
     * Identificador único de la consulta.
     */
    private int id_consulta;
    
    /**
     * Fecha y hora en la que se realizó la consulta.
     */
    private Timestamp fecha_hora;
    
    /**
     * Diagnóstico proporcionado por el médico durante la consulta.
     */
    private String diagnostico;
    
    /**
     * Tratamiento recetado para el paciente.
     */
    private String tratamiento;
    
    /**
     * Observaciones adicionales del médico sobre la consulta.
     */
    private String observaciones;
    
    /**
     * Cita asociada a la consulta.
     */
    private Cita cita;

    /**
     * Constructor por defecto.
     */
    public Consulta() {
    }

    /**
     * Constructor con todos los atributos.
     * 
     * @param id_consulta Identificador único de la consulta.
     * @param fecha_hora Fecha y hora en que se realizó la consulta.
     * @param diagnostico Diagnóstico proporcionado por el médico.
     * @param tratamiento Tratamiento recetado al paciente.
     * @param observaciones Observaciones adicionales del médico.
     * @param cita Cita médica asociada a la consulta.
     */
    public Consulta(int id_consulta, Timestamp fecha_hora, String diagnostico, String tratamiento, String observaciones, Cita cita) {
        this.id_consulta = id_consulta;
        this.fecha_hora = fecha_hora;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.cita = cita;
    }

    /**
     * Constructor sin identificador de consulta (para registros nuevos).
     * 
     * @param fecha_hora Fecha y hora en que se realizó la consulta.
     * @param diagnostico Diagnóstico proporcionado por el médico.
     * @param tratamiento Tratamiento recetado al paciente.
     * @param observaciones Observaciones adicionales del médico.
     * @param cita Cita médica asociada a la consulta.
     */
    public Consulta(Timestamp fecha_hora, String diagnostico, String tratamiento, String observaciones, Cita cita) {
        this.fecha_hora = fecha_hora;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.cita = cita;
    }

    /**
     * Obtiene el identificador único de la consulta.
     * 
     * @return Identificador de la consulta.
     */
    public int getId_consulta() {
        return id_consulta;
    }

    /**
     * Establece el identificador único de la consulta.
     * 
     * @param id_consulta Nuevo identificador de la consulta.
     */
    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }

    /**
     * Obtiene la fecha y hora de la consulta.
     * 
     * @return Fecha y hora de la consulta.
     */
    public Timestamp getFecha_hora() {
        return fecha_hora;
    }

    /**
     * Establece la fecha y hora de la consulta.
     * 
     * @param fecha_hora Nueva fecha y hora de la consulta.
     */
    public void setFecha_hora(Timestamp fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    /**
     * Obtiene el diagnóstico de la consulta.
     * 
     * @return Diagnóstico de la consulta.
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * Establece el diagnóstico de la consulta.
     * 
     * @param diagnostico Nuevo diagnóstico de la consulta.
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * Obtiene el tratamiento recetado al paciente.
     * 
     * @return Tratamiento recetado.
     */
    public String getTratamiento() {
        return tratamiento;
    }

    /**
     * Establece el tratamiento recetado al paciente.
     * 
     * @param tratamiento Nuevo tratamiento de la consulta.
     */
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    /**
     * Obtiene las observaciones adicionales de la consulta.
     * 
     * @return Observaciones adicionales.
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Establece las observaciones adicionales de la consulta.
     * 
     * @param observaciones Nuevas observaciones de la consulta.
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Obtiene la cita médica asociada a la consulta.
     * 
     * @return Cita médica de la consulta.
     */
    public Cita getCita() {
        return cita;
    }

    /**
     * Establece la cita médica asociada a la consulta.
     * 
     * @param cita Nueva cita médica asociada.
     */
    public void setCita(Cita cita) {
        this.cita = cita;
    }

    /**
     * Representación en cadena de la consulta.
     * 
     * @return Una cadena con los valores de los atributos de la consulta.
     */
    @Override
    public String toString() {
        return "Consulta{" + 
                "id_consulta=" + id_consulta + 
                ", fecha_hora=" + fecha_hora + 
                ", diagnostico=" + diagnostico + 
                ", tratamiento=" + tratamiento + 
                ", observaciones=" + observaciones + 
                ", cita=" + cita + 
                '}';
    }
}
