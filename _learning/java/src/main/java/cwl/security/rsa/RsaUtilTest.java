package cwl.security.rsa;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Base64;

public class RsaUtilTest {

    public static void main(String[] args) {
        abc_base64publickey_test002();
    }

    /**
     * https://stackoverflow.com/questions/41526826/convert-rsa-publickey-to-base64-and-vice-versa
     */
    public static void abc_base64publickey_test002() {
        PublicKey publicKey = getPublicKey();

        String publicKeyStr = RsaUtil.publicKeyToString(publicKey);
        System.out.println("pkey: " + publicKeyStr);

        String publicKeyFile = "D:\\code\\samples\\java\\tutorials\\_learning\\java\\src\\test\\resources\\cwl\\security\\b64publickey.txt";

        try (OutputStreamWriter publicKeyWriter =
                     new OutputStreamWriter(
                             new FileOutputStream(publicKeyFile),
                             StandardCharsets.UTF_8.newEncoder())) {
            publicKeyWriter.write(publicKeyStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
pkey:
MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAI7i1w8dFva3m/cnn+vYkaGY15bkMIcBf/CCAuQgcUzU
R5gKbGmSaOXSqm1023DrRR7Sv64LRxKeDiZ+yAaIVJMCAwEAAQ==

MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAI7i1w8dFva3m/cnn+vYkaGY15bkMIcBf/CCAuQgcUzUR5gKbGmSaOXSqm1023DrRR7Sv64LRxKeDiZ+yAaIVJMCAwEAAQ==

"authenticate":{"errors":[{"code":2,"domain":"com.apple.icloud.messages.business.cryptor","message":"Failed creating key"}]

2019-02-25 10:48:34.814  INFO 8472 --- [      Thread-41] c.i.a.p.i.g.a.m.c.i.ExtMessageBuilder    : EEE Received External message {"sourceId":"urn:mbid:AQAAY4YyhPNY+f/pLNslDsU5sHQtTtT1MutkAC6EY41gwEcgFEfWcBvLwSQt27/m2yaw1XzqPAUOy6FaAACtn0Q8F+H8Dij1PPPDe0xCR7qH9lXR6H2S6tvRZrSbkmSXF9uhT4tdTj6cV71E6iTVWBSmKGYGaLI=","v":1,"interactiveData":{"data":{"receivedMessage":{"style":"icon","title":"Sign In to Business Chat Sandbox"},"authenticate":{"errors":[{"code":2,"domain":"com.apple.icloud.messages.business.cryptor","message":"Failed creating key"}],"status":"failed"},"replyMessage":{"style":"icon","alternateTitle":"Authentication Failed","title":"Authentication Failed"},"requestIdentifier":"3EF748B5-3DC5-47AE-B185-91E91518D105","version":"1.0"},"bid":"com.apple.messages.MSMessageExtensionBalloonPlugin:0000000000:com.apple.icloud.apps.messages.business.extension","sessionIdentifier":"ca30af14-5147-a9a0-f749-05911021120d"},"id":"93527aa0-068b-48d6-8ad5-504ac906f429","type":"interactive","destinationId":"b9159070-c454-4135-8bf3-049809624818"}
         */
    }

    public static void abc_base64publickey_test001() {
        PublicKey publicKey = getPublicKey();

        String publicKeyStr = RsaUtil.publicKeyToEncodeToUrlSafeString(publicKey);
        System.out.println("pkey: " + publicKeyStr);
        /*
pkey: MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBANgS26joXyyxKbRV812g2eBklKw5W3PRpPyqLLWI_jn0kZC_6-sFp1gY5jgqacuAcYzTtLnFq1I3rHd00uX1Qz8CAwEAAQ==

"errors":[{"code":1,"domain":"com.apple.icloud.messages.business.cryptor","message":"Key is not UTF8"}

2019-02-25 10:39:13.051  INFO 8472 --- [      Thread-40] c.i.a.p.i.g.a.m.c.i.ExtMessageBuilder    : EEE Received External mess
age {"sourceId":"urn:mbid:AQAAY4YyhPNY+f/pLNslDsU5sHQtTtT1MutkAC6EY41gwEcgFEfWcBvLwSQt27/m2yaw1XzqPAUOy6FaAACtn0Q8F+H8Dij1PPPD
e0xCR7qH9lXR6H2S6tvRZrSbkmSXF9uhT4tdTj6cV71E6iTVWBSmKGYGaLI=","v":1,"interactiveData":{"data":{"receivedMessage":{"style":"ico
n","title":"Sign In to Business Chat Sandbox"},"authenticate":{"errors":[{"code":1,"domain":"com.apple.icloud.messages.busines
s.cryptor","message":"Key is not UTF8"}],"status":"failed"},"replyMessage":{"style":"icon","alternateTitle":"Authentication Fa
iled","title":"Authentication Failed"},"requestIdentifier":"3EF748B5-3DC5-47AE-B185-91E91518D105","version":"1.0"},"bid":"com.
apple.messages.MSMessageExtensionBalloonPlugin:0000000000:com.apple.icloud.apps.messages.business.extension","sessionIdentifie
r":"2ddea4d7-db6d-cb01-fc75-4dd6df7ee2a0"},"id":"e011f15a-8efc-4cf2-8b68-103535d07a60","type":"interactive","destinationId":"b
9159070-c454-4135-8bf3-049809624818"}
         */
    }

    public static PublicKey getPublicKey() {
        KeyPair keyPair = null;
        try {
            keyPair = RsaUtil.buildKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return keyPair.getPublic();
    }

    public void decode(String txt) {

        try {
            txt.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
