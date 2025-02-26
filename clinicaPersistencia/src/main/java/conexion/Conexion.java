/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que maneja la conexión a la base de datos MySQL para la clínica.
 * Implementa la interfaz {@code IConexion} y proporciona un método para 
 * establecer una conexión con la base de datos.
 * 
 * @author alega
 */
public class Conexion implements IConexion {
    
    /**
     * URL de conexión a la base de datos MySQL.
     */
    final String URL = "jdbc:mysql://127.0.0.1:3306/clinica";
    
    /**
     * Usuario de la base de datos.
     */
    final String USER = "root"; 
    
    /**
     * Contraseña del usuario de la base de datos.
     */
    final String PASS = "2005";

    /**
     * Establece una conexión con la base de datos utilizando los parámetros definidos.
     * 
     * @return Objeto {@code Connection} que representa la conexión activa a la base de datos.
     * @throws PersistenciaException Si ocurre un error al intentar establecer la conexión.
     */
    @Override
    public Connection crearConexion() throws PersistenciaException {
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASS);
            return conexion;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al generar la conexión");
        }
    }
}
