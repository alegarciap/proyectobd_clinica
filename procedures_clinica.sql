USE clinica;

/**
Procedimiento para que un cliente agende una cita NORMAL
**/
DELIMITER //
CREATE PROCEDURE agendar_cita(
    IN fecha_hora_cita DATETIME,
    IN id_paciente_cita INT,
    IN id_medico_cita INT
)
BEGIN
    DECLARE contador_citas INT;
    DECLARE horario_valido INT;
    DECLARE fecha_fin_cita DATETIME;
    DECLARE dia_semana INT;
    DECLARE dia_semana_esp VARCHAR(10);

    START TRANSACTION;

    -- Calcular la fecha y hora de finalización de la cita 
    SET fecha_fin_cita = DATE_ADD(fecha_hora_cita, INTERVAL 30 MINUTE);

    -- Obtener el día de la semana pero como número
    SET dia_semana = DAYOFWEEK(fecha_hora_cita); 

    -- Al día de la semana en número se le asigna el día ya en texto para poder comparar
    CASE dia_semana
        WHEN 1 THEN SET dia_semana_esp = 'domingo';
        WHEN 2 THEN SET dia_semana_esp = 'lunes';
        WHEN 3 THEN SET dia_semana_esp = 'martes';
        WHEN 4 THEN SET dia_semana_esp = 'miercoles';
        WHEN 5 THEN SET dia_semana_esp = 'jueves';
        WHEN 6 THEN SET dia_semana_esp = 'viernes';
        WHEN 7 THEN SET dia_semana_esp = 'sabado';
    END CASE;

    -- Validar que el médico tenga un horario de atención ese día y la cita esté dentro de ese rango
    SELECT COUNT(*) INTO horario_valido
    FROM horarios_atencion
    WHERE id_medico = id_medico_cita
    AND dia = dia_semana_texto
    AND TIME(fecha_hora_cita) >= hora_entrada
    AND TIME(fecha_fin_cita) <= hora_salida;

    IF horario_valido = 0 THEN
        ROLLBACK;
        SIGNAL sqlstate '45000' SET message_text = 'La cita está fuera del horario de atención del médico.';
    END IF;

    -- Validar que el médico no tenga otra cita en ese horario
    SELECT COUNT(*) INTO contador_citas
    FROM citas
    WHERE id_medico = id_medico_cita
    AND (
        (fecha_hora BETWEEN fecha_hora_cita AND fecha_fin_cita) OR
        (DATE_ADD(fecha_hora, INTERVAL 30 MINUTE) BETWEEN fecha_hora_cita AND fecha_fin_cita)
    );

    IF contador_citas > 0 THEN
        ROLLBACK;
        SIGNAL sqlstate '45000' SET message_text = 'El médico ya tiene una cita en el horario elegido.';
    END IF;

    -- Validar que el paciente no tenga otra cita con ese médico el mismo día
    SELECT COUNT(*) INTO contador_citas
	FROM citas
	WHERE id_medico = id_medico_cita
	AND id_paciente = id_paciente_cita
	AND DATE(fecha_hora) = DATE(fecha_hora_cita);

    IF contador_citas > 0 THEN
        ROLLBACK;
        SIGNAL sqlstate '45000' SET message_text = 'No se puede agendar más de una cita con el mismo médico el mismo día.';
    END IF;

    -- Después de tooooodas las validaciones, agregar la cita
    INSERT INTO citas (fecha_hora, estado, folio, id_medico, id_paciente)
    VALUES (fecha_hora_cita, 'programada', NULL, id_medico_cita, id_paciente_cita);
    
    COMMIT;
END //
DELIMITER ;

/**
Procedimiento para que un cliente agende una cita de emergencia
**/
DELIMITER //
CREATE PROCEDURE agendar_cita_emergencia(
    IN id_paciente_cita INT
)
BEGIN
    DECLARE id_medico_disponible INT;
    DECLARE folio_emergencia CHAR(8);
    DECLARE ahora DATETIME;
    DECLARE dia_actual VARCHAR(10);
    DECLARE contador_medicos INT;

    START TRANSACTION;

    -- Obtener la fecha y hora en este momento
    SET ahora = NOW();

    -- Al día de la semana en número se le asigna el día ya en texto para poder comparar
    SET dia_actual = CASE DAYOFWEEK(ahora)
        WHEN 1 THEN 'domingo'
        WHEN 2 THEN 'lunes'
        WHEN 3 THEN 'martes'
        WHEN 4 THEN 'miercoles'
        WHEN 5 THEN 'jueves'
        WHEN 6 THEN 'viernes'
        WHEN 7 THEN 'sabado'
    END;

    -- Buscar un médico disponible en este momento
    SELECT id_medico INTO id_medico_disponible
    FROM horarios_atencion
    WHERE dia = dia_actual
      AND hora_entrada <= TIME(ahora)
      AND hora_salida > TIME(ahora)
      AND id_medico NOT IN (
          SELECT id_medico FROM citas 
          WHERE fecha_hora BETWEEN ahora AND DATE_ADD(ahora, INTERVAL 30 MINUTE)
      )
    LIMIT 1;

    SELECT COUNT(*) INTO contador_medicos FROM horarios_atencion
    WHERE dia = dia_actual
      AND hora_entrada <= TIME(ahora)
      AND hora_salida > TIME(ahora);

    IF (contador_medicos = 0 OR id_medico_disponible IS NULL) THEN
        SIGNAL sqlstate '45000' SET message_text = 'No hay médicos disponibles en este momento.';
    END IF;

    -- Generar el folio aleatorio 
    SET folio_emergencia = LPAD(FLOOR(RAND() * 100000000), 8, '0');

    -- Ahora si, insertar la cita de emergencia
    INSERT INTO citas (fecha_hora, estado, folio, id_medico, id_paciente)
    VALUES (ahora, 'programada', folio_emergencia, id_medico_disponible, id_paciente_cita)
    ON DUPLICATE KEY UPDATE folio = folio; -- No insertar si ya hay una cita con el mismo médico y paciente

    COMMIT;
END //
DELIMITER ;

/**
Procedimiento para que un cliente cancele una cita
**/

/**
Procedimiento para que un cliente cancele una cita
**/

/**
Procedimiento para registrar un paciente
**/

/**
Procedimiento para dar de baja a un médico
**/

/**
Procedimiento para modificar un paciente
**/

    
    
    
    


