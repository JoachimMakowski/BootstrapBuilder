package pl.put.poznan.bootstrap.rest;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

class BootstrapBuilderControllerTest {

    @Test
    void shootMapInputToPageData() {
        BootstrapBuilderController bootstrapBuilderController = new BootstrapBuilderController();
        try(InputStream inputStream = this.getClass().getResourceAsStream("test.json")){
            String json = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}