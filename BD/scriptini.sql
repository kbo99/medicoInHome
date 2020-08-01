
INSERT INTO `notificacion_bd`.`parametro`
(`prn_id`,
`prn_valor`,
`prn_descripcion`)
VALUES
('TIWILO_MS_USR',
'AC0d506b518801d1adea3d4862b63b7a9a',
'');

INSERT INTO `notificacion_bd`.`parametro`
(`prn_id`,
`prn_valor`,
`prn_descripcion`)
VALUES
('TIWILO_TK_USR',
'e604fb9928bb35647c39c215d348f46b',
'');


INSERT INTO `notificacion_bd`.`parametro`
(`prn_id`,
`prn_valor`,
`prn_descripcion`)
VALUES
('TIWILO_NM_MESS',
'+15103423126',
'');


INSERT INTO `notificacion_bd`.`parametro`
(`prn_id`,
`prn_valor`,
`prn_descripcion`)
VALUES
('URL_SKT_SENDER',
'http://3.130.75.89:8014/mandaDoctor',
'');


INSERT INTO `notificacion_bd`.`parametro`
(`prn_id`,
`prn_valor`,
`prn_descripcion`)
VALUES
('TOPIC_MEDICALL',
'/topic/notify/incomincall/',
'');


INSERT INTO `notificacion_bd`.`parametro`
(`prn_id`,
`prn_valor`,
`prn_descripcion`)
VALUES
('TOPIC_CLICALL',
'/topic/notify/call/',
'');


INSERT INTO `notificacion_bd`.`parametro`
(`prn_id`,
`prn_valor`,
`prn_descripcion`)
VALUES
('TKN_AGORA_CALL',
'29875572d4674ea7a3530526e148ca0e',
'');


INSERT INTO `notificacion_bd`.`parametro`
(`prn_id`,
`prn_valor`,
`prn_descripcion`)
VALUES
('URL_SKT_SENDER_CLIENTE',
'http://3.130.75.89:8014/mandaPaciente',
'');


INSERT INTO `notificacion_bd`.`parametro`
(`prn_id`,
`prn_valor`,
`prn_descripcion`)
VALUES
('URL_SKT_SUSCR',
'http://3.130.75.89:8014/notify',
'');




INSERT INTO `medico_casa`.`tipo_movimiento_membresia`
(`tmm_id`,
`tmm_nombre`)
VALUES
(1,
'ALTA MEMBRESIA');


INSERT INTO `medico_casa`.`tipo_movimiento_membresia`
(`tmm_id`,
`tmm_nombre`)
VALUES
(2,
'ALTA BENEFICIARIO');


INSERT INTO `medico_casa`.`parametro`
(`prm_nombre`,
`prm_valor`,
`prm_descrp`)
VALUES
('URL_SERVICE_SENDER_SING_UP',
'http://3.130.75.89:8090/api/notificacion/sendMessageSingUp',
'');

INSERT INTO `medico_casa`.`parametro`
(`prm_nombre`,
`prm_valor`,
`prm_descrp`)
VALUES
('URL_SERVICE_USUER',
'http://3.130.75.89:8090/api/usuarios/generaUsuario',
'');

INSERT INTO `medico_casa`.`perfil_persona_cliente`
(`ppc_id`,
`ppc_desc`)
VALUES
(1,
'TITULAR');

INSERT INTO `medico_casa`.`perfil_persona_cliente`
(`ppc_id`,
`ppc_desc`)
VALUES
(2,
'BENEFICIARIO');


INSERT INTO `medico_casa`.`persona` (`per_id`, `per_nombre`, `per_ape_mat`, `per_ape_pate`, `per_email`, `per_falta`, `per_telefono`, `per_rfc`) VALUES ('1', 'Administrador', 'Sistema Soporte','Sistema Soporte',  'gdejesus@patito.com', '2020-03-25', '123456789','JEMG850325S38');
INSERT INTO `medico_casa`.`usuario` (`usu_id`, `usu_usuario`, `usu_password`, `usu_estatus`, `per_id`) VALUES ('1', 'admin', '$2a$10$ayw./mJrqAhwXGGJzxscVeB61hQd2BTU15yK5DtlNMiGgr0S/XOuy', 'AC', '1');
INSERT INTO `medico_casa`.`grupo` (`grp_id`, `grp_nombre`, `grp_desc`, `grp_estatus`) VALUES ('1', 'ROLE_ADMIN', 'Administrador', 'A');
INSERT INTO `medico_casa`.`grupo` (`grp_id`, `grp_nombre`, `grp_desc`, `grp_estatus`) VALUES ('2', 'ROLE_USUARIO', 'Usuario', 'A');
INSERT INTO `medico_casa`.`grupo` (`grp_id`, `grp_nombre`, `grp_desc`, `grp_estatus`) VALUES ('3', 'ROLE_CLIENTE', 'Administrador', 'A');
INSERT INTO `medico_casa`.`grupo` (`grp_id`, `grp_nombre`, `grp_desc`, `grp_estatus`) VALUES ('4', 'ROLE_DOCTOR', 'Usuario', 'A');

INSERT INTO `medico_casa`.`usu_grupo`(`usu_id`,`grp_id`) VALUES(1,1);
INSERT INTO `medico_casa`.`usu_grupo`(`usu_id`,`grp_id`) VALUES(1,2);


INSERT INTO `medico_casa`.`menus` (`men_id`, `grp_id`, `men_nombre`, `men_desc`) VALUES ('1', '1', 'Seguridad', 'Menus de Seguridad');

INSERT INTO `medico_casa`.`sub_menus` (`sme_id`,`men_id`,`sme_nombre`,`sme_desc`,`sme_icono`,`sme_url`,`grp_id`,`sme_orden`) VALUES ('1', '1', 'Grupos y Roles', 'Grupos de permisos del sistema', 'fa fa-unlock-alt', NULL, '1', '1');
INSERT INTO `medico_casa`.`sub_menus` (`sme_id`,`men_id`,`sme_nombre`,`sme_desc`,`sme_icono`,`sme_url`,`grp_id`,`sme_orden`) VALUES ('2', NULL, 'Grupos', 'Configuracion de Grupos', 'fa fa-th-list', '/grupos', '2', '1');
INSERT INTO `medico_casa`.`sub_menus` (`sme_id`,`men_id`,`sme_nombre`,`sme_desc`,`sme_icono`,`sme_url`,`grp_id`,`sme_orden`) VALUES ('3', NULL, 'Roles', 'Configuracion de Roles de Usuario', 'fa fa-cog', '', '1', '2');
INSERT INTO `medico_casa`.`sub_menus` (`sme_id`,`men_id`,`sme_nombre`,`sme_desc`,`sme_icono`,`sme_url`,`grp_id`,`sme_orden`) VALUES ('4', NULL, 'Rol de Usuarios', 'Configuracion de roles a usuarios', 'fa fa-bars', '/Roles', '1', '1');
INSERT INTO `medico_casa`.`sub_menus` (`sme_id`,`men_id`,`sme_nombre`,`sme_desc`,`sme_icono`,`sme_url`,`grp_id`,`sme_orden`) VALUES ('5', NULL, 'Menu', 'Configuracion de Menu', 'fa fa-bars', '/menu', '1', '2');

INSERT INTO `medico_casa`.`sub_menus_rel` (`sre_id`, `sme_id_parent`, `sme_id_child`) VALUES ('1', '1', '2');
INSERT INTO `medico_casa`.`sub_menus_rel` (`sre_id`, `sme_id_parent`, `sme_id_child`) VALUES ('2', '1', '3');
INSERT INTO `medico_casa`.`sub_menus_rel` (`sre_id`, `sme_id_parent`, `sme_id_child`) VALUES ('3', '3', '4');



INSERT INTO `medico_casa`.`menus` (`men_id`, `grp_id`, `men_nombre`, `men_desc`) VALUES ('2', '4', 'Doctor', 'Menus de Doctores');

INSERT INTO `medico_casa`.`sub_menus` (`sme_id`,`men_id`,`sme_nombre`,`sme_desc`,`sme_icono`,`sme_url`,`grp_id`,`sme_orden`) VALUES ('7', '2', 'Consultas', 'Consultas a Pacientes', 'fa fa-unlock-alt', NULL, '4', '1');
INSERT INTO `medico_casa`.`sub_menus` (`sme_id`,`men_id`,`sme_nombre`,`sme_desc`,`sme_icono`,`sme_url`,`grp_id`,`sme_orden`) VALUES ('8', NULL, 'Llamadas', 'Configuracion de Grupos', 'fa fa-th-list', '/medicall', '4', '1');

INSERT INTO `medico_casa`.`sub_menus_rel` (`sre_id`, `sme_id_parent`, `sme_id_child`) VALUES ('4', '7', '8');






