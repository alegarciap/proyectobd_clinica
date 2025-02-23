/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entidades.Consulta;
import excepciones.PersistenciaException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alega
 */
public interface IConsultaDAO {
    
    public void realizarConsulta(Consulta consulta) throws PersistenciaException;
        
}
