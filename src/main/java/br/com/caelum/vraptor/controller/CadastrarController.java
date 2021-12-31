package br.com.caelum.vraptor.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.UsuarioDAO;
import br.com.caelum.vraptor.model.Usuario;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Path("cadastrar")
@Controller
public class CadastrarController {
	
	@Inject EntityManager em;
	@Inject Result result;
	@Inject UsuarioDAO usuarioDao;
	@Inject Validator validator;
	
	@Get("")
	public void cadastrar() {
		
	}
	
	@Post("salvausuario")
	public void salvarUsuario(@Valid Usuario usuario, String confirmaSenha) {
		//Validar senhas iguais
		boolean asSenhasSaoIguais = confirmaSenha.equals(usuario.getSenha());
		validator.addIf(!asSenhasSaoIguais, new SimpleMessage("confirmaSenha", "As senhas não são iguais!"));
		
		//Validar usuario
		validator.onErrorRedirectTo(this).cadastrar();
		
		//Salva usuario no banco sem DAO
		//em.persist(usuario);
		
		//Inserindo usuário com o DAO
		usuarioDao.insertOrUpdate(usuario);
		
		//Direciona p dashboard
		result.redirectTo(DashboardController.class).dashboard();
	}

}
