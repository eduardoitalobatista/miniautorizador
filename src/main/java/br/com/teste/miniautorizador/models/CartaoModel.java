package br.com.teste.miniautorizador.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartaoModel {

    private String numeroCartao;
    private String senha;

}
