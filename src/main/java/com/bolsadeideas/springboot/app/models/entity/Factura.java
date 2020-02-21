package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "facturas")
public class Factura implements Serializable {

	//Camps

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "fec_factura")
	private Date fecFactura;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Cliente cliente;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "factura_id")
	private List<ItemFactura> itemFactura;
	
	//Constructor
	
	public Factura() {
		this.itemFactura = new ArrayList<ItemFactura>();
	}
	
	//PrePersist
	
	@PrePersist
	public void prePersist() {
		fecFactura = new Date();
	}
	
	//Getter and Setter
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Date getFecFactura() {
		return fecFactura;
	}

	public void setFecFactura(Date fecFactura) {
		this.fecFactura = fecFactura;
	}

	public List<ItemFactura> getItemFactura() {
		return itemFactura;
	}

	public void setItemFactura(List<ItemFactura> itemFactura) {
		this.itemFactura = itemFactura;
	}
	
	//Methods
	
	public void addItemFactura(ItemFactura item) {
		this.itemFactura.add(item);
	}
	
	public Double getTotal() {		
		int tamanioItemFactura = itemFactura.size();
		Double total = 0.0;
		for(int i= 0; i < tamanioItemFactura; i++) {
			total += itemFactura.get(i).calcularImporte();
		}
		return total;
	}
	

	//SerialVersion
	
	private static final long serialVersionUID = 1L;
}
