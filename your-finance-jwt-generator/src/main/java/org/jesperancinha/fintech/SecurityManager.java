package org.jesperancinha.fintech;

import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jwt.SignedJWT;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.eclipse.microprofile.jwt.Claims;

import java.io.File;
import java.net.URL;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import static com.nimbusds.jose.JOSEObjectType.JWT;
import static com.nimbusds.jose.JWSAlgorithm.RS256;
import static com.nimbusds.jwt.JWTClaimsSet.parse;
import static net.minidev.json.parser.JSONParser.DEFAULT_PERMISSIVE_MODE;

/**
 * Created by jofisaes on 13/07/2022
 */
public class SecurityManager {
    public static String generateJWTString(File jsonResource, File privateKeyFile) throws Exception {
        var byteBuffer = new byte[16384];
        final URL resource = jsonResource.toURI().toURL();
        if(resource != null) {
            try (var inputStream = resource
                    .openStream()) {
                inputStream.read(byteBuffer);
            }

            var parser = new JSONParser(DEFAULT_PERMISSIVE_MODE);
            var jwtJson = (JSONObject) parser.parse(byteBuffer);

            var currentTimeInSecs = (System.currentTimeMillis() / 1000);
            var expirationTime = currentTimeInSecs + 1000;

            jwtJson.put(Claims.iat.name(), currentTimeInSecs);
            jwtJson.put(Claims.auth_time.name(), currentTimeInSecs);
            jwtJson.put(Claims.exp.name(), expirationTime);

            var signedJWT = new SignedJWT(new JWSHeader
                    .Builder(RS256)
                    .keyID("jwt.key")
                    .type(JWT)
                    .build(), parse(jwtJson));

            signedJWT.sign(new RSASSASigner(readPrivateKey(privateKeyFile)));

            return signedJWT.serialize();
        }
        return null;
    }

    public static PrivateKey readPrivateKey(File resourceName) throws Exception {
        var byteBuffer = new byte[16384];
        var length =resourceName.toURI().toURL()
                .openStream()
                .read(byteBuffer);

        var key = new String(byteBuffer, 0, length).replaceAll("-----BEGIN (.*)-----", "")
                .replaceAll("-----END (.*)----", "")
                .replaceAll("\r\n", "")
                .replaceAll("\n", "")
                .trim();

        return KeyFactory.getInstance("RSA")
                .generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(key)));
    }
}
