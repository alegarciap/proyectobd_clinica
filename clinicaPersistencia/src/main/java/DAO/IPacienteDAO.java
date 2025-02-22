/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entidades.Paciente;
import excepciones.PersistenciaException;
import java.sql.SQLException;

/**
 *
 * @author alega
 */
public interface IPacienteDAO {
    
    public void registrarPaciente(Paciente paciente) throws PersistenciaException;
    
    public Paciente obtenerPaciente(int id_usuario) throws SQLException, PersistenciaException;
    
    public void actualizarPaciente(Paciente paciente) throws PersistenciaException;
    
}
