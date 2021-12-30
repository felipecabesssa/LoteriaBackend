package br.com.caelum.vraptor.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.UsuarioDAO;
import br.com.caelum.vraptor.model.Usuario;

@Path("dashboard")
@Controller
public class DashboardController {
	
	@Inject EntityManager em;
	@Inject Result result;
	@Inject UsuarioDAO usuarioDao;
	
	@Get("")
	public void dashboard() {
		
	}
	
	@Post("salvausuario")
	public void salvarUsuario(Usuario usuario) {
		//salva usuario no banco sem DAO
		//em.persist(usuario);
		
		//Inserindo usuário com o DAO
		usuarioDao.insertOrUpdate(usuario);
		
		//direciona p dashboard
		result.redirectTo(DashboardController.class).dashboard();
	}

}
