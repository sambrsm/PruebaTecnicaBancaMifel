package com.pruebatecnicamifel.PruebaTecnicaMifel.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

@Component
public class Encriptador {

	public SecretKeySpec crearClave(String key) throws NoSuchAlgorithmException,UnsupportedEncodingException  {
		MessageDigest sha = MessageDigest.getInstance("SHA-1");
		byte[] clave = key.getBytes("UTF-8");
		clave = sha.digest(clave);
		clave = Arrays.copyOf(clave, 16);
		SecretKeySpec claveSecreta = new SecretKeySpec(clave, "AES");
		return claveSecreta;
	}

	public String encriptar( String secretKey,String datos) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		SecretKeySpec claveSecreta = this.crearClave(secretKey);
		cipher.init(Cipher.ENCRYPT_MODE, claveSecreta);
		byte[] datosEncriptar = datos.getBytes("UTF-8");
		byte[] datosEncriptados = cipher.doFinal(datosEncriptar);
		String encriptado = Base64.getEncoder().encodeToString(datosEncriptados);
		return encriptado;
	}

	public String desencriptar(String secretKey,String datosEncriptados) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		SecretKeySpec claveSecreta = this.crearClave(secretKey);
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
		cipher.init(Cipher.DECRYPT_MODE, claveSecreta);
		byte[] bytesEncriptados = Base64.getDecoder().decode(datosEncriptados);
		byte[] datosDesencriptados = cipher.doFinal(bytesEncriptados);
		String datos = new String(datosDesencriptados);
		return datos;
	}

}