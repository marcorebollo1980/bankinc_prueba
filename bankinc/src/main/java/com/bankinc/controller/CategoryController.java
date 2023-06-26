package com.bankinc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankinc.entity.TarjetaCliente;
import com.bankinc.response.TarjetaClienteResponseRest;
import com.bankinc.service.ITarjetaClienteService;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
	
	@Autowired
	private ITarjetaClienteService tarjetaResponseService;
	
	/***
	 * Generar numero de tarjeta
	 * @return
	 */
	@GetMapping("/cards")
	public ResponseEntity<TarjetaClienteResponseRest> searchCategories(){
		ResponseEntity<TarjetaClienteResponseRest> response = tarjetaResponseService.search();
		return response;
	}
	
	/***
	 * Activar tarjeta
	 * @param tarjetaCliente
	 * @return
	 */
	@PostMapping("/card/enroll")
	public ResponseEntity<TarjetaClienteResponseRest> save(@Validated @RequestBody TarjetaCliente tarjetaCliente){
		ResponseEntity<TarjetaClienteResponseRest> response = tarjetaResponseService.save(tarjetaCliente);
		return response;
	}
	
	/***
	 * Bloquear tarjeta
	 * @param id
	 * @return
	 */
	@DeleteMapping("/card/{id}")
	public ResponseEntity<TarjetaClienteResponseRest> deleteCategory(@PathVariable("id") Long id){
		ResponseEntity<TarjetaClienteResponseRest> response = tarjetaResponseService.deleteById(id);
		return response;
	}
	
    /***
     * Recargar saldo
     * @param tarjeta
     * @param id
     * @return
     */
	@PutMapping("/card/balance/{id}")
	public ResponseEntity<TarjetaClienteResponseRest> update(@Validated @RequestBody TarjetaCliente tarjeta, @PathVariable("id") Long id){
		ResponseEntity<TarjetaClienteResponseRest> response = tarjetaResponseService.update(tarjeta,id);
		return response;
	}
	
	/***
	 * Consulta de saldo
	 * @param id
	 * @return
	 */
	@GetMapping("/card/balance/{id}")
	public ResponseEntity<TarjetaClienteResponseRest> search(@PathVariable("id") Long id){
		ResponseEntity<TarjetaClienteResponseRest> response = tarjetaResponseService.searchById(id);
		return response;
	}
	
	
	/***
	 * Transaccion de compra
	 * @param tarjeta
	 * @return
	 */
	@PostMapping("/transaction/purchase")
	public ResponseEntity<TarjetaClienteResponseRest> saveTransaction(@Validated @RequestBody TarjetaCliente tarjeta){
		ResponseEntity<TarjetaClienteResponseRest> response = tarjetaResponseService.save(tarjeta);
		return response;
	}

	/***
	 * Consultar transaccion
	 * @param id
	 * @return
	 */
	@GetMapping("/transaction/{id}")
	public ResponseEntity<TarjetaClienteResponseRest> searchTransaction(@PathVariable("id") Long id){
		ResponseEntity<TarjetaClienteResponseRest> response = tarjetaResponseService.searchById(id);
		return response;
	}
	
	/***
     * Anular transaccion
     * @param tarjeta
     * @param id
     * @return
     */
	@PutMapping("/transaction/anulation/{id}")
	public ResponseEntity<TarjetaClienteResponseRest> anulateTransaction(@Validated @RequestBody TarjetaCliente tarjeta, @PathVariable("id") Long id){
		ResponseEntity<TarjetaClienteResponseRest> response = tarjetaResponseService.update(tarjeta,id);
		return response;
	}

}
