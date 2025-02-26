/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.IMedicoDAO;
import DAO.MedicoDAO;
import DTO.MedicoDTO;
import conexion.IConexion;
import entidades.Medico;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapper.Mapper;

/**
 * La clase MedicoBO es responsable de la lógica de negocio relacionada con los médicos.
 * Proporciona métodos para activar y desactivar médicos, así como para obtener información sobre ellos.
 * 
 * Utiliza la interfaz IMedicoDAO para interactuar con la capa de persistencia.
 * 
 * @autor Abraham Coronel
 */
public class MedicoBO {

    private static final Logger logger = Logger.getLogger(MedicoBO.class.getName());
    private final IMedicoDAO medicoDAO;

    /**
     * Constructor de la clase MedicoBO.
     * 
     * @param conexion La conexión a la base de datos.
     */
    public MedicoBO(IConexion conexion) {
        this.medicoDAO = new MedicoDAO(conexion);
    }

    /**
     * Desactiva un médico dado.
     * 
     * @param medicoDTO El objeto MedicoDTO que representa al médico a desactivar.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia al intentar desactivar el médico.
     * @throws NegocioException Si ocurre un error de negocio al intentar desactivar el médico.
     * @throws SQLException Si ocurre un error en la ejecución de la consulta SQL.
     */
    public void desactivarMedico(MedicoDTO medicoDTO) throws PersistenciaException, NegocioException, SQLException {
        if (medicoDTO == null) {
            throw new PersistenciaException("El médico a dar de baja no puede ser nulo.");
        }

        // validaciones necesarias
        try {
            medicoDAO.desactivarMedico(Mapper.toEntity(medicoDTO));
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al dar de baja el médico.", ex);
            throw new NegocioException("Hubo un error al dar de baja el médico.", ex);
        }
    }

    /**
     * Activa un médico dado.
     * 
     * @param medicoDTO El objeto MedicoDTO que representa al médico a activar.
     * @throws PersistenciaException Si ocurre un error en la capa de persistencia al intentar activar el médico.
     * @throws NegocioException Si ocurre un error de negocio al intentar activar el médico.
     * @throws SQLException Si ocurre un error en la ejecución de la consulta SQL.
     */
    public void activarMedico(MedicoDTO medicoDTO) throws PersistenciaException, NegocioException, SQLException {
        if (medicoDTO == null) {
            throw new PersistenciaException("El médico a dar de alta no puede ser nulo.");
        }

        // validaciones necesarias
        try {
            medicoDAO.activarMedico(Mapper.toEntity(medicoDTO));
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al activar médico.", ex);
            throw new NegocioException("Hubo un error al activar médico.", ex);
        }
    }

    /**
     * Obtiene un médico por su ID de usuario.
     * 
     * @param idUsuario El ID del usuario que representa al médico a obtener.
     * @return Un objeto MedicoDTO que representa al médico obtenido.
     * @throws NegocioException Si el ID del médico no es válido o no se encuentra el médico.
     */
    public MedicoDTO obtenerMedico(int idUsuario) throws NegocioException {
        if (idUsuario <= 0) {
            throw new NegocioException("El ID del médico no es válido.");
        }

        try {
            Medico medico = medicoDAO.obtenerMedico(idUsuario);

            if (medico == null) {
                throw new NegocioException("No se encontró el médico con ID: " + idUsuario);
            }

            return Mapper.toDTO(medico);

        } catch (SQLException | PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al obtener médico", ex);
            throw new NegocioException("Error al obtener médico: " + ex.getMessage(), ex);
        }
    }
}
