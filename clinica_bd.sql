CREATE DATABASE IF NOT EXISTS clinica;
USE clinica;

CREATE TABLE usuarios (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20) UNIQUE NOT NULL,
    contrasenia VARCHAR(255) NOT NULL
);

CREATE TABLE pacientes (
    id_paciente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido_paterno VARCHAR(50) NOT NULL,
    apellido_materno VARCHAR(50) NULL,
    direccion VARCHAR(200) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    telefono VARCHAR(16) NOT NULL,
    correo VARCHAR(50) UNIQUE NOT NULL,
    FOREIGN KEY (id_paciente) REFERENCES usuarios(id_usuario)
);

CREATE TABLE medicos (
    id_medico INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido_paterno VARCHAR(50) NOT NULL,
    apellido_materno VARCHAR(50) NULL,
    cedula VARCHAR(15) UNIQUE NOT NULL,
    especialidad VARCHAR(100) NOT NULL,
    estado ENUM('activo', 'inactivo') NOT NULL,
    FOREIGN KEY (id_medico) REFERENCES usuarios(id_usuario)
);

CREATE TABLE horarios_atencion (
    id_horario INT PRIMARY KEY AUTO_INCREMENT,
    dia ENUM('lunes', 'martes','miercoles', 'jueves', 'viernes', 'sabado', 'domingo') NOT NULL,
    hora_entrada TIME NOT NULL,
    hora_salida TIME NOT NULL,
    id_medico INT NOT NULL,
    FOREIGN KEY (id_medico) REFERENCES medicos(id_medico)
);

CREATE TABLE citas (
    id_cita INT PRIMARY KEY AUTO_INCREMENT,
    fecha_hora DATETIME NOT NULL,
    estado ENUM('programada', 'finalizada', 'cancelada', 'no atendida', 'no asistio paciente') NOT NULL,
    folio VARCHAR(8),
    id_medico INT NOT NULL,
    id_paciente INT NOT NULL,
    UNIQUE KEY restriccion_cita (id_medico, id_paciente, fecha_hora), -- Un paciente no puede agendar dos citas en la misma fecha con el mismo médico.
    FOREIGN KEY (id_medico) REFERENCES medicos(id_medico),
    FOREIGN KEY (id_paciente) REFERENCES pacientes(id_paciente)
);

CREATE TABLE consultas (
    id_consulta INT PRIMARY KEY AUTO_INCREMENT,
    fecha_hora DATETIME NOT NULL,
    diagnostico TEXT NOT NULL,
    tratamiento TEXT NOT NULL,
    observaciones TEXT,
    id_cita INT, 
    FOREIGN KEY (id_cita) REFERENCES citas(id_cita)
);

CREATE TABLE auditoria (
    id_auditoria INT PRIMARY KEY AUTO_INCREMENT,
    accion ENUM('cita programada', 'consulta realizada', 'cita cancelada') NOT NULL,
    fecha_hora DATETIME DEFAULT CURRENT_TIMESTAMP,
    id_cita INT,
    FOREIGN KEY (id_cita) REFERENCES citas(id_cita)
);

