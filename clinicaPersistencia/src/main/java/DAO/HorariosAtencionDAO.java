/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.IConexion;

/**
 *
 * @author Abraham Coronel
 */
public class HorariosAtencionDAO implements IHorariosAtencionDAO {
    
    IConexion conexion;

    public HorariosAtencionDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    
    
    
}
