package com.bankinc.service;

import org.springframework.http.ResponseEntity;
import com.bankinc.entity.TarjetaCliente;
import com.bankinc.response.TarjetaClienteResponseRest;



public interface ITarjetaClienteService {
	
	ResponseEntity<TarjetaClienteResponseRest> search();
	
	ResponseEntity<TarjetaClienteResponseRest> searchById(Long id);
	
	ResponseEntity<TarjetaClienteResponseRest> save(TarjetaCliente tarjeta);
	
	ResponseEntity<TarjetaClienteResponseRest> update(TarjetaCliente tarjeta, Long id);
	
	ResponseEntity<TarjetaClienteResponseRest> deleteById(Long id);
}
