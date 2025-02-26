/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entidades.Medico;
import excepciones.PersistenciaException;
import java.sql.SQLException;

/**
 * Interfaz para la gestión de médicos en el sistema.
 * 
 * Define los métodos necesarios para obtener, activar y desactivar médicos.
 * 
 * @author Abraham Coronel
 */
public interface IMedicoDAO {
    
    /**
     * Obtiene la información de un médico a partir de su ID de usuario.
     * 
     * @param id_usuario ID del usuario asociado al médico.
     * @return Objeto Medico con la información obtenida.
     * @throws SQLException Si ocurre un error en la consulta a la base de datos.
     * @throws PersistenciaException Si ocurre un error en la persistencia de datos.
     */
    public Medico obtenerMedico(int id_usuario) throws SQLException, PersistenciaException;
    
    /**
     * Desactiva el registro de un médico en el sistema.
     * 
     * @param medico Objeto Medico que se desea desactivar.
     * @throws SQLException Si ocurre un error en la consulta a la base de datos.
     * @throws PersistenciaException Si ocurre un error en la persistencia de datos.
     */
    public void desactivarMedico(Medico medico) throws SQLException, PersistenciaException;
    
    /**
     * Activa el registro de un médico en el sistema.
     * 
     * @param medico Objeto Medico que se desea activar.
     * @throws SQLException Si ocurre un error en la consulta a la base de datos.
     * @throws PersistenciaException Si ocurre un error en la persistencia de datos.
     */
    public void activarMedico(Medico medico) throws SQLException, PersistenciaException;
}
