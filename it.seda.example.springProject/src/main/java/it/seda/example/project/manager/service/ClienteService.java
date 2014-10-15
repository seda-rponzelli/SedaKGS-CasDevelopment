package it.seda.example.project.manager.service;

import it.seda.example.project.domain.Cliente;
import it.seda.example.project.persistence.ClienteMapper;
import it.seda.jdbc.commons.DataPage;
import it.seda.jdbc.commons.DefaultDataPage;
import it.seda.jdbc.ibatis.RowBoundsHelper;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {
	
	
	@Autowired private ClienteMapper clienteMapper;

	@Transactional
	public void insertCliente(Cliente client) {
		clienteMapper.insertCliente(client);
	}

	@Transactional
	public void updateCliente(Cliente client) {
		clienteMapper.updateCliente(client);
	}

	@Transactional
	public void deleteCliente(BigInteger id) {
		clienteMapper.deleteCliente(id);
	}

	@Transactional(readOnly=true)
	public Cliente  getCliente(BigInteger id) {
		Cliente cliente=clienteMapper.getCliente(id);
		return cliente;
	}

	@Transactional(readOnly=true)
	public DataPage<Cliente> listClienti(int pageNumber, int rowsPerPage) {
		
		RowBoundsHelper rbh = new RowBoundsHelper(rowsPerPage, pageNumber);
		int totalrows=clienteMapper.listClientiCount();
		
		List<Cliente> clientiList=clienteMapper.listClienti(rbh.buildRowBounds());		
		
		DataPage<Cliente> clientiPage=new DefaultDataPage<Cliente>(clientiList);
		rbh.decorate(clientiPage, totalrows);
		
		return clientiPage;
		
	}

}
