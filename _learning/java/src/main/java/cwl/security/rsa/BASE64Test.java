package cwl.security.rsa;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class BASE64Test {

    public static void main(String[] args) {

        String testStr = "username:password";

        if (testStr.equals(decodeTest(encodeTest(testStr)))) {
            System.out.println("Test OK");
        } else {
            System.out.println("Test Fail");
        }

        decodeTest("BFz948MTG3OQ0Q69JHUiBG7dZ3SMGU1s2bVG9HuyX/hEU4H0pQJUjm/j93uqyVOBM8+i0AlgDvPOZ+UJzy6YGmU=");

/*
        try {
            String key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhyBJaLjDiFaxgIK7qbOBRY6hYic5nLlMiQ/lMXbp8nPEarEPKor4xJl782se08y/CV609pAleWIA44V1msNWbZPjBdNoIduWF0ybq+NMzqTnnv0Hlaa1HieR4Pr2U9DDA8xd8gb4HiUApP6iBIOx9St4QosEK9onY2oDRG6PK5Gch92cdOGn5hWZi9hN0poJeiASz4SqK2LIy/X64/QXzNfNolr2welhJVJM2Y/BW41furL9mlmSxsexPcR0DYxVtTp/Z9ilTKcOg3i5xzBiurBOSFnXxPnapg843yYjLkqfJK3fQuH2pHHNfen00vcIncyI+0SfClbRYCqkWqgnBwIDAQAB";
            byte[] keyByte = Base64.getDecoder().decode(key);
            System.out.println(new String(keyByte));
            String keyUTF8 = Base64.getEncoder().encodeToString(new String(keyByte, "utf-8").getBytes());
            System.out.println(keyUTF8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
    }

    public static String encodeTest(String normalString) {
        Base64.Encoder encoder = Base64.getEncoder();
       // String normalString = "username:password";
        String encodedString = encoder.encodeToString(
                normalString.getBytes(StandardCharsets.UTF_8) );

        System.out.println("encodedString:" + encodedString);
        return encodedString;
        // dXNlcm5hbWU6cGFzc3dvcmQ=
    }

    public static String decodeTest(String encodedString) {
      //   = "dXNlcm5hbWU6cGFzc3dvcmQ=";
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedByteArray = decoder.decode(encodedString);
//Verify the decoded string
        String decodedString = new String(decodedByteArray);
        System.out.println("decodedString:" + decodedString);

        return decodedString;
    }
}
// TUlJQklqQU5CZ2txaGtpRzl3MEJBUUVGQUFPQ0FROEFNSUlCQ2dLQ0FRRUFoeUJKYUxqRGlGYXhnSUs3cWJPQlJZNmhZaWM1bkxsTWlRL2xNWGJwOG5QRWFyRVBLb3I0eEpsNzgyc2UwOHkvQ1Y2MDlwQWxlV0lBNDRWMW1zTldiWlBqQmROb0lkdVdGMHlicStOTXpxVG5udjBIbGFhMUhpZVI0UHIyVTlEREE4eGQ4Z2I0SGlVQXBQNmlCSU94OVN0NFFvc0VLOW9uWTJvRFJHNlBLNUdjaDkyY2RPR241aFdaaTloTjBwb0plaUFTejRTcUsyTEl5L1g2NC9RWHpOZk5vbHIyd2VsaEpWSk0yWS9CVzQxZnVyTDltbG1TeHNleFBjUjBEWXhWdFRwL1o5aWxUS2NPZzNpNXh6Qml1ckJPU0ZuWHhQbmFwZzg0M3lZakxrcWZKSzNmUXVIMnBISE5mZW4wMHZjSW5jeUkrMFNmQ2xiUllDcWtXcWduQndJREFRQUI=