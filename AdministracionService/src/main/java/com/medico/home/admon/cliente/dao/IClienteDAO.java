package com.medico.home.admon.cliente.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.medico.home.commons.cliente.model.Cliente;

public interface IClienteDAO extends PagingAndSortingRepository<Cliente, Long> {

}
