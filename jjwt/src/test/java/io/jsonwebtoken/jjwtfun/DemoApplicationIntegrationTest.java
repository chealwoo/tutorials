package io.jsonwebtoken.jjwtfun;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.jjwtfun.model.JwtResponse;
import io.jsonwebtoken.jjwtfun.service.SecretService;
import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.Instant;
@SpringBootTest(classes = JJWTFunApplication.class)
import java.util.Arrays;
import java.util.Date;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    SecretService secretService;

    @Test
    public void contextLoads() {
    }

    /**
     * https://stackoverflow.com/questions/18336277/how-to-check-string-in-response-body-with-mockmvc
     *
     * @throws Exception
     */

    @Test
    public void staticJwtControllerTest() throws Exception {

        MvcResult result = mockMvc.perform(get("/static-builder"))
                .andExpect(content().string(containsString("Hello, World!")))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        MockHttpServletResponse mockHttpServletResponse = result.getResponse();
        mockHttpServletResponse.getStatus();
        mockHttpServletResponse.getErrorMessage();
        mockHttpServletResponse.getHeaderNames();
        mockHttpServletResponse.getContentType();
        mockHttpServletResponse.getContentAsString();
        mockHttpServletResponse.getCookies();
    }


    @Test
    public void staticJwtControllerParserTest() throws Exception {
        String secrit = "FueYb5LK2xVDYC+hQ12QzG/4omX8tgZEtNmBFXOZw9c=";
        Instant nowInst = Instant.now();

        Date now = new Date();
        Date exp = new Date(now.getTime() + 60 * 60);

        String jws = Jwts.builder()
                .setIssuer("Stormpath")
                .setSubject("msilverman")
                .claim("name", "Micah Silverman")
                .claim("scope", "admins")
                .setIssuedAt(now)   // Fri Jun 24 2016 15:33:42 GMT-0400 (EDT)
                .setExpiration(exp) // Sat Jun 24 2116 15:33:42 GMT-0400 (EDT)
                .signWith(
                        SignatureAlgorithm.HS256,
                        secretService.getHS256SecretBytes()
                )
                .compact();
        Assert.assertNotNull(jws);

        Jws<Claims> jws2 = Jwts.parser()
                .setSigningKeyResolver(secretService.getSigningKeyResolver())
                .parseClaimsJws(jws);
        Assert.assertNotNull(jws2);

        JwtResponse jwtResponse = new JwtResponse(jws);
        Assert.assertNotNull(jwtResponse);


        MockHttpServletRequestBuilder get = MockMvcRequestBuilders.get("/parser")
                .param("jwt", jws)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(APPLICATION_JSON);
        MvcResult result = mockMvc.perform(get)
                .andExpect(content().string(containsString("status\":\"SUCCESS")))
                .andReturn();


    }

    /**
     *
     * Base64 decode
     * https://examples.javacodegeeks.com/core-java/apache/commons/codec/decode-base64/
     *
     */
    @Test
    public void jwtInsideTest() {
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJTdG9ybXBhdGgiLCJzdWIiOiJtc2lsdmVybWFuIiwibmFtZSI6Ik1pY2FoIFNpbHZlcm1hbiIsInNjb3BlIjoiYWRtaW5zIiwiaWF0IjoxNDY2Nzk2ODIyLCJleHAiOjQ2MjI0NzA0MjJ9.CfYRjYf2-unrEw1LP88v8PB2horctbfVDnKhynojXEo";

        String string = "eyJhbGciOiJIUzI1NiJ9";
        // Get bytes from string
        byte[] byteArray = Base64.decodeBase64(string.getBytes());

        // Print the decoded array
        System.out.println(Arrays.toString(byteArray));

        // Print the decoded string
        String decodedString = new String(byteArray);
        System.out.println(string + " = " + decodedString);

        Assert.assertEquals(decodedString, "{\"alg\":\"HS256\"}");

    }

}
