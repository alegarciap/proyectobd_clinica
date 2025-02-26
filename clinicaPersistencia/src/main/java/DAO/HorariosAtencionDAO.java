/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.IConexion;

/**
 * Implementación de la interfaz IHorariosAtencionDAO para gestionar los horarios de atención médica.
 * 
 * @author Abraham Coronel
 */
public class HorariosAtencionDAO implements IHorariosAtencionDAO {
    
    /**
     * Objeto de conexión a la base de datos.
     */
    private final IConexion conexion;

    /**
     * Constructor de la clase HorariosAtencionDAO.
     * 
     * @param conexion Objeto de conexión a la base de datos.
     */
    public HorariosAtencionDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    
}