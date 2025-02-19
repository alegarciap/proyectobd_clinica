/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalTime;

/**
 *
 * @author alega
 */
public class HorariosAtencion {
    
    private int id_horario;
    private String dia;
    private LocalTime hora_entrada;
    private LocalTime hora_salida;
    private int id_medico;

    public HorariosAtencion() {
    }

    public HorariosAtencion(int id_horario, String dia, LocalTime hora_entrada, LocalTime hora_salida, int id_medico) {
        this.id_horario = id_horario;
        this.dia = dia;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.id_medico = id_medico;
    }

    public HorariosAtencion(String dia, LocalTime hora_entrada, LocalTime hora_salida, int id_medico) {
        this.dia = dia;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.id_medico = id_medico;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public LocalTime getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(LocalTime hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public LocalTime getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(LocalTime hora_salida) {
        this.hora_salida = hora_salida;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    @Override
    public String toString() {
        return "HorariosAtencion{" + "id_horario=" + id_horario + ", dia=" + dia + ", hora_entrada=" + hora_entrada + ", hora_salida=" + hora_salida + ", id_medico=" + id_medico + '}';
    }
    
}
