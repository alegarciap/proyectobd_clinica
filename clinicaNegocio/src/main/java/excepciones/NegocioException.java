/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 * La clase NegocioException es una excepción personalizada que se utiliza 
 * para manejar errores relacionados con la lógica del negocio en la aplicación.
 * Esta excepción puede ser lanzada cuando se encuentra una situación 
 * anómala o incorrecta que impide el correcto funcionamiento de las reglas 
 * del negocio.
 * 
 * Extiende la clase Exception de Java, lo que permite su uso en 
 * bloques try-catch y la propagación de excepciones a lo largo de la 
 * aplicación.
 * 
 * @author alega
 */
public class NegocioException extends Exception {

    /**
     * Crea una nueva instancia de NegocioException con el mensaje especificado.
     * 
     * @param message El mensaje que describe la excepción.
     */
    public NegocioException(String message) {
        super(message);
    }

    /**
     * Crea una nueva instancia de NegocioException con el mensaje y la causa 
     * especificados.
     * 
     * @param message El mensaje que describe la excepción.
     * @param cause La causa de la excepción (la excepción que se produjo 
     * antes de esta).
     */
    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }
}
