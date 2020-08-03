/**
 * 
 */
package com.medico.home.admon.membresia.service;

import java.util.List;

import com.medico.home.commons.beneficio.model.Beneficio;
import com.medico.home.commons.cliente.model.ClientePersona;
import com.medico.home.commons.membresia.model.Membresia;
import com.medico.home.commons.membresia.model.MembresiaCliente;
import com.medico.home.commons.membresia.model.MovimientoMembresia;

/**
 * @author macpro
 *
 */
public interface IMembresiaAdmonService {
	
	Beneficio save(Beneficio beneficio) throws Exception;
	
	Beneficio nuevoBeneficio(Beneficio beneficio) throws Exception;
	
	List<Beneficio> findBeneficioByBenEstatus(String benEstatus) throws Exception;
	
	List<Beneficio> getBeneficioAdmonMembresia(List<Integer> lstBenId, String estatus)throws Exception;
	
	Membresia save(Membresia membresia)throws Exception;
	
	Membresia nueva(Membresia membresia)throws Exception;
	
	MembresiaCliente save(MembresiaCliente clienPer) throws Exception;
	
	MovimientoMembresia generaMovimiento(MembresiaCliente memCli, Integer tpoMov)throws Exception;
	
	MembresiaCliente save(ClientePersona clienPer, Integer tpoMov) throws Exception;
	
	List<MembresiaCliente> getMisMembresias(String usuario)throws Exception;
	
	MembresiaCliente getMembresiaByUser(String user)throws Exception;
	
	List<Membresia> findAllByMem() throws Exception;

}
