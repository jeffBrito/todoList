package br.com.tarefas.api.controller;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tarefas.api.dto.UsuarioDto;
import br.com.tarefas.api.model.Usuario;
import br.com.tarefas.api.repository.UsuarioRepository;


//---METADOS HTTP---
//POST = criando dados
//PUT = atualizando dados
//PATCH = atualizando unicos
//GET = consultando dados
//DELETE = deletando Dados

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Response = "Implementando Dados"
	//Request = "Enviando Dados"
	
	@PostMapping("/salvar")
	public ResponseEntity<Usuario> salvar(@RequestBody UsuarioDto usuarioDto){
		var usuario = new Usuario();
		BeanUtils.copyProperties(usuarioDto, usuario);
		
		var dataDia = LocalDateTime.now();
		usuario.setDataCad(dataDia);
		
		//404 - quando nao existe dados ou arquivo
		//502 - 500 - erro dados impletando dados que nao existe ou faltando
		//200,202 e 201 - foi feito com sucesso
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
	}
}
