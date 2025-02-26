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
 * La clase DependencyInyector es responsable de la inyección de dependencias 
 * en el sistema, creando instancias de las clases de negocio (BO) que requieren 
 * una conexión a la base de datos.
 * 
 * Esta clase utiliza el patrón de diseño Singleton para proporcionar una 
 * única instancia de la conexión a la base de datos para todas las clases de negocio.
 * 
 * @author Abraham Coronel
 */
public class DependencyInyector {

    private static final IConexion conexion = new Conexion();

    /**
     * Crea una instancia de CitaBO con la conexión a la base de datos.
     * 
     * @return Una nueva instancia de CitaBO.
     */
    public static CitaBO crearCitaBO() {
        return new CitaBO(conexion);
    }

    /**
     * Crea una instancia de ConsultaBO con la conexión a la base de datos.
     * 
     * @return Una nueva instancia de ConsultaBO.
     */
    public static ConsultaBO crearConsultaBO() {
        return new ConsultaBO(conexion);
    }

    /**
     * Crea una instancia de MedicoBO con la conexión a la base de datos.
     * 
     * @return Una nueva instancia de MedicoBO.
     */
    public static MedicoBO crearMedicoBO() {
        return new MedicoBO(conexion);
    }

    /**
     * Crea una instancia de PacienteBO con la conexión a la base de datos.
     * 
     * @return Una nueva instancia de PacienteBO.
     */
    public static PacienteBO crearPacienteBO() {
        return new PacienteBO(conexion);
    }

    /**
     * Crea una instancia de UsuarioBO con una nueva conexión a la base de datos.
     * 
     * @return Una nueva instancia de UsuarioBO.
     */
    public static UsuarioBO crearUsuarioBO() {
        return new UsuarioBO(new Conexion());
    }

}
