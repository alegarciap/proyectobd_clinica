/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.IConexion;

/**
 *
 * @author alega
 */
public class ConsultaDAO implements IConsultaDAO{
    
    IConexion conexion;

    public ConsultaDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    
}
