package br.com.caelum.vraptor.model;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Usuario extends Model{
	
	
	@NotEmpty(message="{usuario.nome.embranco}") @Size(min = 4, max=30, message="{usuario.nome.size}")
	private String nome;
	@NotEmpty @Email
	private String email;
	@NotEmpty(message="{usuario.senha.embranco}")
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
