package br.com.teste.miniautorizador.controllers;

import br.com.teste.miniautorizador.models.CartaoModel;
import br.com.teste.miniautorizador.services.SaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private SaldoService saldoService;

    @GetMapping("{numeroCartao}")
    public ResponseEntity<BigDecimal> get(@PathVariable String numeroCartao) {
        final var response = saldoService.getSaldoCartao(numeroCartao);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<CartaoModel> save(@RequestBody CartaoModel model) {
        final var response = saldoService.saveCartao(model);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(model);
        }
    }


}
