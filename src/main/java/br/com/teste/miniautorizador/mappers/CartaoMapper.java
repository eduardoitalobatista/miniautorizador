package br.com.teste.miniautorizador.mappers;

import br.com.teste.miniautorizador.models.CartaoModel;
import br.com.teste.miniautorizador.models.entities.CartaoEntity;

public class CartaoMapper {

    public static CartaoEntity modelToEntity(CartaoModel model) {
        return CartaoEntity.builder().numeroCartao(model.getNumeroCartao()).senha(model.getSenha()).build();
    }

    public static CartaoModel entityToModel(CartaoEntity entity) {
        return CartaoModel.builder().numeroCartao(entity.getNumeroCartao()).senha(entity.getSenha()).build();
    }

}
