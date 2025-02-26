/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuracion;

import BO.CitaBO;
import BO.ConsultaBO;
import BO.MedicoBO;
import BO.PacienteBO;
import BO.UsuarioBO;
import conexion.Conexion;
import conexion.IConexion;

/**
 *
 * @author Abraham Coronel
 */
public class DependencyInyector {

    private static final IConexion conexion = new Conexion();

    public static CitaBO crearCitaBO() {
        return new CitaBO(conexion);
    }

    public static ConsultaBO crearConsultaBO() {
        return new ConsultaBO(conexion);
    }

    public static MedicoBO crearMedicoBO() {
        return new MedicoBO(conexion);
    }

    public static PacienteBO crearPacienteBO() {
        return new PacienteBO(conexion);
    }

    public static UsuarioBO crearUsuarioBO() {
        return new UsuarioBO(new Conexion());
    }

}
