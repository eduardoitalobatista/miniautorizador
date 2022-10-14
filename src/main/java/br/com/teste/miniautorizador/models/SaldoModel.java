package br.com.teste.miniautorizador.models;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SaldoModel {

    private CartaoModel cartao;
    private BigDecimal saldo;

}
