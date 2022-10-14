package br.com.teste.miniautorizador.controllers;

import br.com.teste.miniautorizador.enums.TransacaoRetornosEnum;
import br.com.teste.miniautorizador.models.parameters.TransacaoParameter;
import br.com.teste.miniautorizador.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.teste.miniautorizador.enums.TransacaoRetornosEnum.OK;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @PostMapping
    public ResponseEntity<TransacaoRetornosEnum> save(@RequestBody TransacaoParameter parameter) {
        final var response = service.saveTransacao(parameter);
        if (response == OK) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
        }
    }


}
