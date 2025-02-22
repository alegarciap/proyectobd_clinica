/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entidades.Medico;
import excepciones.PersistenciaException;
import java.sql.SQLException;

/**
 *
 * @author alega
 */
public interface IMedicoDAO {
    
    public Medico obtenerMedico(int id_usuario) throws SQLException, PersistenciaException;
    
    
}
