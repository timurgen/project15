package no.ohuen.sbanken.api.v1.bank;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import java.io.IOException;
import static no.ohuen.sbanken.api.v1.utils.ApiUtils.prepareAndExecuteRequest;

/**
 *
 * @author Timur Samkharadze
 */
public final class Bank {

    private static final String ACCOUNT_SERVICE_URL = "https://api.sbanken.no/bank/api/v1/accounts/";

    public final String getCustomerInfo(HttpRequestFactory requestFactory, String userId, String token) throws IOException {
        HttpRequest serviceRequest = requestFactory.buildGetRequest(new GenericUrl(ACCOUNT_SERVICE_URL + userId));
        String respStr = prepareAndExecuteRequest(token, serviceRequest);
        return respStr;
    }

    public final String getAccountInfo(HttpRequestFactory requestFactory, String userId, String token, String accountNumber) throws IOException {
        HttpRequest serviceRequest = requestFactory.buildGetRequest(new GenericUrl(ACCOUNT_SERVICE_URL + userId + "/" + accountNumber));
        String respStr = prepareAndExecuteRequest(token, serviceRequest);
        return respStr;
    }
    

}
