package com.pruebatecnicamifel.PruebaTecnicaMifel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "El nombre no debe ser nulo o estar vacio")
	private String nombre;
	@NotBlank(message = "La descripcion no debe ser nula o estar vacia")
	private String descripcion;
	@Min(0)
	private Integer existencia;
	@Min(0)
	private Double precioVenta;

	public Integer getId() {
		return id;
	}

	public Producto() {

	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", existencia="
				+ existencia + ", precioVenta=" + precioVenta + "]";
	}

	public Producto(Integer id, String nombre, String descripcion, Integer existencia, Double precioVenta) {

		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.existencia = existencia;
		this.precioVenta = precioVenta;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getExistencia() {
		return existencia;
	}

	public void setExistencia(Integer existencia) {
		this.existencia = existencia;
	}

	public Double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}

}
