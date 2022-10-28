package com.pruebatecnicamifel.PruebaTecnicaMifel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnicamifel.PruebaTecnicaMifel.exception.ProductoNotFoundException;
import com.pruebatecnicamifel.PruebaTecnicaMifel.model.Producto;
import com.pruebatecnicamifel.PruebaTecnicaMifel.serviceimpl.ProductoServiceImpl;

@RestController()
@RequestMapping("productos")
public class ProductoController {

	@Autowired
	private ProductoServiceImpl servicioProducto;

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Producto> updateProducto(@PathVariable("id") Integer id,
			@RequestBody @Valid Producto producto) throws ProductoNotFoundException {

		return new ResponseEntity<Producto>(servicioProducto.updateProducto(id, producto), HttpStatus.OK);

	}

	@GetMapping("/listar")
	public ResponseEntity<List<Producto>> getProductos() {

		return new ResponseEntity<List<Producto>>(servicioProducto.getProductos(), HttpStatus.OK);

	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> deleteProducto(@PathVariable("id") Integer id) throws ProductoNotFoundException {

		servicioProducto.deleteProducto(id);
		return new ResponseEntity<String>("Producto eliminado correctamente", HttpStatus.OK);

	}

	@GetMapping("/obtenerporexistencia/{existencia}")
	public ResponseEntity<List<Producto>> getProductoPorExistencia(@PathVariable("existencia") Integer existencia)
			throws ProductoNotFoundException {

		return new ResponseEntity<List<Producto>>(servicioProducto.findByExistenciaOrderByIdAsc(existencia),
				HttpStatus.OK);

	}

	@GetMapping("/obtenerporprecio/{precioVenta}")
	public ResponseEntity<List<Producto>> getProductoPorPrecio(@PathVariable("precioVenta") Double precioVenta)
			throws ProductoNotFoundException {

		return new ResponseEntity<List<Producto>>(servicioProducto.findByPrecioventaOrderByIdAsc(precioVenta),
				HttpStatus.OK);

	}

	@GetMapping("/obtenerpornombre/{nombre}")
	public ResponseEntity<List<Producto>> getProductoPorNombre(@PathVariable("nombre") String nombre)
			throws ProductoNotFoundException {

		return new ResponseEntity<List<Producto>>(servicioProducto.findByNombreIgnoreCaseContainingOrderByIdAsc(nombre),
				HttpStatus.OK);

	}

	@GetMapping("/obtener/{id}")
	public ResponseEntity<Producto> getProductoById(@PathVariable("id") Integer id) throws ProductoNotFoundException {

		return new ResponseEntity<Producto>(servicioProducto.getProductoById(id), HttpStatus.OK);

	}

	@PostMapping("/guardar")
	public ResponseEntity<Producto> saveProducto(@RequestBody @Valid Producto producto) {
		System.out.println(producto);
		return new ResponseEntity<Producto>(servicioProducto.saveProducto(producto), HttpStatus.CREATED);
	}

	/*
	 * @GetMapping("/obtenerpornombre/{nombre}") public List<Producto>
	 * getPorNombre(@PathVariable("nombre") String nombre) { return
	 * servicioProducto.buscarporNombreIgnoreCaseContaining(nombre);}
	 * 
	 */

}
