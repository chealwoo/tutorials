package cwl.security.rsa;

import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

import static io.jsonwebtoken.JwsHeader.ALGORITHM;

public class RsaUtilTest {

    public static void main(String[] args) {

        String publicKeyStr = "BFz948MTG3OQ0Q69JHUiBG7dZ3SMGU1s2bVG9HuyX/hEU4H0pQJUjm/j93uqyVOBM8+i0AlgDvPOZ+UJzy6YGmU=";
//   MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIIuKRpWcMqFolSL1s2M41G9c3h__0hheQa9zikcuq9s5snNYwSJldbyhOi8Sjzp6gM3paAhtNsaGctJm6zEgTcCAwEAAQ==
        //                             MHYwEAYHKoZIzj0CAQYFK4EEACIDYgAEWPnbFlQdFGjhlkltwzr8Kk1hvDqZugz/D4kS2usCn/a3
//vKxH0NlzSJNQSuLiEgCzSNNX94ttDmtfJiU81i0D16E+O83U/QLcWd1sp8V7z/hWkdvP1TdHt8c/
//n7lpHXrT
        // PublicKey publicKey = RsaUtil.stringToPublicKey(publicKeyStr);

        KeyPair keyPair = null;
        try {
            keyPair = RsaUtil.buildKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        PublicKey getPublicKey = RsaUtil.getPublicKey(keyPair);

        publicKeyStr = RsaUtil.publicKeyToString(getPublicKey);

        // publicKeyStr = RsaUtil.publicKeyToUTF8String(getPublicKey);
        System.out.println("pkey: " + publicKeyStr);
    }


    public void decode(String txt) {

        try {
            txt.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
/*
    public static PublicKey getPublicKeyFromString(String key) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        org.spongycastle.asn1.pkcs.RSAPublicKey pkcs1PublicKey
                = org.spongycastle.asn1.pkcs.RSAPublicKey.getInstance(decodeB64(key));
        RSAPublicKeySpec keySpec
                = new RSAPublicKeySpec(pkcs1PublicKey.getModulus(), pkcs1PublicKey.getPublicExponent());
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }
*/
}
