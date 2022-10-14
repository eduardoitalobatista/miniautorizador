package br.com.teste.miniautorizador.services;

import br.com.teste.miniautorizador.models.CartaoModel;

public interface CartaoService {

    CartaoModel findByNumeroCartao(String numeroCartao);

}
