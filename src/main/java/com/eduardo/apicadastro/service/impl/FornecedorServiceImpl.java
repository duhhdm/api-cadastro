package com.eduardo.apicadastro.service.impl;

import com.eduardo.apicadastro.dto.Fornecedor;
import com.eduardo.apicadastro.dto.ResponseSucesso;
import com.eduardo.apicadastro.model.FornecedorEntity;
import com.eduardo.apicadastro.repository.FornecedorRepository;
import com.eduardo.apicadastro.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    FornecedorRepository fornecedorRepository;

    @Override
    public ResponseSucesso incluirFornecedor(Fornecedor fornecedor) {
        if(fornecedor.getCpf()==null && fornecedor.getCnpj()==null)
            return new ResponseSucesso(null,"Cpf ou Cnpj Obrigatorios");

        Optional<FornecedorEntity> fornecedorEntityCpf =
                fornecedorRepository.findByCpf(fornecedor.getCpf());
        
        Optional<FornecedorEntity> fornecedorEntityCnpj =
                fornecedorRepository.findByCnpj(fornecedor.getCnpj());

        if((fornecedorEntityCpf.isPresent() && fornecedorEntityCpf.get().getCpf()!=null)
                || (fornecedorEntityCnpj.isPresent() && fornecedorEntityCnpj.get().getCnpj()!=null))
            return new ResponseSucesso(null,"Fornecedor ja cadastrado");
        FornecedorEntity fornecedorEntity = new Fornecedor().converterFornecedor(fornecedor);
        fornecedorRepository.save(fornecedorEntity);
        return new ResponseSucesso(fornecedorEntity.getId().toString(),"Fornecedor "+ fornecedorEntity.getNome() + " cadastrado com sucesso");
    }
}
