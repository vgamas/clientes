package com.mintic.lagenerica.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mintic.lagenerica.model.Cliente;
import com.mintic.lagenerica.repository.ClienteRepository;

@CrossOrigin(origins = "http://localhost:8181") // Seguridad
@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@PostMapping("/guardar")
	public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente){
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente));
	}
	
	@GetMapping("/listar")
	public List<Cliente> listarClientes() {
		List<Cliente> listaClientes = StreamSupport.stream(clienteRepository.findAll().spliterator(), false).collect(Collectors.toList());
		
		return listaClientes;
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> bucarCliente(@PathVariable(value = "id") Long id) {

		Optional<Cliente> oCliente = clienteRepository.findById(id) ;
		
		if (oCliente.isEmpty())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(oCliente);
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> borrarClienteporId(@PathVariable(value = "id") Long id) {

		Optional<Cliente> oCliente = clienteRepository.findById(id) ;
		
		if (oCliente.isEmpty())
			return ResponseEntity.notFound().build();
		
		clienteRepository.deleteById(id);
		
		return ResponseEntity.ok(oCliente);
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<?> borrarTodos() {

		Cliente oCliente = new Cliente();
		
		clienteRepository.deleteAll();;
		
		return ResponseEntity.ok(oCliente);
	}


	@PutMapping("actualizar")
	public ResponseEntity<?> actualizarCliente(@RequestBody Cliente cliente) {

		Optional<Cliente> clienteAnt = clienteRepository.findById(cliente.getCedula_cliente());
		
		if(clienteAnt.isEmpty())
			return ResponseEntity.notFound().build();
		
		clienteAnt.get().setNombre_cliente(cliente.getNombre_cliente());
		clienteAnt.get().setCedula_cliente(cliente.getCedula_cliente());
		clienteAnt.get().setDireccion_cliente(cliente.getDireccion_cliente());
		clienteAnt.get().setTelefono_cliente(cliente.getTelefono_cliente());
		clienteAnt.get().setCorreo_cliente(cliente.getCorreo_cliente());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(clienteAnt.get()));	
	}
}
