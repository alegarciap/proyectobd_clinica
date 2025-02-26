/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.IConexion;

/**
 * Clase que implementa la interfaz IAuditoriaDAO.
 * Proporciona los métodos necesarios para realizar operaciones de auditoría en la base de datos.
 * Utiliza una conexión proporcionada a través de IConexion.
 * 
 * @author Abraham Coronel
 */
public class AuditoriaDAO implements IAuditoriaDAO {

    private IConexion conexion;

    /**
     * Constructor de la clase AuditoriaDAO.
     * 
     * @param conexion Conexión con la base de datos que se utilizará para las operaciones de auditoría.
     */
    public AuditoriaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

}
