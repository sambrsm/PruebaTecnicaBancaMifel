package com.pruebatecnicamifel.PruebaTecnicaMifel.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnicamifel.PruebaTecnicaMifel.model.Producto;
import com.pruebatecnicamifel.PruebaTecnicaMifel.repository.ProductoRepository;
import com.pruebatecnicamifel.PruebaTecnicaMifel.service.ProductoService;
import com.pruebatecnicamifel.PruebaTecnicaMifel.exception.ProductoNotFoundException;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	public List<Producto> findByPrecioventaOrderByIdAsc(Double precioVenta) throws ProductoNotFoundException {
		return productoRepository.findByPrecioVentaOrderByIdAsc(precioVenta);

	}

	public List<Producto> findByNombreIgnoreCaseContainingOrderByIdAsc(String nombre) throws ProductoNotFoundException {
		return productoRepository.findByNombreIgnoreCaseContainingOrderByIdAsc(nombre);

	}

	public List<Producto> findByExistenciaOrderByIdAsc(Integer existencia) throws ProductoNotFoundException {
		return productoRepository.findByExistenciaOrderByIdAsc(existencia);

	}

	@Override
	public Producto saveProducto(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public List<Producto> getProductos() {
		return productoRepository.findAll();
	}

	@Override
	public Producto getProductoById(Integer id) throws ProductoNotFoundException {
		Optional<Producto> productoData = productoRepository.findById(id);
		if (productoData.isPresent()) {
			return productoData.get();
		} else {
			throw new ProductoNotFoundException("No se encontraron productos con ese identificador");
		}

	}

	@Override
	public void deleteProducto(Integer id) throws ProductoNotFoundException {
		Optional<Producto> productoData = productoRepository.findById(id);
		if (productoData.isPresent()) {
			productoRepository.deleteById(id);
		} else {
			throw new ProductoNotFoundException("No se encontraron productos con ese identificador");

		}

	}

	@Override
	public Producto updateProducto(Integer id, Producto producto) throws ProductoNotFoundException {
		Optional<Producto> productoData = productoRepository.findById(id);
		if (productoData.isPresent()) {
			Producto productobd = productoData.get();
			productobd.setDescripcion(producto.getDescripcion());
			productobd.setExistencia(producto.getExistencia());
			productobd.setNombre(producto.getNombre());
			productobd.setPrecioVenta(producto.getPrecioVenta());
			return productoRepository.save(productobd);
		} else {
			throw new ProductoNotFoundException("No se encontraron productos con ese identificador");

		}

	}

}
