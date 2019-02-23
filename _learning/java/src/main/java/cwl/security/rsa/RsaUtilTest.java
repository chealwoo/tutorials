package cwl.security.rsa;

import java.io.UnsupportedEncodingException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Base64;

public class RsaUtilTest {

    public static void main(String[] args) {
        KeyPair keyPair = null;
        try {
            keyPair = RsaUtil.buildKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        PublicKey getPublicKey = RsaUtil.getPublicKey(keyPair);

        String publicKeyStr = RsaUtil.publicKeyToUTF8String(getPublicKey);
        System.out.println("pkey: " + publicKeyStr);
    }


    public void decode(String txt) {

        try {
            txt.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
