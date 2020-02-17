package service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import models.Usuario;

@Repository
@Transactional
public class UsuarioService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(Usuario usuario) {
		entityManager.persist(usuario);
		return usuario.getId();
	}

}
