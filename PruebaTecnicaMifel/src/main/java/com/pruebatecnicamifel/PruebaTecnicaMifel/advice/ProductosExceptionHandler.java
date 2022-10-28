package com.pruebatecnicamifel.PruebaTecnicaMifel.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pruebatecnicamifel.PruebaTecnicaMifel.exception.ProductoNotFoundException;

@RestControllerAdvice
public class ProductosExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleArgumentoInvalido(MethodArgumentNotValidException ex) {
		Map<String, String> mapErrores = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			mapErrores.put(error.getField(), error.getDefaultMessage());
		});

		return mapErrores;
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ProductoNotFoundException.class)
	public Map<String, String> handleProductoNoEncontrado(ProductoNotFoundException ex) {
		Map<String, String> mapError = new HashMap<>();
		mapError.put("Mensaje de error", ex.getMessage());
		return mapError;
	}

}
