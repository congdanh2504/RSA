package security3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class KeyPairGen {
	static int KEY_SIZE = 1024;

	public static void main(String[] args) throws Exception {
		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		
		generator.initialize(KEY_SIZE);
		
		KeyPair keyPair = generator.generateKeyPair();
		
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();
		
		File publicKeyFile = new File("./publicKey.key");
		File privateKeyFile = new File("./privateKey.key");
		
		FileOutputStream fileOutputStream = new FileOutputStream(publicKeyFile);
		fileOutputStream.write(publicKey.getEncoded());
		fileOutputStream.close();
		
		fileOutputStream = new FileOutputStream(privateKeyFile);
		fileOutputStream.write(privateKey.getEncoded());
		fileOutputStream.close();
		
		System.out.println("Tao key thanh cong!");
	}
	
	static File createKeyFile(File file) throws IOException {
		if (file.exists()) file.delete();
		file.createNewFile();
		return file;
	}

}
