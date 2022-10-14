package br.com.teste.miniautorizador.services.impl;

import br.com.teste.miniautorizador.mappers.CartaoMapper;
import br.com.teste.miniautorizador.mappers.SaldoMapper;
import br.com.teste.miniautorizador.models.CartaoModel;
import br.com.teste.miniautorizador.models.SaldoModel;
import br.com.teste.miniautorizador.models.entities.SaldoEntity;
import br.com.teste.miniautorizador.repositories.CartaoRepository;
import br.com.teste.miniautorizador.repositories.SaldoRepository;
import br.com.teste.miniautorizador.services.SaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SaldoServiceImpl implements SaldoService {

    @Autowired
    private SaldoRepository saldoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @Value("${saldo-inicial}")
    private BigDecimal saldoInicial;

    public BigDecimal getSaldoCartao(String numeroCartao) {
        final var optional = saldoRepository.findByCartaoNumeroCartao(numeroCartao);
        if (optional.isEmpty()) {
            return null;
        }
        final var entity = optional.get();
        return entity.getSaldo();
    }

    public CartaoModel saveCartao(CartaoModel cartaoModel) {
        final var optional = cartaoRepository.findByNumeroCartao(cartaoModel.getNumeroCartao());
        if (optional.isPresent()) {
            return null;
        }
        final var cartaoSaved = cartaoRepository.save(CartaoMapper.modelToEntity(cartaoModel));
        final var entity = SaldoEntity.builder().saldo(saldoInicial).cartao(cartaoSaved).build();
        final var entitySaved = saldoRepository.save(entity);
        return CartaoMapper.entityToModel(entitySaved.getCartao());
    }

    public void saveSaldo(SaldoModel saldoModel) {
        final var saldo = saldoRepository.findByCartaoNumeroCartao(saldoModel.getCartao().getNumeroCartao()).get();
        saldo.setSaldo(saldo.getSaldo().subtract(saldoModel.getSaldo()));
        saldoRepository.save(saldo);
    }

}
