package br.com.teste.miniautorizador.models.parameters;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransacaoParameter {

    private String numeroCartao;
    private String senhaCartao;
    private BigDecimal valor;

}
