package com.bolsadeideas.springboot.app.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.dao.IFacturaDao;
import com.bolsadeideas.springboot.app.models.dao.IProductoDao;
import com.bolsadeideas.springboot.app.models.dao.IProductoDaoPag;
import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.bolsadeideas.springboot.app.models.entity.Producto;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private IProductoDao productoDao;
	
	@Autowired
	private IFacturaDao facturaDao;
	
	@Autowired
	private IProductoDaoPag productoDaoPag;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombre(String term) {		
		return productoDao.findByNombre(term); 
		//ó return productoDao.findByNombreLikeIgnoreCase("%" + term + "%");		
	}
	
	//Factura
	
	@Override
	@Transactional
	public void saveFactura(Factura factura) {
		facturaDao.save(factura);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAllProductos() {		
		List<Producto> listaProducto = (List<Producto>) productoDao.findAll();
		return listaProducto;
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findProductById(Long id) {
		Optional<Producto> productoById = productoDao.findById(id);		
		return productoById.isPresent()? productoById.get() : new Producto();
		//Ó
		//return productoDao.findById(id).orElse(null);
	}

	@Override
	public Page<Producto> findAllProducto(Pageable pageable) {
		return productoDaoPag.findAll(pageable);
	}

	@Override
	public Cliente findByNombreAndPassword(String email, String password) {
		return clienteDao.findByNombreAndPassword(email, password);
	}
	
	
	
		
	
	
}
