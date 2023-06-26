package com.bankinc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bankinc.dao.ITarjetaClienteDao;
import com.bankinc.entity.TarjetaCliente;
import com.bankinc.response.TarjetaClienteResponseRest;


@Service
public class TarjetaClienteServiceImpl implements ITarjetaClienteService{
	
	@Autowired
	private ITarjetaClienteDao iCategoryDao;

	@Override
	public ResponseEntity<TarjetaClienteResponseRest> search() {
		
		TarjetaClienteResponseRest response = new TarjetaClienteResponseRest();
		
		try {
			List<TarjetaCliente> category = (List<TarjetaCliente>) iCategoryDao.findAll();
			response.getTarjetaResponse().setTarjetas(category);
			response.setMetadata("Respuesta Ok", "00", "Respuesta exitosa");
			
		} catch (Exception e) {
			response.setMetadata("Respuesta Erronea", "-1", "Error al consultar los datos");
			e.getStackTrace();
			return new ResponseEntity<TarjetaClienteResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR) ;
		}
		
		return new ResponseEntity<TarjetaClienteResponseRest>(response, HttpStatus.OK) ;
	}

	@Override
	public ResponseEntity<TarjetaClienteResponseRest> searchById(Long id) {
		
		TarjetaClienteResponseRest response = new TarjetaClienteResponseRest();
		List<TarjetaCliente> listTarjeta = new ArrayList<>();
		
		try {
			Optional<TarjetaCliente> category =  iCategoryDao.findById(id);
		    if(category.isPresent()) {
		    	listTarjeta.add(category.get());
		       response.getTarjetaResponse().setTarjetas(listTarjeta);
		    }else {
		    	response.setMetadata("Respuesta Erronea", "-1", "Tarjeta no encontrada");
				return new ResponseEntity<TarjetaClienteResponseRest>(response, HttpStatus.NOT_FOUND) ;
		    }
			
		} catch (Exception e) {
			response.setMetadata("Respuesta Erronea", "-1", "Error al consultar los datos");
			e.getStackTrace();
			return new ResponseEntity<TarjetaClienteResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR) ;
		}
		
		return new ResponseEntity<TarjetaClienteResponseRest>(response, HttpStatus.OK) ;
	}

	@Override
	public ResponseEntity<TarjetaClienteResponseRest> save(TarjetaCliente category) {
		
		TarjetaClienteResponseRest response = new TarjetaClienteResponseRest();
		List<TarjetaCliente> listTarjeta = new ArrayList<>();
		
		try {
			TarjetaCliente tarjetaSaved =  iCategoryDao.save(category);
		    if(tarjetaSaved != null) {
		    	listTarjeta.add(tarjetaSaved);
		       response.getTarjetaResponse().setTarjetas(listTarjeta);
		       response.setMetadata("Respuesta Exitosa", "00", "Tarjeta guardada de forma exitosa");
		    } else {
		    	response.setMetadata("Respuesta Erronea", "-1", "tarjeta no guardada");
				return new ResponseEntity<TarjetaClienteResponseRest>(response, HttpStatus.BAD_REQUEST) ;
		    }
			
		} catch (Exception e) {
			response.setMetadata("Respuesta Erronea", "-1", "Tarjeta no guardada");
			e.getStackTrace();
			return new ResponseEntity<TarjetaClienteResponseRest>(response, HttpStatus.BAD_REQUEST) ;
		}
		
		return new ResponseEntity<TarjetaClienteResponseRest>(response, HttpStatus.OK) ;
	}

	@Override
	public ResponseEntity<TarjetaClienteResponseRest> update(TarjetaCliente tarjeta, Long id) {

		TarjetaClienteResponseRest response = new TarjetaClienteResponseRest();
		List<TarjetaCliente> listCategory = new ArrayList<>();

		try {
			Optional<TarjetaCliente> categoryId = iCategoryDao.findById(id);
			if (categoryId.isPresent()) {
				categoryId.get().setNombresTitular(tarjeta.getNombresTitular());
				
				categoryId.get().setApellidosTitular(tarjeta.getApellidosTitular());
				
				categoryId.get().setFechaVencimiento(tarjeta.getFechaVencimiento());
				
				categoryId.get().setMovimientoPermitido(tarjeta.getMovimientoPermitido());
				
				categoryId.get().setNumeroTarjeta(tarjeta.getNumeroTarjeta());
				
				categoryId.get().setActivacionTarjeta(tarjeta.getActivacionTarjeta());
				
				categoryId.get().setSaldoTarjeta(tarjeta.getSaldoTarjeta());
				
				categoryId.get().setSaldoRecarga(tarjeta.getSaldoRecarga());


				TarjetaCliente tarjetaUpdate = iCategoryDao.save(categoryId.get());
				
				if (tarjetaUpdate != null) {
					listCategory.add(tarjetaUpdate);
					response.getTarjetaResponse().setTarjetas(listCategory);
					response.setMetadata("Respuesta Exitosa", "00", "Tarjeta actualizada de forma exitosa");
				} else {
					response.setMetadata("Respuesta Erronea", "-1", "Tarjeta no actualizada");
					return new ResponseEntity<TarjetaClienteResponseRest>(response, HttpStatus.BAD_REQUEST);
				}

			} else {
				response.setMetadata("Respuesta Erronea", "-1", "tarjeta no encontrada");
				return new ResponseEntity<TarjetaClienteResponseRest>(response, HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			response.setMetadata("Respuesta Erronea", "-1", "Error al actualizar la tarjeta");
			e.getStackTrace();
			return new ResponseEntity<TarjetaClienteResponseRest>(response, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<TarjetaClienteResponseRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<TarjetaClienteResponseRest> deleteById(Long id) {
		TarjetaClienteResponseRest response = new TarjetaClienteResponseRest();
		try {
			
			iCategoryDao.deleteById(id);
			response.setMetadata("Respuesta exitosa", "00", "Registro eliminado de forma exitosa");
			
		} catch (Exception e) {
			response.setMetadata("Respuesta Erronea", "-1", "tarjeta no guardada");
			e.getStackTrace();
			return new ResponseEntity<TarjetaClienteResponseRest>(response, HttpStatus.BAD_REQUEST) ;
		}
		
		return new ResponseEntity<TarjetaClienteResponseRest>(response, HttpStatus.OK) ;
	}


}
