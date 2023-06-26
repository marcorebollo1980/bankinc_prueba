package com.bankinc.response;

import java.util.List;

import com.bankinc.entity.TarjetaCliente;


import lombok.Data;

@Data
public class TarjetaClienteResponse {
	
	private List<TarjetaCliente> tarjetas;

}
