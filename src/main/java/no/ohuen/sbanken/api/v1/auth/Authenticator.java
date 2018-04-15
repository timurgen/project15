package no.ohuen.sbanken.api.v1.auth;

import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;

/**
 *
 * @author Timur Samkharadze
 */
public final class Authenticator {

    private static final String IDENTITY_SERVER_URL
            = "https://api.sbanken.no/identityserver/connect/token";
    private final static Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public final Token getAccessToken(ClientSecretPair pair, HttpTransport transport) throws IOException {
        final String authStr = pair.getBase64AuthString();
        final HttpRequestFactory requestFactory = transport.createRequestFactory();
        final HttpRequest tokenRequest = requestFactory.buildPostRequest(new GenericUrl(IDENTITY_SERVER_URL), null);
        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept("application/json");
        headers.setAuthorization("Basic " + authStr);
        tokenRequest.setHeaders(headers);
        tokenRequest.setContent(new ByteArrayContent("application/x-www-form-urlencoded; charset=utf-8",
                "grant_type=client_credentials".getBytes()));
        HttpResponse response = tokenRequest.execute();
        String respStr = response.parseAsString();
        Token tokenObj = GSON.fromJson(respStr, Token.class);
        return tokenObj;
    }
}
