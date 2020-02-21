package com.bolsadeideas.springboot.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bolsadeideas.springboot.app.models.entity.Producto;

public interface IProductoDaoPag extends PagingAndSortingRepository<Producto,Long>{

}
