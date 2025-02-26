/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 * Excepción personalizada para manejar errores relacionados con la persistencia de datos.
 * Se lanza cuando ocurre un problema al acceder o manipular la base de datos.
 * Extiende de la clase {@code Exception}.
 * 
 * @author alega
 */
public class PersistenciaException extends Exception {
    
    /**
     * Constructor que recibe un mensaje de error.
     * 
     * @param message Mensaje que describe el error ocurrido.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor que recibe un mensaje de error y la causa original del error.
     * 
     * @param message Mensaje que describe el error ocurrido.
     * @param cause Excepción que causó este error.
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }
}
