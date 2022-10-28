package com.pruebatecnicamifel.PruebaTecnicaMifel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebatecnicamifel.PruebaTecnicaMifel.exception.ProductoNotFoundException;
import com.pruebatecnicamifel.PruebaTecnicaMifel.model.Producto;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	public List<Producto> findByPrecioVentaOrderByIdAsc(Double precioVenta) throws ProductoNotFoundException;

	public List<Producto> findByNombreIgnoreCaseContainingOrderByIdAsc(String nombre) throws ProductoNotFoundException;

	public List<Producto> findByExistenciaOrderByIdAsc(Integer existencia) throws ProductoNotFoundException;

}
