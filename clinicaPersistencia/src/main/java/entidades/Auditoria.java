/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDateTime;

/**
 *
 * @author alega
 */
public class Auditoria {
    
    private int id_auditoria;
    private String accion;
    private LocalDateTime fecha_hora;
    private int id_cita;

    public Auditoria() {
    }

    public Auditoria(int id_auditoria, String accion, LocalDateTime fecha_hora, int id_cita) {
        this.id_auditoria = id_auditoria;
        this.accion = accion;
        this.fecha_hora = fecha_hora;
        this.id_cita = id_cita;
    }

    public Auditoria(String accion, LocalDateTime fecha_hora, int id_cita) {
        this.accion = accion;
        this.fecha_hora = fecha_hora;
        this.id_cita = id_cita;
    }

    @Override
    public String toString() {
        return "Auditoria{" + "id_auditoria=" + id_auditoria + ", accion=" + accion + ", fecha_hora=" + fecha_hora + ", id_cita=" + id_cita + '}';
    }
    
}
