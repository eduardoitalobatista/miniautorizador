package br.com.teste.miniautorizador.services;

import br.com.teste.miniautorizador.enums.TransacaoRetornosEnum;
import br.com.teste.miniautorizador.models.parameters.TransacaoParameter;

public interface TransacaoService {

    TransacaoRetornosEnum saveTransacao(TransacaoParameter transacaoParameter);

}
