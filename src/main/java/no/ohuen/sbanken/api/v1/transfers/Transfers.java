package no.ohuen.sbanken.api.v1.transfers;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.json.JsonHttpContent;
import java.io.IOException;
import static no.ohuen.sbanken.api.v1.utils.ApiUtils.prepareAndExecuteRequest;
import com.google.api.client.json.jackson2.JacksonFactory;

/**
 *
 * @author Timur Samkharadze
 */
public class Transfers {
    
    private static final String ACCOUNT_SERVICE_URL = "https://api.sbanken.no/bank/api/v1/Transfers/";

    public final String transfer(HttpRequestFactory requestFactory, String userId, String token, TransferBody body) throws IOException {
        HttpContent content = new JsonHttpContent(new JacksonFactory(), body);
        
        HttpRequest serviceRequest = requestFactory.buildPostRequest(new GenericUrl(ACCOUNT_SERVICE_URL + userId), content);
        String respStr = prepareAndExecuteRequest(token, serviceRequest);
        return respStr;
    }
}
