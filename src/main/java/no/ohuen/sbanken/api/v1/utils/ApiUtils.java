/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ohuen.sbanken.api.v1.utils;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import java.io.IOException;

/**
 *
 * @author 80473
 */
public class ApiUtils {

    public static final String prepareAndExecuteRequest(String token, HttpRequest serviceRequest) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept("application/json");
        headers.setAuthorization("Bearer " + token);
        serviceRequest.setHeaders(headers);
        HttpResponse response = serviceRequest.execute();
        String respStr = response.parseAsString();
        return respStr;
    }
    
}
