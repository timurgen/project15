package no.ohuen.sbanken.api.v1.auth;

/**
 *simple pojo for holding access token
 * @author Timur Samkharadze
 */
public final class Token {
    public String access_token;
    public String token_type;
    public String expires_in;

    @Override
    public String toString() {
        return "Token{" + "access_token=" + access_token + ", token_type=" + token_type + ", expires_in=" + expires_in + '}';
    }    
}
