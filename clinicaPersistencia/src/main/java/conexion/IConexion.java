/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package conexion;

import excepciones.PersistenciaException;
import java.sql.Connection;

/**
 * Interfaz que define el método para establecer una conexión con la base de datos.
 * Implementaciones de esta interfaz deben manejar la conexión y posibles errores de persistencia.
 * 
 * @author alega
 */
public interface IConexion {
    
    /**
     * Crea y devuelve una conexión a la base de datos.
     * 
     * @return Objeto {@code Connection} que representa la conexión activa a la base de datos.
     * @throws PersistenciaException Si ocurre un error al intentar establecer la conexión.
     */
    public Connection crearConexion() throws PersistenciaException;
}
