package com.DelaCasa.service.impl;

import com.DelaCasa.dao.ClienteDao;
import com.DelaCasa.domain.Cliente;
import com.DelaCasa.service.ClienteService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClienteServicesImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;


    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional()
    public void save(Cliente cliente) {
        
        clienteDao.save(cliente);
    }

    @Override
    @Transactional()
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

}
