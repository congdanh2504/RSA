package security3;

import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class Encryption {

	public static void main(String[] args) throws Exception {
		FileInputStream fileInputStream = new FileInputStream("./publicKey.key");
		
		byte b [] = new byte[fileInputStream.available()];
		fileInputStream.read(b);
		
		// convert tu file sang object
		X509EncodedKeySpec encodedKeySpec = new X509EncodedKeySpec(b);
		KeyFactory factory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = factory.generatePublic(encodedKeySpec);
		
		// Ma hoa
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		String msgString = "Hello world";
		
		byte encryptOut [] = cipher.doFinal(msgString.getBytes());
		
		System.out.println(new String(Base64.getEncoder().encode(encryptOut)));
		
	}

}
