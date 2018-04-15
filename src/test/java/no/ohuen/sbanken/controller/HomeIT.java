package no.ohuen.sbanken.controller;

import static org.junit.Assert.assertThat;

import java.net.URL;
import org.hamcrest.Matchers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeIT {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void getFirstPage() throws Exception {
        ResponseEntity<String> response = template.getForEntity(this.base.toString(),
                String.class);
        assertThat(response.getBody(), Matchers.containsString("DISCLAIMER"));
    }
    @Test
    public void getSecondPage() throws Exception {
        ResponseEntity<String> response = template.getForEntity(this.base.toString(),
                String.class);
        assertThat(response.getBody(), Matchers.containsString("Client ID"));
    }
}