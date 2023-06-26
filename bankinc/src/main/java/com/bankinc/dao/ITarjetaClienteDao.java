package com.bankinc.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bankinc.entity.TarjetaCliente;


@Repository
public interface ITarjetaClienteDao extends CrudRepository<TarjetaCliente, Long>{

}
