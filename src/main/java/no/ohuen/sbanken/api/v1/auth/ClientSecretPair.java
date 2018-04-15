package no.ohuen.sbanken.api.v1.auth;

import java.util.Base64;

/**
 *
 * @author Timur Samkharadze
 */
public class ClientSecretPair {
    private final String clientId;
    private final String secret;
    private final String userId;
    /**
     * 
     * @param clientId application key
     * @param secret password generated in utvikler portalen 
     * @param userId login name (fødselsnummer)
     */
    public ClientSecretPair(String clientId, String secret, String userId) {
        this.clientId = clientId;
        this.secret = secret;
        this.userId = userId;
    }
    /**
     * returns base64 encoded auth string 
     * @return
     */
    public final String getBase64AuthString(){
        return new String(Base64.getEncoder().encode(
                new StringBuilder(256)
                        .append(this.clientId).append(':')
                        .append(this.secret).toString().getBytes()));
    }
    /**
     * returns user id
     * @return 
     */
    public final String getUserId(){
        return this.userId;
    }
}
