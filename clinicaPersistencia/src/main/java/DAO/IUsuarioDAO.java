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
    
    // public Usuario autenticarUsuario(String nombre_usuario, String contrasenia) throws PersistenciaException;    
    
    public boolean iniciarSesion(Usuario usuario) throws PersistenciaException;
    
    public String obtenerTipoUsuario(int id_usuario) throws PersistenciaException;
    
    
    
}
