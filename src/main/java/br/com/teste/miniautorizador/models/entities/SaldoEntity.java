package br.com.teste.miniautorizador.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "saldo")
public class SaldoEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private BigDecimal saldo;

    @ManyToOne
    @JoinColumn(name = "id_cartao")
    private CartaoEntity cartao;

}
