package com.medico.home.admon.membresia.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.commons.membresia.model.MovimientoMembresia;

public interface IMovimientoMembresiaDAO extends PagingAndSortingRepository<MovimientoMembresia, Long> {

}
