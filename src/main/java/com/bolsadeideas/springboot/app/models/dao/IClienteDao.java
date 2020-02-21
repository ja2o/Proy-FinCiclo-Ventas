package com.bolsadeideas.springboot.app.models.dao;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.bolsadeideas.springboot.app.models.entity.Cliente;


public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long>{


	@Query("select c from Cliente c where c.email = ?1 and c.password = ?2")
	public Cliente findByNombreAndPassword(String email, String password);

	
	
}
