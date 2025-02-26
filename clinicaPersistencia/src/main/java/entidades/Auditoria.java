/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDateTime;

/**
 * Representa un registro de auditoría que almacena información sobre acciones 
 * realizadas en el sistema, junto con su fecha y hora.
 * Cada auditoría está asociada a una cita específica.
 * 
 * @author alega
 */
public class Auditoria {
    
    /**
     * Identificador único de la auditoría.
     */
    private int id_auditoria;
    
    /**
     * Acción realizada en el sistema (por ejemplo, "CREAR_CITA", "MODIFICAR_CITA").
     */
    private String accion;
    
    /**
     * Fecha y hora en que se realizó la acción.
     */
    private LocalDateTime fecha_hora;
    
    /**
     * Cita asociada a la auditoría.
     */
    private Cita cita;

    /**
     * Constructor por defecto.
     */
    public Auditoria() {
    }

    /**
     * Constructor con todos los atributos.
     * 
     * @param id_auditoria Identificador único de la auditoría.
     * @param accion Acción realizada en el sistema.
     * @param fecha_hora Fecha y hora en que se realizó la acción.
     * @param cita Cita asociada a la auditoría.
     */
    public Auditoria(int id_auditoria, String accion, LocalDateTime fecha_hora, Cita cita) {
        this.id_auditoria = id_auditoria;
        this.accion = accion;
        this.fecha_hora = fecha_hora;
        this.cita = cita;
    }

    /**
     * Constructor sin el identificador de auditoría (para registros nuevos).
     * 
     * @param accion Acción realizada en el sistema.
     * @param fecha_hora Fecha y hora en que se realizó la acción.
     * @param cita Cita asociada a la auditoría.
     */
    public Auditoria(String accion, LocalDateTime fecha_hora, Cita cita) {
        this.accion = accion;
        this.fecha_hora = fecha_hora;
        this.cita = cita;
    }

    /**
     * Representación en cadena de la auditoría.
     * 
     * @return Una cadena con los valores de los atributos de la auditoría.
     */
    @Override
    public String toString() {
        return "Auditoria{" + 
                "id_auditoria=" + id_auditoria + 
                ", accion=" + accion + 
                ", fecha_hora=" + fecha_hora + 
                ", cita=" + cita + 
                '}';
    }
}
