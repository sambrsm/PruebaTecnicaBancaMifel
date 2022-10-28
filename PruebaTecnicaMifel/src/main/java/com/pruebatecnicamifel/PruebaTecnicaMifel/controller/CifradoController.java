package com.pruebatecnicamifel.PruebaTecnicaMifel.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnicamifel.PruebaTecnicaMifel.util.Encriptador;
import com.pruebatecnicamifel.PruebaTecnicaMifel.vo.ClaveSecretaVO;

@RestController()
@RequestMapping("cifrado")
public class CifradoController {
	@Autowired
	Encriptador encriptador;
	@Autowired
	ClaveSecretaVO clavesecreta;
	
	@GetMapping("/crear/{cadena}")
	public SecretKeySpec  crearClave(@PathVariable("cadena") String cadena) throws UnsupportedEncodingException, NoSuchAlgorithmException
	{
		clavesecreta.setClave(cadena);
		return encriptador.crearClave(cadena);
	}
	
	@PostMapping("/encriptar")
	public String  encriptado(@RequestBody ClaveSecretaVO cs) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
	{
		return encriptador.encriptar(cs.getClave(),cs.getDatos());
	}
	
	@PostMapping("/desencriptar")
	public String  desencriptado(@RequestBody ClaveSecretaVO cs) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
	{
		return encriptador.desencriptar(cs.getClave(),cs.getDatos());
	}
	
	
	
	
	
}
