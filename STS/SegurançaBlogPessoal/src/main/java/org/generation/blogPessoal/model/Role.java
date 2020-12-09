package org.generation.blogPessoal.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{
	
	//Atribustos
	private String nomeRole;
	
	@ManyToMany(mappedBy = "roles")
	private List<Usuario> usuarios;

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

}
