/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.IUsuarioDAO;
import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import conexion.IConexion;
import entidades.Usuario;
import excepciones.PersistenciaException;
import java.util.logging.Logger;

/**
 *
 * @author alega
 */
public class UsuarioBO {
    
    private static final Logger logger = Logger.getLogger(CitaBO.class.getName());
    private final IUsuarioDAO usuarioDAO;
    
    public UsuarioBO(IConexion conexion) {
        this.usuarioDAO = new UsuarioDAO(conexion);
    }
    
//    public UsuarioDTO autenticarUsuario(String nombre_usuario, String contrasenia) throws PersistenciaException {
//        // validaciones necesarias
//        
//        try {
//            Usuario usuario = usuarioDAO.autenticarUsuario(nombre_usuario, contrasenia);
//        } 
//    }
    
    
}
