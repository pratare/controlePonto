package repository;

import org.springframework.data.repository.CrudRepository;

import models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

}
