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
    IF OLD.estado != 'cancelada' AND (NEW.estado = 'cancelada' OR NEW.estado = 'no atendida') THEN
        INSERT INTO auditoria (accion, fecha_hora, id_cita)
        VALUES ('cita cancelada', NOW(), NEW.id_cita);
    END IF;
END //
DELIMITER ;
drop trigger auditoria_cancelar_citas;

/**
Trigger de auditoría cada vez que se realice una consulta
**/ 
DELIMITER //
CREATE TRIGGER auditoria_consulta
AFTER INSERT ON consultas -- CHECAR EN CITAS
FOR EACH ROW
BEGIN
    INSERT INTO auditoria (accion, fecha_hora, id_cita)
    VALUES ('consulta realizada', NOW(), NEW.id_cita);
END //
DELIMITER ;

/**
Evento para actualizar el estado de las citas cuando no fueron atendidas y cuando no llega el paciente
**/
DELIMITER //
CREATE EVENT actualizar_citas_vencidas
ON SCHEDULE EVERY 1 MINUTE
DO
BEGIN
    -- Marcar como "no atendida" si es emergencia y han pasado 10 minutos
    UPDATE citas 
    SET estado = 'no atendida' 
    WHERE estado = 'programada' 
    AND folio IS NOT NULL 
    AND TIMESTAMPDIFF(MINUTE, fecha_hora, NOW()) > 10;

    -- Marcar como "no asistió paciente" si es cita normal y han pasado 15 minutos
    UPDATE citas 
    SET estado = 'no asistio paciente' 
    WHERE estado = 'programada' 
    AND folio IS NULL 
    AND TIMESTAMPDIFF(MINUTE, fecha_hora, NOW()) > 15;
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










    