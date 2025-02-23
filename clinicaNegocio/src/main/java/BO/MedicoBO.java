/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.IMedicoDAO;
import DAO.MedicoDAO;
import DTO.MedicoDTO;
import conexion.IConexion;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapper.Mapper;

/**
 *
 * @author alega
 */
public class MedicoBO {
    
    private static final Logger logger = Logger.getLogger(MedicoBO.class.getName());
    private final IMedicoDAO medicoDAO;
    
    public MedicoBO(IConexion conexion) {
        this.medicoDAO = new MedicoDAO(conexion);
    }
    
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
    
    public void activarMedico(MedicoDTO medicoDTO) throws PersistenciaException, NegocioException, SQLException {
        if (medicoDTO == null) {
            throw new PersistenciaException("El médico a dar de baja no puede ser nulo.");
        }
        
        // validaciones necesarias
        
        try {
            medicoDAO.activarMedico(Mapper.toEntity(medicoDTO));
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al activar médico.", ex);
            throw new NegocioException("Hubo un error al activar médico.", ex);
        }
    }
    
}
