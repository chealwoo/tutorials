package cwl.security.rsa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import static javax.xml.crypto.dsig.Transform.BASE64;

/**
 * Encrypt Decrypt example
 * https://gist.github.com/dmydlarz/32c58f537bb7e0ab9ebf
 * https://docs.oracle.com/javase/7/docs/api/java/security/KeyPairGenerator.html
 */
public class RsaUtil {
    private static final Logger LOG = LoggerFactory.getLogger(RsaUtil.class);
    private static final String SECURITY_INSTANCE_TYPE = "RSA";

    private static final String PRIVATE_KEY_FILE = "D:\\tmp\\privatekey.key";
    private static final String PUBLIC_KEY_FILE = "D:\\tmp\\publickey.crt";
//    private static final int keySize = 2048;
  private static final int keySize = 512;

    public static KeyPair buildKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(SECURITY_INSTANCE_TYPE);
        keyPairGenerator.initialize(keySize);
        return keyPairGenerator.genKeyPair();
    }

    public static void generateKey() {
        try {
            final KeyPair key = buildKeyPair();

            File privateKeyFile = new File(PRIVATE_KEY_FILE);
            File publicKeyFile = new File(PUBLIC_KEY_FILE);

            // Create files to store public and private key
            if (privateKeyFile.getParentFile() != null) {
                privateKeyFile.getParentFile().mkdirs();
            }
            privateKeyFile.createNewFile();

            if (publicKeyFile.getParentFile() != null) {
                publicKeyFile.getParentFile().mkdirs();
            }
            publicKeyFile.createNewFile();

            // Saving the Public key in a file
            ObjectOutputStream publicKeyOS = new ObjectOutputStream(
                    new FileOutputStream(publicKeyFile));
            publicKeyOS.writeObject(key.getPublic());
            publicKeyOS.close();

            // Saving the Private key in a file
            ObjectOutputStream privateKeyOS = new ObjectOutputStream(
                    new FileOutputStream(privateKeyFile));
            privateKeyOS.writeObject(key.getPrivate());
            privateKeyOS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PublicKey getPublicKey(KeyPair keyPair) {
        return keyPair.getPublic();
    }


    public static PrivateKey getPrivateKey(KeyPair keyPair) {
        return keyPair.getPrivate();
    }

    /**
     * https://howtodoinjava.com/java8/base64-encoding-and-decoding-example-in-java-8/
     * @param p
     * @return
     */
    public static String publicKeyToString(PublicKey p) {
        byte[] publicKeyBytes = p.getEncoded();
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(publicKeyBytes);
    }

    public static void savePublicKey(String fileName) throws NoSuchAlgorithmException, IOException {
        KeyPair key = buildKeyPair();
        PublicKey publicKey = key.getPublic();
        byte[] encodedPublicKey = publicKey.getEncoded();
        String b64PublicKey = Base64.getEncoder().encodeToString(encodedPublicKey);

        try (OutputStreamWriter publicKeyWriter =
                     new OutputStreamWriter(
                             new FileOutputStream(fileName),
                             StandardCharsets.UTF_8.newEncoder())) {
            publicKeyWriter.write(b64PublicKey);
        }
    }

    static BASE64Encoder encoder = new BASE64Encoder();
    public static String publicKeyToEncodeToUrlSafeString(PublicKey p) {
        byte[] publicKeyBytes = p.getEncoded();

        return Base64Utils.encodeToUrlSafeString(publicKeyBytes);
    }

    public static String privateKeyToString(PrivateKey p) {
        byte[] privateKeyBytes = p.getEncoded();

        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(privateKeyBytes);
    }

    /**
     * stringToPublicKey
     * Example
     * https://stackoverflow.com/questions/9755057/converting-strings-to-encryption-keys-and-vice-versa-java
     *
     * @param s
     * @return
     */
    public static PublicKey stringToPublicKey(String s) {
        BASE64Decoder decoder = new BASE64Decoder();

        byte[] c = null;
        KeyFactory keyFact = null;
        PublicKey returnKey = null;

        try {
            c = decoder.decodeBuffer(s);
            keyFact = KeyFactory.getInstance("RSA");
        } catch (Exception e) {
            LOG.error("Error in Keygen for {}", e.getMessage(), e);
            e.printStackTrace();
        }

        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(c);
        try {
            returnKey = keyFact.generatePublic(x509KeySpec);
        } catch (Exception e) {
            LOG.error("Error in Keygen for {}", e.getMessage(), e);
            e.printStackTrace();
        }

        return returnKey;
    }

    /**
     * stringToPrivateKey
     * DSA example
     * https://stackoverflow.com/questions/9755057/converting-strings-to-encryption-keys-and-vice-versa-java
     * RSA example
     * https://stackoverflow.com/questions/39311157/only-rsaprivate-crt-keyspec-and-pkcs8encodedkeyspec-supported-for-rsa-private
     *
     * @param s
     * @return
     */
    public static PrivateKey stringToPrivateKey(String s) {
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] c = null;
        KeyFactory keyFact = null;
        PrivateKey returnKey = null;

        try {
            c = decoder.decodeBuffer(s);
            keyFact = KeyFactory.getInstance("RSA");
        } catch (Exception e) {
            System.out.println("Error in first try catch of stringToPrivateKey");
            e.printStackTrace();
        }

//        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(c);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(c);
        try {   //the next line causes the crash
//            returnKey = keyFact.generatePrivate(x509KeySpec);
            returnKey = (RSAPrivateKey) keyFact.generatePrivate(spec);
        } catch (Exception e) {
            System.out.println("Error in stringToPrivateKey");
            e.printStackTrace();
        }

        return returnKey;
    }

    public static byte[] encrypt(PrivateKey privateKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        return cipher.doFinal(message.getBytes());
    }

    public static byte[] decrypt(PublicKey publicKey, byte[] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance(SECURITY_INSTANCE_TYPE);
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        return cipher.doFinal(encrypted, 0, 256);
//        return cipher.doFinal(encrypted, 0, 128);
    }


    public static byte[] encrypt(PublicKey publicKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance(SECURITY_INSTANCE_TYPE);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        return cipher.doFinal(message.getBytes());
    }

    public static byte[] decrypt(PrivateKey privateKey, byte[] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance(SECURITY_INSTANCE_TYPE);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        return cipher.doFinal(encrypted, 0, 256);
//        return cipher.doFinal(encrypted, 0, 128);
    }
}
