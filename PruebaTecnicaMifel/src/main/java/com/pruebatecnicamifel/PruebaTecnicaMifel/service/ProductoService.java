package com.pruebatecnicamifel.PruebaTecnicaMifel.service;

import java.util.List;

import com.pruebatecnicamifel.PruebaTecnicaMifel.exception.ProductoNotFoundException;
import com.pruebatecnicamifel.PruebaTecnicaMifel.model.Producto;

public interface ProductoService {
	public Producto saveProducto(Producto producto);

	public List<Producto> getProductos();

	public Producto getProductoById(Integer id) throws ProductoNotFoundException;

	public void deleteProducto(Integer id) throws ProductoNotFoundException;

	public Producto updateProducto(Integer id, Producto producto) throws ProductoNotFoundException;
}
