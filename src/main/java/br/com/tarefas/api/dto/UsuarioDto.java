package br.com.tarefas.api.dto;

import java.time.LocalDateTime;

public record UsuarioDto(String nome,
		String email,
		String senha,
		LocalDateTime dataCad,
		Boolean isStatus) {

}
