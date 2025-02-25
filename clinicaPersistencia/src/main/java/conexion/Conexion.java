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
 *
 * @author alega
 */
public class Conexion implements IConexion {
    
    final String URL = "jdbc:mysql://127.0.0.1:3306/clinica";
    final String USER = "root"; 
    final String PASS = "2005";

    @Override
    public Connection crearConexion() throws PersistenciaException{
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASS);
            return conexion;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Error al generar la conexión");
        }
    }
    
}
