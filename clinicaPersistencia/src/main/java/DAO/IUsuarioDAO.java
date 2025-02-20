/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import entidades.Usuario;
import excepciones.PersistenciaException;

/**
 *
 * @author alega
 */
public interface IUsuarioDAO {
    
    public Usuario iniciarSesion(Usuario usuario) throws PersistenciaException;
    
    
    
}
