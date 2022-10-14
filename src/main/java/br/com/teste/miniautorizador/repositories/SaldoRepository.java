package br.com.teste.miniautorizador.repositories;

import br.com.teste.miniautorizador.models.entities.SaldoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaldoRepository extends JpaRepository<SaldoEntity, Long> {

    Optional<SaldoEntity> findByCartaoNumeroCartao(String numeroCartao);

}
