package com.juliodutra.cadastrobancario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.juliodutra.cadastrobancario.dto.ClienteDTO;
import com.juliodutra.cadastrobancario.entity.Cliente;
import com.juliodutra.cadastrobancario.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public Cliente cadastrar(ClienteDTO dto) {
		
		Cliente email = repository.findByEmail(dto.getEmail());
		Assert.isNull(email, "E-mail já cadastrado");
		
		Cliente cpf = repository.findByCpf(dto.getCpf());
		Assert.isNull(cpf, "CPF já cadastrado");
		
		Cliente cliente = new Cliente();
		cliente.setNome(dto.getNome());
		cliente.setEmail(dto.getEmail());
		cliente.setCpf(dto.getCpf());
		cliente.setDataNascimento(dto.getDataNascimento());
		
		repository.save(cliente);
		
		return cliente;
	}

	public List<Cliente> listar() {
		List<Cliente> cliente = repository.findAll();
		return cliente;
	}
}
