package org.jesperancinha.fintech

import com.nimbusds.jose.JOSEObjectType
import com.nimbusds.jose.JWSAlgorithm
import com.nimbusds.jose.JWSHeader
import com.nimbusds.jose.crypto.RSASSASigner
import com.nimbusds.jwt.JWTClaimsSet
import com.nimbusds.jwt.SignedJWT
import net.minidev.json.JSONObject
import net.minidev.json.parser.JSONParser
import org.eclipse.microprofile.jwt.Claims
import java.io.File
import java.security.KeyFactory
import java.security.PrivateKey
import java.security.spec.PKCS8EncodedKeySpec
import java.util.*

/**
 * Created by jofisaes on 13/07/2022
 */
object SecurityManager {
    fun generateJWTString(jsonResource: File?, privateKeyFile: File?): String? {
        val byteBuffer = ByteArray(16384)
        val resource = jsonResource?.toURI()?.toURL()
        if (resource != null) {
            resource
                .openStream().use { inputStream -> inputStream.read(byteBuffer) }
            val parser = JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE)
            val jwtJson = parser.parse(byteBuffer) as JSONObject
            val currentTimeInSecs = System.currentTimeMillis() / 1000
            val expirationTime = currentTimeInSecs + 1000
            jwtJson[Claims.iat.name] = currentTimeInSecs
            jwtJson[Claims.auth_time.name] = currentTimeInSecs
            jwtJson[Claims.exp.name] = expirationTime
            val signedJWT = SignedJWT(
                JWSHeader.Builder(JWSAlgorithm.RS256)
                    .keyID("jwt.key")
                    .type(JOSEObjectType.JWT)
                    .build(), JWTClaimsSet.parse(jwtJson)
            )
            signedJWT.sign(RSASSASigner(readPrivateKey(privateKeyFile)))
            return signedJWT.serialize()
        }
        return null
    }

    private fun readPrivateKey(resourceName: File?): PrivateKey {
        val byteBuffer = ByteArray(16384)
        val length = resourceName?.toURI()?.toURL()?.openStream()?.read(byteBuffer) ?: 0
        val key = String(byteBuffer, 0, length)
            .replace("-----BEGIN (.*)-----".toRegex(), "")
            .replace("-----END (.*)----".toRegex(), "")
            .replace("\r\n".toRegex(), "")
            .replace("\n".toRegex(), "")
            .trim { it <= ' ' }
        return KeyFactory.getInstance("RSA")
            .generatePrivate(PKCS8EncodedKeySpec(Base64.getDecoder().decode(key)))
    }
}