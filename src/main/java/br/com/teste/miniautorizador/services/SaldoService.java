package br.com.teste.miniautorizador.services;

import br.com.teste.miniautorizador.models.CartaoModel;
import br.com.teste.miniautorizador.models.SaldoModel;

import java.math.BigDecimal;

public interface SaldoService {

    BigDecimal getSaldoCartao(String numeroCartao);

    CartaoModel saveCartao(CartaoModel cartaoModel);

    void saveSaldo(SaldoModel saldoModel);

}
