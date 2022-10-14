package br.com.teste.miniautorizador.services.impl;

import br.com.teste.miniautorizador.enums.TransacaoRetornosEnum;
import br.com.teste.miniautorizador.mappers.SaldoMapper;
import br.com.teste.miniautorizador.models.parameters.TransacaoParameter;
import br.com.teste.miniautorizador.services.CartaoService;
import br.com.teste.miniautorizador.services.SaldoService;
import br.com.teste.miniautorizador.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.teste.miniautorizador.enums.TransacaoRetornosEnum.*;
import static java.math.BigDecimal.ZERO;
import static org.apache.commons.lang3.math.NumberUtils.INTEGER_MINUS_ONE;

@Service
public class TransacaoServiceImpl implements TransacaoService {
    @Autowired
    private CartaoService cartaoService;

    @Autowired
    private SaldoService saldoService;

    public TransacaoRetornosEnum saveTransacao(TransacaoParameter transacaoParameter) {
        final var cartaoModel = cartaoService.findByNumeroCartao(transacaoParameter.getNumeroCartao());
        if (cartaoModel == null) {
            return CARTAO_INEXISTENTE;
        } else if (!transacaoParameter.getSenhaCartao().equals(cartaoModel.getSenha())) {
            return SENHA_INVALIDA;
        } else {
            final var saldo = saldoService.getSaldoCartao(transacaoParameter.getNumeroCartao());
            if (saldo.subtract(transacaoParameter.getValor()).compareTo(ZERO) == INTEGER_MINUS_ONE) {
                return SALDO_INSUFICIENTE;
            }
            saldoService.saveSaldo(SaldoMapper.transacaoToSaldo(transacaoParameter));
        }
        return OK;
    }

}
