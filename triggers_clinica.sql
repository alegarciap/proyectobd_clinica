USE clinica;

/**
Trigger de auditoría cada vez que se programe una cita 
**/ 
DELIMITER //
CREATE TRIGGER auditoria_agendar_cita
AFTER INSERT ON citas
FOR EACH ROW
BEGIN
    INSERT INTO auditoria (accion, fecha_hora, id_cita)
    VALUES ('cita programada', NOW(), NEW.id_cita);
END //
DELIMITER ;

/**
Trigger de auditoría cada vez que se cancele una cita
**/
DELIMITER //
CREATE TRIGGER auditoria_cancelar_citas
AFTER UPDATE ON citas
FOR EACH ROW
BEGIN
    IF OLD.estado != 'cancelada' AND NEW.estado = 'cancelada' THEN
        INSERT INTO auditoria (accion, fecha_hora, id_cita)
        VALUES ('cita cancelada', NOW(), NEW.id_cita);
    END IF;
END //
DELIMITER ;

/**
Trigger de auditoría cada vez que se realice una consulta
**/ 
DELIMITER //
CREATE TRIGGER auditoria_consulta
AFTER INSERT ON consultas
FOR EACH ROW
BEGIN
    INSERT INTO auditoria (accion, fecha_hora, id_cita)
    VALUES ('consulta realizada', NOW(), NEW.id_cita);
END //
DELIMITER ;

/**
Trigger para actualizar el estado de las citas cuando no fueron atendidas y cuando no llega el paciente
**/
DELIMITER //
CREATE TRIGGER actualizar_estado_citas
BEFORE UPDATE ON citas
FOR EACH ROW
BEGIN
    DECLARE hora_actual DATETIME;
    SET hora_actual = NOW(); 
    
    -- Verificar si es una consulta de EMERGENCIA (tiene folio) y han pasado más de 10 minutos
    IF OLD.folio IS NOT NULL AND OLD.estado = 'programada' AND TIMESTAMPDIFF(MINUTE, OLD.fecha_hora, hora_actual) > 10 THEN 
        SET NEW.estado = 'no atendida';
    END IF;
    
    -- Verificar si es una consulta con cita NORMAL (sin folio) y han pasado más de 15 minutos
    IF OLD.folio IS NULL AND OLD.estado = 'programada' AND TIMESTAMPDIFF(MINUTE, OLD.fecha_hora, hora_actual) > 15 THEN 
        SET NEW.estado = 'no asistio paciente';
    END IF;
END //
DELIMITER ;

/**
Trigger para evitar que los pacientes modifiquen sus datos si tienen citas programadas
**/
DELIMITER //
CREATE TRIGGER evitar_actualizacion_pacientes
BEFORE UPDATE ON pacientes
FOR EACH ROW
BEGIN
    DECLARE citas_programadas INT;

    -- Contar cuántas citas programadas tiene el paciente
    SELECT COUNT(*) INTO citas_programadas
    FROM citas
    WHERE id_paciente = OLD.id_paciente AND estado = 'programada';

    -- Si hay citas programadas, imprimir mensaje de error
    IF citas_programadas > 0 THEN
        SIGNAL sqlstate '45000' SET message_text = 'No puede actualizar sus datos porque tiene citas programadas.';
    END IF;
END //
DELIMITER ;










    