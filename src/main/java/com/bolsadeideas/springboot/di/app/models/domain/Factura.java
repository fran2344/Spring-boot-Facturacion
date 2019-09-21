package com.bolsadeideas.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;

@Component
@ApplicationScope
public class Factura implements Serializable{
	private static final long serialVersionUID = -8929110986522614722L;

	@Value("${factura.descripcion}")
	private String descripcion;

	@Autowired
	private Cliente cliente;
	
	@Autowired
	@Qualifier("itemsFacturaOficina")
	private List<ItemFactura> item;
	
	@PostConstruct
	public void Inicializar() 
	{
		cliente.setNombre(cliente.getNombre().concat(" ").concat("Jose"));
		descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
	}
	
	@PreDestroy
	public void destruir() 
	{
		System.out.println("Factura destruida: ".concat(descripcion));
	}
	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItem() {
		return item;
	}

	public void setItem(List<ItemFactura> item) {
		this.item = item;
	}
}
