/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.ConsultaDAO;
import DAO.IConsultaDAO;
import DTO.ConsultaDTO;
import conexion.IConexion;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapper.Mapper;

/**
 *
 * @author alega
 */
public class ConsultaBO {
    
    private static final Logger logger = Logger.getLogger(MedicoBO.class.getName());
    private final IConsultaDAO consultaDAO;

    public ConsultaBO(IConexion conexion) {
        this.consultaDAO = new ConsultaDAO(conexion);
    }
    
    public void realizarConsulta(ConsultaDTO consultaDTO) throws PersistenciaException, NegocioException {
        // validaciones necesarias
        
        try {
            consultaDAO.realizarConsulta(Mapper.toEntity(consultaDTO));
        } catch (PersistenciaException ex) {
            logger.log(Level.SEVERE, "Error al registrar consulta.", ex);
            throw new NegocioException("Ocurrió un error al registrar la consulta.", ex);
        }
        
    }
    
}
