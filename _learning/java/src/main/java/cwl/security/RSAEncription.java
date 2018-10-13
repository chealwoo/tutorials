package cwl.security;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * https://gist.github.com/dmydlarz/32c58f537bb7e0ab9ebf
 */
public class RSAEncription {

    public static void main(String [] args) throws Exception {
        // generate public and private keys
        KeyPair keyPair = buildKeyPair();
        PublicKey pubKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

//        X509Certificate cert = CertificateIOUtil.extractCertificate(JwtTokenService.certificate);
//        pubKey = cert.getPublicKey();
        // privateKey = cert.getpri

        // encrypt the message
        String secritStr = "This is a secret message";
        System.out.println("1. String to encrypt: " + secritStr);  // <<encrypted message>>
        byte [] encrypted = encrypt(privateKey, secritStr);
        System.out.println("2. encrypted String: " + new String(encrypted));  // <<encrypted message>>

        // decrypt the message
        byte[] secret = decrypt(pubKey, encrypted);
        System.out.println("3. decrypted String: " + new String(secret));     // This is a secret message
    }

    public static KeyPair buildKeyPair() throws NoSuchAlgorithmException {
        final int keySize = 2048;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keySize);
        return keyPairGenerator.genKeyPair();
    }

    public static byte[] encrypt(PrivateKey privateKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        return cipher.doFinal(message.getBytes());
    }

    public static byte[] decrypt(PublicKey publicKey, byte [] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        return cipher.doFinal(encrypted);
    }
}
