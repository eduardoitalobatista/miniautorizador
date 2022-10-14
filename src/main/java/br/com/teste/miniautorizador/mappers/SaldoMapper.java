package br.com.teste.miniautorizador.mappers;

import br.com.teste.miniautorizador.models.CartaoModel;
import br.com.teste.miniautorizador.models.SaldoModel;
import br.com.teste.miniautorizador.models.entities.SaldoEntity;
import br.com.teste.miniautorizador.models.parameters.TransacaoParameter;

public class SaldoMapper {

    public static SaldoEntity modelToEntity(SaldoModel model) {
        return SaldoEntity.builder().saldo(model.getSaldo())
                .cartao(CartaoMapper.modelToEntity(model.getCartao()))
                .build();
    }

    public static SaldoModel transacaoToSaldo(TransacaoParameter transacaoParameter) {
        return SaldoModel.builder().saldo(transacaoParameter.getValor())
                .cartao(CartaoModel.builder().numeroCartao(transacaoParameter.getNumeroCartao())
                        .senha(transacaoParameter.getSenhaCartao()).build()).build();
    }

}
