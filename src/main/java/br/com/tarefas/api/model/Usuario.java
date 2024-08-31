package br.com.tarefas.api.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long idUsuario;
	
	@Column(nullable = false,length = 120)
	private String nome;
	
	@Column(nullable = false,length = 120)
	private String email;
	
	@Column(nullable = false,length = 70)
	private String senha;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private LocalDateTime dataCad;
	
	@Column(nullable = false)
	private Boolean isStatus;
}
