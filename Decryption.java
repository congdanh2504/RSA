package security3;

import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;

public class Decryption {

	public static void main(String[] args) throws Exception {
		FileInputStream fileInputStream = new FileInputStream("./privateKey.key");
		
		byte b [] = new byte[fileInputStream.available()];
		fileInputStream.read(b);
		
		// convert tu file sang object
		PKCS8EncodedKeySpec encodedKeySpec = new PKCS8EncodedKeySpec(b);
		KeyFactory factory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = factory.generatePrivate(encodedKeySpec);
		
		// Giai ma
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
	
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap vao chuoi da bi ma hoa: ");
		String encryptedString;
		encryptedString = scanner.nextLine();
		byte [] out = cipher.doFinal(Base64.getDecoder().decode(encryptedString));
		
		System.out.println("Chuoi da giai ma la: " + new String(out));
	}

}
