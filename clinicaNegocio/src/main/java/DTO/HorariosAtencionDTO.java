/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalTime;

/**
 *
 * @author alega
 */
public class HorariosAtencionDTO {
    
    private int id_horario;
    private String dia;
    private LocalTime hora_entrada;
    private LocalTime hora_salida;
    private MedicoDTO medico;

    public HorariosAtencionDTO() {
    }

    public HorariosAtencionDTO(int id_horario, String dia, LocalTime hora_entrada, LocalTime hora_salida, MedicoDTO medico) {
        this.id_horario = id_horario;
        this.dia = dia;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.medico = medico;
    }

    public HorariosAtencionDTO(String dia, LocalTime hora_entrada, LocalTime hora_salida, MedicoDTO medico) {
        this.dia = dia;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.medico = medico;
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

    public MedicoDTO getMedico() {
        return medico;
    }

    public void setMedico(MedicoDTO medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "HorariosAtencionDTO{" + "id_horario=" + id_horario + ", dia=" + dia + ", hora_entrada=" + hora_entrada + ", hora_salida=" + hora_salida + ", medico=" + medico + '}';
    }
    
}
