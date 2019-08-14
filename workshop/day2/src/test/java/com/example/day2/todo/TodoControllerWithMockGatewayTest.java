package com.example.day2.todo;

import org.junit.Test;

import static org.junit.Assert.*;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TodoControllerWithMockGatewayTest {

    @Autowired
    private PostGateway postGateway;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);

    @Test
    public void success_getPostBy_id_1() throws IOException {
        // Arrange
        wireMockRule.stubFor(get(urlPathEqualTo("/1"))
                .willReturn(aResponse()
                        .withBody(read("classpath:post/post_response_success.json"))
                        .withHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(200)));

        // Act
        Optional<PostResponse> postResponse = postGateway.getPostBy(1);

        // Assert
        assertTrue(postResponse.isPresent());
        assertEquals(1, postResponse.get().getId());
        assertEquals(1, postResponse.get().getUserId());
        assertEquals("Mock title", postResponse.get().getTitle());
        assertEquals("Mock body", postResponse.get().getBody());

    }

    private String read(String filePath) throws IOException {
        File file = ResourceUtils.getFile(filePath);
        return new String(Files.readAllBytes(file.toPath()));
    }
}