package pl.put.poznan.bootstrap.rest;

import org.junit.jupiter.api.Test;
class BootstrapBuilderControllerTest {

    @Test
    void shootMapInputToPageData() {
        BootstrapBuilderController bootstrapBuilderController = new BootstrapBuilderController();

        String json = "{\n" +
                "  \"title\":\"tytuł\",\n" +
                "  \"header\": \"głowa\",\n" +
                "  \"paragraph\": \"paragraf\",\n" +
                "  \"nav\": {\n" +
                "    \"links\": [\n" +
                "      {\"name\": \"nazwa\", \"url\": \"url\"},\n" +
                "      {\"name\": \"nazwa2\", \"url\": \"url\"}\n" +
                "    ]\n" +
                "  }\n" +
                "}";
        bootstrapBuilderController.post(json);
    }
}
