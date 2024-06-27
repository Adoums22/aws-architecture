package com.example.cdansoprapizza.services;

import com.example.cdansoprapizza.dtos.InClientDto;
import com.example.cdansoprapizza.dtos.OutClientDto;
import com.example.cdansoprapizza.entities.ClientEntity;
import com.example.cdansoprapizza.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Boolean exist(int ID) {
        return clientRepository.existsById(ID);
    }

    @Override
    public OutClientDto toDto(ClientEntity entity) {
        return null;
    }

    @Override
    public ClientEntity get(int Id) {
        return null;
    }

    @Override
    public Integer ajouter(OutClientDto dto) {
        return 0;
    }

    @Override
    public List<OutClientDto> getAll() {
        return List.of();
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }

    @Override
    public ClientEntity toEntty(InClientDto dto) {
        return null;
    }
}
