package no.ohuen.sbanken.controller;

import com.google.api.client.http.apache.ApacheHttpTransport;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import no.ohuen.sbanken.api.v1.auth.Authenticator;
import no.ohuen.sbanken.api.v1.auth.ClientSecretPair;
import no.ohuen.sbanken.api.v1.auth.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Timur Samkharadze
 */
@Controller
public class Home {
    @Autowired
    HttpServletRequest request;
    
    @RequestMapping("/")
    public String getHome() {
        return "home";
    }
    @RequestMapping("disclaimer")
    public String getDisclaimer() {
        return "disclaimer";
    }
    @RequestMapping("init")
    public String getAppSettingsView(){
        return "init";
    }
    /**
     * function to authenticate api user
     * @param clientId
     * @param userId
     * @param secret 
     * @return  view
     */
    @RequestMapping(method = RequestMethod.POST, value = "auth")
    public String authenticate(@RequestParam("clientId") String clientId
            , @RequestParam("userId") String userId
            , @RequestParam("secret") String secret){
        ClientSecretPair authData = new ClientSecretPair(clientId, secret, userId);
        Authenticator auth = new Authenticator();
        try {
            Token accessToken = auth.getAccessToken(authData, new ApacheHttpTransport());
            this.request.getSession(true).setAttribute("access_token", accessToken);
            return "home";
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            return "error";
        }
    }
}
