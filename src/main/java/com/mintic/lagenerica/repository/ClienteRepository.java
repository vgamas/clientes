package com.mintic.lagenerica.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mintic.lagenerica.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, Long> {

//	List<Producto> findByNombre_producto(String nombre);
}