package br.com.teste.miniautorizador.services.impl;

import br.com.teste.miniautorizador.mappers.CartaoMapper;
import br.com.teste.miniautorizador.models.CartaoModel;
import br.com.teste.miniautorizador.repositories.CartaoRepository;
import br.com.teste.miniautorizador.services.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaoServiceImpl implements CartaoService {

    @Autowired
    private CartaoRepository repository;

    public CartaoModel findByNumeroCartao(String numeroCartao) {
        final var optional = repository.findByNumeroCartao(numeroCartao);
        if (optional.isEmpty()) {
            return null;
        }
        return CartaoMapper.entityToModel(optional.get());
    }

}
