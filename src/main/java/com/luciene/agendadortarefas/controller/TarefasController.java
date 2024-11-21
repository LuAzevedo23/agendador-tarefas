package com.luciene.agendadortarefas.controller;

import com.luciene.agendadortarefas.business.TarefasService;
import com.luciene.agendadortarefas.business.dto.TarefasDTO;
import com.luciene.agendadortarefas.business.dto.UsuarioDTO;
import com.luciene.agendadortarefas.infrastructure.client.UsuarioClient;
import com.luciene.agendadortarefas.infrastructure.repository.TarefasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefasController {

    private final TarefasService tarefasService;

    private final UsuarioClient usuarioClient;

    @GetMapping("/usuario-por-email")
    public UsuarioDTO buscarUsuarioPorEmail(
            @RequestParam String email,
            @RequestHeader("Authorization") String jwtToken) {

        // Adiciona o prefixo "Bearer " ao token (caso não tenha vindo no cabeçalho completo)
        String token = jwtToken.startsWith("Bearer ") ? jwtToken : "Bearer " + jwtToken;

        // Faz a chamada à API Usuário via UsuarioClient
        return usuarioClient.buscaUsuarioPorEmail(email, token);
    }

    @PostMapping
    public ResponseEntity<TarefasDTO> gravarTarefa(@RequestBody TarefasDTO dto,
                                                   @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefasService.gravarTarefa(token, dto));
    }

    @GetMapping("/eventos")
    public ResponseEntity<List<TarefasDTO>> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal) {

        return ResponseEntity.ok(tarefasService.buscaTarefasAgendadasPorPeriodo(dataInicial, dataFinal));

    }

    @GetMapping
    public ResponseEntity <List<TarefasDTO>> buscaTarefasPorEmail(@RequestHeader("Authorization") String token) {
        List<TarefasDTO> tarefas = tarefasService.buscaTarefasPorEmail(token);
        return ResponseEntity.ok(tarefas);
    }
}
