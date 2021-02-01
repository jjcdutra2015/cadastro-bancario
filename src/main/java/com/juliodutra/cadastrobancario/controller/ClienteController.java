package com.juliodutra.cadastrobancario.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juliodutra.cadastrobancario.dto.ClienteDTO;
import com.juliodutra.cadastrobancario.entity.Cliente;
import com.juliodutra.cadastrobancario.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService service;

	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid ClienteDTO dto) {
		service.cadastrar(dto);
		return ResponseEntity.created(null).build();
	}
	
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Cliente> obj = service.listar();
		if (obj.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {			
			return ResponseEntity.ok().body(obj);
		}
	}
}
