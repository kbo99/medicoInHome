package com.medico.home.admon.membresia.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.commons.membresia.model.MovimientoMembresia;

public interface IMovimientoMembresiaDAO extends PagingAndSortingRepository<MovimientoMembresia, Long> {

	List<MovimientoMembresia> findByMembresiaClienteMecFolio(String mecFolio);
}
