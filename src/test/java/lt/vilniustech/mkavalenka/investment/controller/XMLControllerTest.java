package lt.vilniustech.mkavalenka.investment.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link XMLController}.
 * <p>
 * This test verifies that the XMLController is working as expected by sending a GET request
 * and ensuring the response is valid, returning HTTP 200 status, and the correct file name.
 * </p>
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class XMLControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Verifies that the GET request to the "/api/xml" endpoint returns a valid response.
     * <p>
     * This test checks that the HTTP status is 200 OK, the response body is not null,
     * and it contains the expected "data.xml" filename.
     * </p>
     */
    @Test
    void getAllDataResponseIsValid() {
        String url = "http://localhost:" + port + "/api/xml";

        // Send GET request to the endpoint
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode(), "Expected HTTP 200 OK");

        String responseBody = response.getBody();
        assertNotNull(responseBody);

        assertTrue(responseBody.contains("data.xml"));

    }
}
