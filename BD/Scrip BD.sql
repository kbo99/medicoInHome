-- MySQL Workbench Synchronization
-- Generated: 2020-07-04 17:31
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: rgarciaq

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `medico_casa` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `medico_casa`.`cotizacion` (
  `cot_id` INT(11) NOT NULL AUTO_INCREMENT,
  `cot_fecha_registro` DATETIME NOT NULL,
  `cot_total` DECIMAL(12,4) NOT NULL,
  `cot_iva` DECIMAL(12,4) NULL DEFAULT NULL,
  `cot_observacion` VARCHAR(250) NULL DEFAULT NULL,
  `ctesta_id` INT(11) NULL DEFAULT NULL,
  `usu_clave` VARCHAR(45) NOT NULL,
  `clien_id` INT(11) NULL DEFAULT NULL,
  `cot_es_prospecto` VARCHAR(1) NOT NULL DEFAULT 'F',
  `cot_nombre_pros` VARCHAR(100) NULL DEFAULT NULL,
  `cot_rfc_prospecto` VARCHAR(45) NULL DEFAULT NULL,
  `cot_mail_prospecto` VARCHAR(80) NULL DEFAULT NULL,
  `cot_telefono_prospecto` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`cot_id`),
  INDEX `ctesta_id_cot_fk_idx` (`ctesta_id` ASC) VISIBLE,
  CONSTRAINT `ctesta_id_cot_fk`
    FOREIGN KEY (`ctesta_id`)
    REFERENCES `medico_casa`.`cotizacion_estatus` (`ctesta_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`cotizacion_estatus` (
  `ctesta_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ctesta_nombre` VARCHAR(80) NOT NULL,
  `ctesta_descrp` VARCHAR(250) NULL DEFAULT NULL,
  PRIMARY KEY (`ctesta_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`producto` (
  `prod_id` INT(11) NOT NULL AUTO_INCREMENT,
  `prod_nombre` VARCHAR(100) NOT NULL,
  `prod_descrip` VARCHAR(250) NULL DEFAULT NULL,
  `prod_costo_compra` DECIMAL(12,6) NULL DEFAULT NULL,
  `prod_costo_venta` DECIMAL(12,6) NOT NULL,
  `prod_estatus` VARCHAR(5) NOT NULL,
  `prod_fecha_registro` DATE NOT NULL,
  `tpoprod_id` INT(11) NULL DEFAULT NULL,
  `prod_existencia_min` INT(11) NULL DEFAULT NULL,
  `prod_clave` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`prod_id`, `prod_nombre`, `prod_fecha_registro`),
  INDEX `tpopro_id_idx` (`tpoprod_id` ASC) VISIBLE,
  CONSTRAINT `tpopro_id_prod_fk`
    FOREIGN KEY (`tpoprod_id`)
    REFERENCES `medico_casa`.`tipo_producto` (`tpoprod_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`tipo_producto` (
  `tpoprod_id` INT(11) NOT NULL AUTO_INCREMENT,
  `tpoprod_nombre` VARCHAR(100) NULL DEFAULT NULL,
  `tpoprod_decrip` VARCHAR(250) NULL DEFAULT NULL,
  `tpoprod_estatus` VARCHAR(2) NOT NULL DEFAULT 'AC',
  PRIMARY KEY (`tpoprod_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`detalle_cotizacion` (
  `dtc_id` INT(11) NOT NULL AUTO_INCREMENT,
  `pro_id` INT(11) NULL DEFAULT NULL,
  `dtc_cantidad` INT(11) NOT NULL,
  `dtc_monto` DECIMAL(16,4) NOT NULL,
  `cot_id` INT(11) NOT NULL,
  `dtc_iva` DECIMAL(16,4) NULL DEFAULT NULL,
  `dtc_monto_desc` DECIMAL(16,4) NULL DEFAULT NULL,
  `dtc_descuento` DECIMAL(16,4) NULL DEFAULT NULL,
  PRIMARY KEY (`dtc_id`),
  INDEX `proCorDetFK_idx` (`pro_id` ASC) VISIBLE,
  INDEX `cotDetFK_idx` (`cot_id` ASC) VISIBLE,
  CONSTRAINT `proCorDetFK`
    FOREIGN KEY (`pro_id`)
    REFERENCES `medico_casa`.`producto` (`prod_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cotDetFK`
    FOREIGN KEY (`cot_id`)
    REFERENCES `medico_casa`.`cotizacion` (`cot_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`direccion` (
  `dir_id` INT(11) NOT NULL AUTO_INCREMENT,
  `col_id` INT(11) NULL DEFAULT NULL,
  `dir_calle` VARCHAR(90) NOT NULL,
  `dir_entre_calle_uno` VARCHAR(90) NULL DEFAULT NULL,
  `dir_entre_calle_dos` VARCHAR(90) NULL DEFAULT NULL,
  `dir_num_ext` VARCHAR(10) NULL DEFAULT NULL,
  `dir_num_int` VARCHAR(10) NULL DEFAULT NULL,
  `dir_referencias` VARCHAR(280) NULL DEFAULT NULL,
  `dir_falta` DATETIME NOT NULL,
  PRIMARY KEY (`dir_id`),
  INDEX `coldirFK_idx` (`col_id` ASC) VISIBLE,
  CONSTRAINT `coldirFK`
    FOREIGN KEY (`col_id`)
    REFERENCES `medico_casa`.`colonia` (`col_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`entidad` (
  `ent_id` VARCHAR(2) NOT NULL,
  `ent_nom` VARCHAR(50) NOT NULL,
  `pai_id` INT(11) NOT NULL,
  `ent_abr` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ent_id`),
  INDEX `paientFK_idx` (`pai_id` ASC) VISIBLE,
  CONSTRAINT `paientFK`
    FOREIGN KEY (`pai_id`)
    REFERENCES `medico_casa`.`pais` (`pai_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`pais` (
  `pai_id` INT(11) NOT NULL AUTO_INCREMENT,
  `pai_nombre` VARCHAR(70) NOT NULL,
  `pai_abre` VARCHAR(45) NULL DEFAULT NULL,
  `rep_id` INT(11) NOT NULL,
  PRIMARY KEY (`pai_id`),
  INDEX `repaisFK_idx` (`rep_id` ASC) VISIBLE,
  CONSTRAINT `repaisFK`
    FOREIGN KEY (`rep_id`)
    REFERENCES `medico_casa`.`region_pais` (`rep_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`region_pais` (
  `rep_id` INT(11) NOT NULL AUTO_INCREMENT,
  `rep_nombre` VARCHAR(45) NOT NULL,
  `rep_desc` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`rep_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`municipio` (
  `mun_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nom_mun` VARCHAR(120) NOT NULL,
  `mun_abr` VARCHAR(45) NULL DEFAULT NULL,
  `ent_id` VARCHAR(2) NOT NULL,
  `cve_mun` VARCHAR(5) NULL DEFAULT NULL,
  `cve_cab` VARCHAR(5) NULL DEFAULT NULL,
  `nom_cab` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`mun_id`),
  INDEX `entmunFK_idx` (`ent_id` ASC) VISIBLE,
  CONSTRAINT `entmunFK`
    FOREIGN KEY (`ent_id`)
    REFERENCES `medico_casa`.`entidad` (`ent_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`colonia` (
  `col_id` INT(11) NOT NULL AUTO_INCREMENT,
  `mun_id` INT(11) NOT NULL,
  `col_nom` VARCHAR(100) NOT NULL,
  `col_cp` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`col_id`),
  INDEX `FK_col_mun_idx` (`mun_id` ASC) VISIBLE,
  CONSTRAINT `FK_col_mun`
    FOREIGN KEY (`mun_id`)
    REFERENCES `medico_casa`.`municipio` (`mun_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`grupo` (
  `grp_id` INT(11) NOT NULL AUTO_INCREMENT,
  `grp_nombre` VARCHAR(15) NOT NULL,
  `grp_desc` VARCHAR(45) NULL DEFAULT NULL,
  `grp_estatus` VARCHAR(1) NULL DEFAULT NULL,
  `grp_auto_cotiza` VARCHAR(1) NULL DEFAULT 'F',
  `grp_auto_pedido` VARCHAR(1) NULL DEFAULT 'F',
  PRIMARY KEY (`grp_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`usuario` (
  `usu_id` INT(11) NOT NULL AUTO_INCREMENT,
  `usu_usuario` VARCHAR(30) NOT NULL,
  `usu_password` VARCHAR(150) NOT NULL,
  `usu_estatus` VARCHAR(2) NULL DEFAULT NULL,
  `per_id` INT(11) NOT NULL,
  PRIMARY KEY (`usu_id`),
  INDEX `FKper_usu_idx_idx` (`per_id` ASC) VISIBLE,
  CONSTRAINT `FKper_usu_idx`
    FOREIGN KEY (`per_id`)
    REFERENCES `medico_casa`.`persona` (`per_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`usu_grupo` (
  `usu_id` INT(11) NOT NULL,
  `grp_id` INT(11) NULL DEFAULT NULL,
  INDEX `fkgrupo_usu_id_idx` (`usu_id` ASC) VISIBLE,
  INDEX `fkusugrupo_id_idx` (`grp_id` ASC) VISIBLE,
  CONSTRAINT `fkgrupo_usu_id`
    FOREIGN KEY (`usu_id`)
    REFERENCES `medico_casa`.`usuario` (`usu_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkusugrupo_id`
    FOREIGN KEY (`grp_id`)
    REFERENCES `medico_casa`.`grupo` (`grp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`persona` (
  `per_id` INT(11) NOT NULL AUTO_INCREMENT,
  `per_nombre` VARCHAR(50) NOT NULL,
  `per_ape_mat` VARCHAR(45) NULL DEFAULT NULL,
  `per_ape_pate` VARCHAR(45) NULL DEFAULT NULL,
  `per_email` VARCHAR(45) NULL DEFAULT NULL,
  `per_falta` DATE NOT NULL,
  `per_rfc` VARCHAR(45) NULL DEFAULT NULL,
  `per_fnacimiento` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`per_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`tipo_direccion` (
  `tpd_id` INT(11) NOT NULL AUTO_INCREMENT,
  `tpd_nombre` VARCHAR(55) NOT NULL,
  `tpd_desc` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`tpd_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`cliente_direccion` (
  `cld_id` INT(11) NOT NULL AUTO_INCREMENT,
  `dir_id` INT(11) NOT NULL,
  `tpd_id` INT(11) NOT NULL,
  `cpe_id` INT(11) NOT NULL,
  `cld_activa` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`cld_id`),
  INDEX `tpd_idFKtpd_id_idx` (`tpd_id` ASC) VISIBLE,
  INDEX `dir_idFKdir_id_idx` (`dir_id` ASC) VISIBLE,
  INDEX `cli_idFKcli_id_idx` (`cpe_id` ASC) VISIBLE,
  CONSTRAINT `cli_idFKcli_id`
    FOREIGN KEY (`cpe_id`)
    REFERENCES `medico_casa`.`cliente_persona` (`cpe_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tpd_idFKtpd_id`
    FOREIGN KEY (`tpd_id`)
    REFERENCES `medico_casa`.`tipo_direccion` (`tpd_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `dir_idFKdir_id`
    FOREIGN KEY (`dir_id`)
    REFERENCES `medico_casa`.`direccion` (`dir_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`cliente` (
  `cli_id` INT(11) NOT NULL AUTO_INCREMENT,
  `cli_rfc` VARCHAR(50) NOT NULL,
  `cli_fregistro` DATETIME NOT NULL,
  `usu_registra` VARCHAR(25) NOT NULL,
  `cli_nom_corto` VARCHAR(100) NULL DEFAULT NULL,
  `cli_fultima_op` DATETIME NOT NULL,
  `tpc_id` INT(11) NULL DEFAULT NULL,
  `cli_obs` VARCHAR(240) NULL DEFAULT NULL,
  `cli_web_fac` VARCHAR(100) NULL DEFAULT NULL,
  `cli_email` VARCHAR(100) NULL DEFAULT NULL,
  `cli_estatus` CHAR(2) NULL DEFAULT 'AC',
  PRIMARY KEY (`cli_id`),
  INDEX `tpc_id_cli_FK _idx` (`tpc_id` ASC) VISIBLE,
  CONSTRAINT `tpc_id_cli_FK `
    FOREIGN KEY (`tpc_id`)
    REFERENCES `medico_casa`.`tipo_persona_clie` (`tpc_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`perfil_persona_cliente` (
  `ppc_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ppc_desc` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ppc_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`cliente_persona` (
  `cpe_id` INT(11) NOT NULL AUTO_INCREMENT,
  `cli_id` INT(11) NOT NULL,
  `per_id` INT(11) NOT NULL,
  `ppc_id` INT(11) NOT NULL,
  `cpe_fregistro` DATETIME NOT NULL,
  `cpe_fultima_mod` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`cpe_id`),
  INDEX `cli_id_per_FK_idx` (`cli_id` ASC) VISIBLE,
  INDEX `per_id_cli_FK_idx` (`per_id` ASC) VISIBLE,
  INDEX `ppc_id_FK_cli_idx` (`ppc_id` ASC) VISIBLE,
  CONSTRAINT `cli_id_per_FK`
    FOREIGN KEY (`cli_id`)
    REFERENCES `medico_casa`.`cliente` (`cli_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `per_id_cli_FK`
    FOREIGN KEY (`per_id`)
    REFERENCES `medico_casa`.`persona` (`per_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ppc_id_FK_cli`
    FOREIGN KEY (`ppc_id`)
    REFERENCES `medico_casa`.`perfil_persona_cliente` (`ppc_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`tipo_persona_clie` (
  `tpc_id` INT(11) NOT NULL AUTO_INCREMENT,
  `tpc_desc` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`tpc_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`parametro` (
  `prm_id` INT(11) NOT NULL AUTO_INCREMENT,
  `prm_nombre` VARCHAR(55) NULL DEFAULT NULL,
  `prm_valor` VARCHAR(180) NULL DEFAULT NULL,
  `prm_descrp` VARCHAR(250) NULL DEFAULT NULL,
  PRIMARY KEY (`prm_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`hproducto` (
  `hps_id` INT(11) NOT NULL AUTO_INCREMENT,
  `prod_id` INT(11) NOT NULL,
  `hps_cantidad_movimiento` INT(11) NOT NULL,
  `hps_fecha` DATETIME NOT NULL,
  `tmp_id` INT(11) NOT NULL,
  `hps_cant_anterior` INT(11) NULL DEFAULT NULL,
  `usuario` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`hps_id`),
  INDEX `hps_tpm_FK_idx` (`tmp_id` ASC) VISIBLE,
  INDEX `prod_FK_idx` (`prod_id` ASC) VISIBLE,
  CONSTRAINT `hps_tpm_FK`
    FOREIGN KEY (`tmp_id`)
    REFERENCES `medico_casa`.`tpo_movimiento_producto` (`tmp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `prod_FK`
    FOREIGN KEY (`prod_id`)
    REFERENCES `medico_casa`.`producto` (`prod_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`tpo_movimiento_producto` (
  `tmp_id` INT(11) NOT NULL AUTO_INCREMENT,
  `tmp_nombre` VARCHAR(45) NOT NULL,
  `tmp_desc` VARCHAR(20) NULL DEFAULT NULL,
  `tmp_estatus` VARCHAR(2) NOT NULL DEFAULT 'AC',
  `tmp_suma` VARCHAR(1) NOT NULL DEFAULT 'V',
  PRIMARY KEY (`tmp_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`tipo_pago` (
  `tpp_id` INT(11) NOT NULL AUTO_INCREMENT,
  `tpp_nombre` VARCHAR(45) NOT NULL,
  `tpp_desc` VARCHAR(250) NULL DEFAULT NULL,
  `tpp_estatus` VARCHAR(2) NOT NULL,
  `tpp_genera_tarea` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`tpp_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`pago` (
  `pag_id` INT(11) NOT NULL AUTO_INCREMENT,
  `tpp_id` INT(11) NOT NULL,
  `pag_monto` DECIMAL(16,4) NOT NULL,
  `pag_fecha_limite` DATE NOT NULL,
  `pag_fecha_realizo` DATETIME NULL DEFAULT NULL,
  `pgs_id` INT(11) NOT NULL,
  `pag_referencia` VARCHAR(250) NULL DEFAULT NULL,
  `pag_observaciones` VARCHAR(250) NULL DEFAULT NULL,
  `fpa_id` INT(11) NOT NULL,
  `usu_registra` VARCHAR(45) NOT NULL,
  `cue_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`pag_id`),
  INDEX `FK_tpp_ven_idx` (`tpp_id` ASC) VISIBLE,
  INDEX `pgs_FK_idx` (`pgs_id` ASC) VISIBLE,
  INDEX `fpa_FK_idx` (`fpa_id` ASC) VISIBLE,
  CONSTRAINT `FK_tpp_ven`
    FOREIGN KEY (`tpp_id`)
    REFERENCES `medico_casa`.`tipo_pago` (`tpp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `pgs_FK`
    FOREIGN KEY (`pgs_id`)
    REFERENCES `medico_casa`.`pago_estatus` (`pgs_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fpa_FK`
    FOREIGN KEY (`fpa_id`)
    REFERENCES `medico_casa`.`forma_pago` (`fpa_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`pago_estatus` (
  `pgs_id` INT(11) NOT NULL AUTO_INCREMENT,
  `pgs_nombre` VARCHAR(45) NOT NULL,
  `pgs_default` VARCHAR(1) NOT NULL,
  `pgs_estatus` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`pgs_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`forma_pago` (
  `fpa_id` INT(11) NOT NULL AUTO_INCREMENT,
  `fpa_nombre` VARCHAR(45) NOT NULL,
  `fpa_descrp` VARCHAR(250) NULL DEFAULT NULL,
  `fpa_estatus` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`fpa_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`tipo_servicio` (
  `tps_id` INT(11) NOT NULL AUTO_INCREMENT,
  `tps_nombre` VARCHAR(45) NOT NULL,
  `tps_desc` VARCHAR(250) NULL DEFAULT NULL,
  `tps_estatus` VARCHAR(2) NOT NULL,
  `tps_solo_prov` VARCHAR(1) NOT NULL,
  `tps_opera_ambos` VARCHAR(1) NOT NULL,
  `tps_codigo` VARCHAR(45) NULL DEFAULT NULL,
  `tps_fecha` DATE NOT NULL,
  `usu_registra` VARCHAR(85) NOT NULL,
  PRIMARY KEY (`tps_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`servicio_estatus` (
  `ses_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ses_nombre` VARCHAR(45) NOT NULL,
  `ses_desc` VARCHAR(250) NULL DEFAULT NULL,
  `ses_estatus` VARCHAR(2) NULL DEFAULT NULL,
  PRIMARY KEY (`ses_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`servicio` (
  `ser_id` INT(11) NOT NULL AUTO_INCREMENT,
  `tps_id` INT(11) NOT NULL,
  `ses_id` INT(11) NOT NULL,
  `ser_fecha_inicio` DATETIME NOT NULL,
  `ser_fecha_fin` DATETIME NOT NULL,
  `ser_observa` VARCHAR(250) NULL DEFAULT NULL,
  `ser_horario_in` DATETIME NULL DEFAULT NULL,
  `ser_horario_fin` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`ser_id`),
  INDEX `tps_FK_ser_idx` (`tps_id` ASC) VISIBLE,
  INDEX `ss_FK_ser_idx` (`ses_id` ASC) VISIBLE,
  CONSTRAINT `tps_FK_ser`
    FOREIGN KEY (`tps_id`)
    REFERENCES `medico_casa`.`tipo_servicio` (`tps_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ss_FK_ser`
    FOREIGN KEY (`ses_id`)
    REFERENCES `medico_casa`.`servicio_estatus` (`ses_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`paciente` (
  `pac_id` INT(11) NOT NULL AUTO_INCREMENT,
  `cpe_id` INT(11) NOT NULL,
  `pac_tpo_sangre` VARCHAR(15) NULL DEFAULT NULL,
  `pac_fnacimiento` DATE NULL DEFAULT NULL,
  `pac_sexo` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`pac_id`),
  INDEX `CPE_PAC_FK_idx` (`cpe_id` ASC) VISIBLE,
  CONSTRAINT `CPE_PAC_FK`
    FOREIGN KEY (`cpe_id`)
    REFERENCES `medico_casa`.`cliente_persona` (`cpe_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`tipo_enfermedad` (
  `ten_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ten_nombre` VARCHAR(150) NOT NULL,
  `ten_desc` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`ten_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`enfermedad` (
  `enf_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ten_id` INT(11) NOT NULL,
  `enf_nombre` VARCHAR(150) NOT NULL,
  `enf_desc` VARCHAR(250) NULL DEFAULT NULL,
  `enf_cronica` VARCHAR(1) NOT NULL,
  `esp_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`enf_id`),
  INDEX `enf_id` (`enf_id` ASC, `ten_id` ASC) VISIBLE,
  INDEX `TEN_ENF_FK_idx` (`ten_id` ASC) VISIBLE,
  INDEX `esp_id` (`esp_id` ASC) VISIBLE,
  CONSTRAINT `TEN_ENF_FK`
    FOREIGN KEY (`ten_id`)
    REFERENCES `medico_casa`.`tipo_enfermedad` (`ten_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ESP_ENF_FK`
    FOREIGN KEY (`esp_id`)
    REFERENCES `medico_casa`.`especialidad` (`esp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`doctor` (
  `doc_id` INT(11) NOT NULL AUTO_INCREMENT,
  `per_id` INT(11) NULL DEFAULT NULL,
  `doc_cedula` VARCHAR(250) NOT NULL,
  `doc_descripcion` VARCHAR(350) NULL DEFAULT NULL,
  PRIMARY KEY (`doc_id`),
  INDEX `dooc_id` (`doc_id` ASC) VISIBLE,
  INDEX `per_id_doc` (`per_id` ASC) VISIBLE,
  CONSTRAINT `PER_DOC_FK`
    FOREIGN KEY (`per_id`)
    REFERENCES `medico_casa`.`persona` (`per_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`especialidad` (
  `esp_id` INT(11) NOT NULL AUTO_INCREMENT,
  `esp_nombre` VARCHAR(250) NOT NULL,
  `esp_desc` VARCHAR(250) NULL DEFAULT NULL,
  PRIMARY KEY (`esp_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`doc_especial` (
  `doc_id` INT(11) NOT NULL,
  `esp_id` INT(11) NOT NULL,
  PRIMARY KEY (`doc_id`, `esp_id`),
  INDEX `ESP_FK_ESP_idx` (`esp_id` ASC) VISIBLE,
  CONSTRAINT `DOC_FK_ESP`
    FOREIGN KEY (`doc_id`)
    REFERENCES `medico_casa`.`doctor` (`doc_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ESP_FK_ESP`
    FOREIGN KEY (`esp_id`)
    REFERENCES `medico_casa`.`especialidad` (`esp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`contacto_doctor` (
  `cod_id` INT(11) NOT NULL,
  `doc_id` INT(11) NULL DEFAULT NULL,
  `ctn_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`cod_id`),
  INDEX `cod_ID_IND` (`cod_id` ASC) VISIBLE,
  INDEX `doc_FK_COD` (`doc_id` ASC) VISIBLE,
  INDEX `ctn_cofd_FK_idx` (`ctn_id` ASC) VISIBLE,
  CONSTRAINT `DOC_FK_COD`
    FOREIGN KEY (`doc_id`)
    REFERENCES `medico_casa`.`doctor` (`doc_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ctn_cofd_FK`
    FOREIGN KEY (`ctn_id`)
    REFERENCES `medico_casa`.`contacto` (`ctn_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`doctor_paciente_pref` (
  `dpp_id` INT(11) NOT NULL AUTO_INCREMENT,
  `doc_id` INT(11) NOT NULL,
  `pac_id` INT(11) NOT NULL,
  `dpp_activo` VARCHAR(1) NOT NULL,
  `dpp_fregistro` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`dpp_id`),
  INDEX `DOC_CP_IND` (`doc_id` ASC) VISIBLE,
  INDEX `PAC_CD_IND` (`pac_id` ASC) VISIBLE,
  CONSTRAINT `PAC_DP_FK`
    FOREIGN KEY (`pac_id`)
    REFERENCES `medico_casa`.`paciente` (`pac_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `DOC_DP_FK`
    FOREIGN KEY (`doc_id`)
    REFERENCES `medico_casa`.`doctor` (`doc_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`consulta` (
  `con_id` INT(11) NOT NULL AUTO_INCREMENT,
  `con_fregsitro` DATE NOT NULL,
  `con_fecha_consulta` DATETIME NOT NULL,
  `doc_id` INT(11) NOT NULL,
  `pac_id` INT(11) NOT NULL,
  `mec_id` INT(11) NOT NULL,
  `usu_registra` VARCHAR(150) NOT NULL,
  `con_pac_peso` DECIMAL NULL DEFAULT NULL,
  `con_pac_edad` INT(11) NULL DEFAULT NULL,
  `con_pac_estatura` DECIMAL NULL DEFAULT NULL,
  `coe_id` INT(11) NOT NULL,
  PRIMARY KEY (`con_id`),
  INDEX `con_INDEX` (`con_id` ASC) VISIBLE,
  INDEX `MEC_INDEX` (`mec_id` ASC) VISIBLE,
  INDEX `DOC_CON_IN` (`doc_id` ASC) VISIBLE,
  INDEX `PAC_DOC_ON` (`pac_id` ASC) VISIBLE,
  INDEX `COE_CON_IND` (`coe_id` ASC) VISIBLE,
  CONSTRAINT `CON_DOC_FK`
    FOREIGN KEY (`doc_id`)
    REFERENCES `medico_casa`.`doctor` (`doc_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `CON_PAC_FK`
    FOREIGN KEY (`pac_id`)
    REFERENCES `medico_casa`.`paciente` (`pac_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `CON_MEC_FK`
    FOREIGN KEY (`mec_id`)
    REFERENCES `medico_casa`.`medio_consulta` (`mec_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `COE_CON_FK`
    FOREIGN KEY (`coe_id`)
    REFERENCES `medico_casa`.`consulta_estatus` (`coe_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`medio_consulta` (
  `mec_id` INT(11) NOT NULL AUTO_INCREMENT,
  `mec_nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`mec_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`diagnostico_consulta` (
  `dic_id` INT(11) NOT NULL AUTO_INCREMENT,
  `con_id` INT(11) NOT NULL,
  `dic_observacion` VARCHAR(450) NOT NULL,
  `enf_id` INT(11) NULL DEFAULT NULL,
  `dic_sintomas` VARCHAR(450) NOT NULL,
  PRIMARY KEY (`dic_id`),
  INDEX `CON_DIC_FK_idx` (`con_id` ASC) VISIBLE,
  CONSTRAINT `CON_DIC_FK`
    FOREIGN KEY (`con_id`)
    REFERENCES `medico_casa`.`consulta` (`con_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`insumo_consulta` (
  `inc_id` INT(11) NOT NULL AUTO_INCREMENT,
  `prod_id` INT(11) NOT NULL,
  `inc_cantidad` INT(11) NOT NULL,
  `inc_costo_unit` DECIMAL(16,4) NOT NULL,
  `inc_costo_total` DECIMAL(16,4) NOT NULL,
  `con_id` INT(11) NOT NULL,
  PRIMARY KEY (`inc_id`),
  INDEX `PROD_IND_IN` (`prod_id` ASC) VISIBLE,
  INDEX `CON_INS_IND` (`con_id` ASC) VISIBLE,
  CONSTRAINT `PROD_INS_FK`
    FOREIGN KEY (`prod_id`)
    REFERENCES `medico_casa`.`producto` (`prod_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `CON_INS_FK`
    FOREIGN KEY (`con_id`)
    REFERENCES `medico_casa`.`consulta` (`con_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`servicio_consulta` (
  `src_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ser_id` INT(11) NOT NULL,
  `con_id` INT(11) NOT NULL,
  `src_costo` DECIMAL(16,4) NOT NULL,
  PRIMARY KEY (`src_id`),
  INDEX `SER_SRC_FK_idx` (`ser_id` ASC) VISIBLE,
  INDEX `CON_SRC_FK_idx` (`con_id` ASC) VISIBLE,
  CONSTRAINT `SER_SRC_FK`
    FOREIGN KEY (`ser_id`)
    REFERENCES `medico_casa`.`servicio` (`ser_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `CON_SRC_FK`
    FOREIGN KEY (`con_id`)
    REFERENCES `medico_casa`.`consulta` (`con_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`servicio_paciente` (
  `srp_id` INT(11) NOT NULL AUTO_INCREMENT,
  `pac_id` INT(11) NOT NULL,
  `ser_id` INT(11) NOT NULL,
  `srp_costo` DECIMAL(16,4) NOT NULL,
  `srp_aplica_ben` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`srp_id`),
  INDEX `SER_SRP_IN` (`ser_id` ASC) VISIBLE,
  INDEX `PAC_SRP_IN` (`pac_id` ASC) VISIBLE,
  CONSTRAINT `SER_SRP_FK`
    FOREIGN KEY (`ser_id`)
    REFERENCES `medico_casa`.`servicio` (`ser_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `PAC_SRP_FK`
    FOREIGN KEY (`pac_id`)
    REFERENCES `medico_casa`.`paciente` (`pac_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`receta_consulta` (
  `rcc_id` INT(11) NOT NULL AUTO_INCREMENT,
  `rcc_vigencia` DATE NOT NULL,
  `con_id` INT(11) NOT NULL,
  `rcc_surte_farmacia` VARCHAR(1) NOT NULL,
  `rcc_observciones_gral` VARCHAR(450) NULL DEFAULT NULL,
  PRIMARY KEY (`rcc_id`),
  INDEX `con_fk_rcc` (`con_id` ASC) VISIBLE,
  CONSTRAINT `con_rcc_fk`
    FOREIGN KEY (`con_id`)
    REFERENCES `medico_casa`.`consulta` (`con_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`detalle_receta_consulta` (
  `drc_id` INT(11) NOT NULL AUTO_INCREMENT,
  `rcc_id` INT(11) NOT NULL,
  `drc_medicamento` VARCHAR(45) NULL DEFAULT NULL,
  `drc_indicaciones` VARCHAR(250) NULL DEFAULT NULL,
  PRIMARY KEY (`drc_id`),
  INDEX `rcc_ind_drc` (`rcc_id` ASC) VISIBLE,
  CONSTRAINT `rcc_dr_FK`
    FOREIGN KEY (`rcc_id`)
    REFERENCES `medico_casa`.`receta_consulta` (`rcc_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`hservicio` (
  `hse_id` INT(11) NOT NULL AUTO_INCREMENT,
  `hse_hora_cambio_estatu` DATETIME NOT NULL,
  `hse_estatus_ser_old` VARCHAR(45) NOT NULL,
  `hse_estatus_ser_new` VARCHAR(45) NOT NULL,
  `hse_observacion` VARCHAR(350) NOT NULL,
  `usu_reporta` VARCHAR(85) NOT NULL,
  `ser_id` INT(11) NOT NULL,
  PRIMARY KEY (`hse_id`),
  INDEX `SER_HSR_IN` (`ser_id` ASC) VISIBLE,
  CONSTRAINT `SER_HSER_FK`
    FOREIGN KEY (`ser_id`)
    REFERENCES `medico_casa`.`servicio` (`ser_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`contacto` (
  `ctn_id` INT(11) NOT NULL,
  `dir_id` INT(11) NULL DEFAULT NULL,
  `ctn_activo` VARCHAR(1) NULL DEFAULT NULL,
  `ctn_telefo` VARCHAR(45) NULL DEFAULT NULL,
  `ctn_celular` VARCHAR(45) NULL DEFAULT NULL,
  `ctn_tel_asis` VARCHAR(45) NULL DEFAULT NULL,
  `ctn_horario` DATETIME NOT NULL,
  PRIMARY KEY (`ctn_id`),
  INDEX `cod_ID_IND` (`ctn_id` ASC) VISIBLE,
  INDEX `dir_FK_COD` (`dir_id` ASC) VISIBLE,
  CONSTRAINT `DIR_FK_COD0`
    FOREIGN KEY (`dir_id`)
    REFERENCES `medico_casa`.`direccion` (`dir_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`farmacia` (
  `far_id` INT(11) NOT NULL AUTO_INCREMENT,
  `far_nombre` VARCHAR(150) NOT NULL,
  `far_activa` VARCHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`far_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`contacto_farmacia` (
  `cof_id` INT(11) NOT NULL AUTO_INCREMENT,
  `far_id` INT(11) NOT NULL,
  `ctn_id` INT(11) NOT NULL,
  `cof_descp` VARCHAR(250) NULL DEFAULT NULL,
  `ctn_nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cof_id`),
  INDEX `FAR_CNT_IND` (`far_id` ASC) VISIBLE,
  INDEX `ctn_FK_ct_idx` (`ctn_id` ASC) VISIBLE,
  CONSTRAINT `ctn_FK_ct`
    FOREIGN KEY (`ctn_id`)
    REFERENCES `medico_casa`.`contacto` (`ctn_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `far_ct_FK`
    FOREIGN KEY (`far_id`)
    REFERENCES `medico_casa`.`farmacia` (`far_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`servicio_farmacia` (
  `srf_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ser_id` INT(11) NOT NULL,
  `cof_id` INT(11) NOT NULL,
  `srf_person_atiende` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`srf_id`),
  INDEX `ser_ind_SRF` (`ser_id` ASC) VISIBLE,
  INDEX `cof_SRT_FK` (`cof_id` ASC) VISIBLE,
  CONSTRAINT `SER_FK_SF`
    FOREIGN KEY (`ser_id`)
    REFERENCES `medico_casa`.`servicio` (`ser_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `COF_SF_FK`
    FOREIGN KEY (`cof_id`)
    REFERENCES `medico_casa`.`contacto_farmacia` (`cof_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`detalle_servicio_farmacia` (
  `dsf_id` INT(11) NOT NULL AUTO_INCREMENT,
  `srf_id` INT(11) NOT NULL,
  `drc_id` INT(11) NOT NULL,
  `dsf_cant_sol` INT(11) NOT NULL,
  `dsf_cant_prov` INT(11) NOT NULL,
  PRIMARY KEY (`dsf_id`),
  INDEX `drc_iGK__idx` (`drc_id` ASC) VISIBLE,
  INDEX `srf_fk_idx` (`srf_id` ASC) VISIBLE,
  CONSTRAINT `srf_fk`
    FOREIGN KEY (`srf_id`)
    REFERENCES `medico_casa`.`servicio_farmacia` (`srf_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `drc_iGK_`
    FOREIGN KEY (`drc_id`)
    REFERENCES `medico_casa`.`detalle_receta_consulta` (`drc_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`faltante_detalle_farmacia` (
  `fdf_id` INT(11) NOT NULL AUTO_INCREMENT,
  `dsf_id` INT(11) NOT NULL,
  `dsf_fecha` DATE NOT NULL,
  `dsf_cantidad_faltante` INT(11) NOT NULL,
  `dsf_estatus` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`fdf_id`),
  INDEX `dsf_FK_FAL_idx` (`dsf_id` ASC) VISIBLE,
  CONSTRAINT `dsf_FK_FAL`
    FOREIGN KEY (`dsf_id`)
    REFERENCES `medico_casa`.`detalle_servicio_farmacia` (`dsf_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`consulta_estatus` (
  `coe_id` INT(11) NOT NULL AUTO_INCREMENT,
  `coe_nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`coe_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`membresia` (
  `mem_id` INT(11) NOT NULL AUTO_INCREMENT,
  `mem_nombre` VARCHAR(80) NOT NULL,
  `mem_fcreacion` DATE NOT NULL,
  `usu_registra` VARCHAR(85) NOT NULL,
  `mem_vigencia_meses` INT(11) NOT NULL,
  `mem_descripcion` VARCHAR(250) NULL DEFAULT NULL,
  `mem_estatus` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`mem_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`beneficio` (
  `ben_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ben_nombre` VARCHAR(80) NOT NULL,
  `ben_estatus` VARCHAR(2) NOT NULL,
  `ben_fregistra` DATE NOT NULL,
  `usu_registra` VARCHAR(85) NOT NULL,
  `ben_descripcion` VARCHAR(250) NULL DEFAULT NULL,
  PRIMARY KEY (`ben_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`beneficio_detalle` (
  `bes_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ben_id` INT(11) NOT NULL,
  `bes_descuento` INT(11) NOT NULL,
  `bes_cantidad_aplica` INT(11) NOT NULL,
  `bes_periodo_renovacion_dias` INT(11) NULL DEFAULT NULL,
  `bes_aplica_descuento` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`bes_id`),
  INDEX `ben_ind_bed` (`ben_id` ASC) VISIBLE,
  CONSTRAINT `bes_ben_FK`
    FOREIGN KEY (`ben_id`)
    REFERENCES `medico_casa`.`beneficio` (`ben_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`beneficio_servicio` (
  `bns_id` INT(11) NOT NULL AUTO_INCREMENT,
  `tps_id` INT(11) NOT NULL,
  `bes_id` INT(11) NOT NULL,
  PRIMARY KEY (`bns_id`),
  INDEX `bes_d` (`bes_id` ASC) VISIBLE,
  INDEX `ser_bs_in` (`bes_id` ASC) VISIBLE,
  INDEX `SER_BNS_FK_idx` (`tps_id` ASC) VISIBLE,
  CONSTRAINT `BES_BNS_FK`
    FOREIGN KEY (`bes_id`)
    REFERENCES `medico_casa`.`beneficio_detalle` (`bes_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `SER_BNS_FK`
    FOREIGN KEY (`tps_id`)
    REFERENCES `medico_casa`.`tipo_servicio` (`tps_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`benecifio_insumo` (
  `bni_id` INT(11) NOT NULL AUTO_INCREMENT,
  `bes_id` INT(11) NOT NULL,
  `prod_id` INT(11) NOT NULL,
  PRIMARY KEY (`bni_id`),
  INDEX `BES_ID_fk_BNI_idx` (`bes_id` ASC) VISIBLE,
  INDEX `PROD_FK_BNI_idx` (`prod_id` ASC) VISIBLE,
  CONSTRAINT `BES_ID_fk_BNI`
    FOREIGN KEY (`bes_id`)
    REFERENCES `medico_casa`.`beneficio_detalle` (`bes_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `PROD_FK_BNI`
    FOREIGN KEY (`prod_id`)
    REFERENCES `medico_casa`.`producto` (`prod_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`membresia_cliente` (
  `mec_id` INT(11) NOT NULL AUTO_INCREMENT,
  `mem_id` INT(11) NOT NULL,
  `cpe_id` INT(11) NOT NULL,
  `mec_finicio` DATE NOT NULL,
  `mec_fultima_mod` DATE NOT NULL,
  `mec_fvencimiento` INT(11) NOT NULL,
  `mec_duracion` INT(11) NOT NULL,
  `mec_estatus` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`mec_id`),
  INDEX `MEM_IND_MEC` (`mem_id` ASC) VISIBLE,
  INDEX `CPE_IN_MEC` (`cpe_id` ASC) VISIBLE,
  CONSTRAINT `MEC_FK_MEM`
    FOREIGN KEY (`mem_id`)
    REFERENCES `medico_casa`.`membresia` (`mem_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `MEC_FK_CPE`
    FOREIGN KEY (`cpe_id`)
    REFERENCES `medico_casa`.`cliente_persona` (`cpe_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`membresia_beneficio` (
  `meb_id` INT(11) NOT NULL AUTO_INCREMENT,
  `mem_id` INT(11) NOT NULL,
  `ben_id` INT(11) NOT NULL,
  `meb_estatus` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`meb_id`),
  INDEX `MEM_FK_MEB_idx` (`mem_id` ASC) VISIBLE,
  INDEX `BEN_Fk_MEB_idx` (`ben_id` ASC) VISIBLE,
  CONSTRAINT `MEM_FK_MEB`
    FOREIGN KEY (`mem_id`)
    REFERENCES `medico_casa`.`membresia` (`mem_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `BEN_Fk_MEB`
    FOREIGN KEY (`ben_id`)
    REFERENCES `medico_casa`.`beneficio` (`ben_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`movimiento_membresia` (
  `mom_id` INT(11) NOT NULL AUTO_INCREMENT,
  `tmm_id` INT(11) NOT NULL,
  `mom_fmodficiacion` DATETIME NOT NULL,
  `usu_modifica` VARCHAR(85) NOT NULL,
  `mom_observacion` VARCHAR(250) NULL DEFAULT NULL,
  `mec_id` INT(11) NOT NULL,
  PRIMARY KEY (`mom_id`),
  INDEX `TMM_Fk_MOM_idx` (`tmm_id` ASC) VISIBLE,
  INDEX `mec_FK_MOMO_idx` (`mec_id` ASC) VISIBLE,
  CONSTRAINT `TMM_Fk_MOM`
    FOREIGN KEY (`tmm_id`)
    REFERENCES `medico_casa`.`tipo_movimiento_membresia` (`tmm_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `mec_FK_MOMO`
    FOREIGN KEY (`mec_id`)
    REFERENCES `medico_casa`.`membresia_cliente` (`mec_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`tipo_movimiento_membresia` (
  `tmm_id` INT(11) NOT NULL AUTO_INCREMENT,
  `tmm_nombre` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`tmm_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`movimiento_beneficio_mem` (
  `mbm_id` INT(11) NOT NULL AUTO_INCREMENT,
  `mec_id` INT(11) NOT NULL,
  `mbm_fecha_mod` DATETIME NOT NULL,
  `usu_mov` VARCHAR(85) NOT NULL,
  `mbm_cantidad_mov` INT(11) NOT NULL,
  `mbm_cantidad_antes` INT(11) NOT NULL,
  `mbm_cantidad_nueva` INT(11) NOT NULL,
  `tmb_id` INT(11) NOT NULL,
  PRIMARY KEY (`mbm_id`),
  INDEX `mmm_fk_idx` (`mec_id` ASC) VISIBLE,
  INDEX `mmib_FK_idx` (`tmb_id` ASC) VISIBLE,
  CONSTRAINT `mmm_fk`
    FOREIGN KEY (`mec_id`)
    REFERENCES `medico_casa`.`membresia_cliente` (`mec_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `mmib_FK`
    FOREIGN KEY (`tmb_id`)
    REFERENCES `medico_casa`.`tipo_movimiento_bene` (`tmb_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`tipo_movimiento_bene` (
  `tmb_id` INT(11) NOT NULL AUTO_INCREMENT,
  `tmb_nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`tmb_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`menus` (
  `men_id` INT(11) NOT NULL AUTO_INCREMENT,
  `grp_id` INT(11) NOT NULL,
  `men_nombre` VARCHAR(45) NOT NULL,
  `men_desc` VARCHAR(100) NULL DEFAULT NULL,
  `men_orden` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`men_id`),
  INDEX `gro_menu_idx` (`grp_id` ASC) VISIBLE,
  CONSTRAINT `gro_menu`
    FOREIGN KEY (`grp_id`)
    REFERENCES `medico_casa`.`grupo` (`grp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`sub_menus` (
  `sme_id` INT(11) NOT NULL AUTO_INCREMENT,
  `men_id` INT(11) NULL DEFAULT NULL,
  `sme_nombre` VARCHAR(45) NULL DEFAULT NULL,
  `sme_desc` VARCHAR(100) NULL DEFAULT NULL,
  `sme_icono` VARCHAR(45) NULL DEFAULT NULL,
  `sme_url` VARCHAR(100) NULL DEFAULT NULL,
  `grp_id` INT(11) NOT NULL,
  `sme_orden` INT(11) NULL DEFAULT 0,
  PRIMARY KEY (`sme_id`),
  INDEX `menus_submenu_idx` (`men_id` ASC) VISIBLE,
  INDEX `grupo_submenu_idx` (`grp_id` ASC) VISIBLE,
  CONSTRAINT `menus_submenu`
    FOREIGN KEY (`men_id`)
    REFERENCES `medico_casa`.`menus` (`men_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `grupo_submenu`
    FOREIGN KEY (`grp_id`)
    REFERENCES `medico_casa`.`grupo` (`grp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `medico_casa`.`sub_menus_rel` (
  `sre_id` INT(11) NOT NULL AUTO_INCREMENT,
  `sme_id_parent` INT(11) NOT NULL,
  `sme_id_child` INT(11) NOT NULL,
  INDEX `rel_parent_idx` (`sme_id_parent` ASC) VISIBLE,
  INDEX `rel_child_idx` (`sme_id_child` ASC) VISIBLE,
  PRIMARY KEY (`sre_id`),
  CONSTRAINT `rel_parent`
    FOREIGN KEY (`sme_id_parent`)
    REFERENCES `medico_casa`.`sub_menus` (`sme_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `rel_child`
    FOREIGN KEY (`sme_id_child`)
    REFERENCES `medico_casa`.`sub_menus` (`sme_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



/**Querys iniciales */


INSERT INTO `medico_casa`.`persona` (`per_id`, `per_nombre`, `per_ape_mat`, `per_ape_pate`, `per_email`, `per_falta`, `per_rfc`) VALUES ('1', 'Giovanni', 'Mendoza', 'de Jesus', 'gdejesus@patito.com', '2020-03-25', 'JEMG850325S38');
INSERT INTO `medico_casa`.`usuario` (`usu_id`, `usu_usuario`, `usu_password`, `usu_estatus`, `per_id`) VALUES ('1', 'admin', '$2a$10$ayw./mJrqAhwXGGJzxscVeB61hQd2BTU15yK5DtlNMiGgr0S/XOuy', 'AC', '1');
INSERT INTO `medico_casa`.`GRUPO` (`grp_id`, `grp_nombre`, `grp_desc`, `grp_estatus`) VALUES ('1', 'ROLE_ADMIN', 'Administrador', 'A');
INSERT INTO `medico_casa`.`GRUPO` (`grp_id`, `grp_nombre`, `grp_desc`, `grp_estatus`) VALUES ('2', 'ROLE_USUARIO', 'Usuario', 'A');

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



