package pl.put.poznan.bootstrap.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import pl.put.poznan.bootstrap.db.DataBase;
import pl.put.poznan.bootstrap.dto.Body;
import pl.put.poznan.bootstrap.dto.Head;
import pl.put.poznan.bootstrap.dto.PageData;
import pl.put.poznan.bootstrap.logic.BootstrapBuilder;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BootstrapBuilderControllerTest {

    BootstrapBuilder mockedBootstrapBuilder = mock(BootstrapBuilder.class);
    DataBase dataBase = new DataBase();
    static final ObjectMapper objectMapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    @Test
    void testJSON() {//to check if json is correct

        try(InputStream inputStream = this.getClass().getResourceAsStream("test.json")){
            String json = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            PageData pageData = objectMapper.readValue(json, PageData.class);
            assertEquals(pageData.getBody().getNavBar(),"Header: page topic");
            assertEquals(pageData.getHead().getTitle(),"tytuł");
            System.out.println(pageData.toString());
        } catch(Exception e){
            e.printStackTrace();
        }
    }


    @Test
    void getPageFromDatabase() {

        PageData pageData = new PageData();
        Body body = new Body();
        Head head = new Head();
        head.setTitle("asd");
        body.setHeader("This is header");
        pageData.setBody(body);
        pageData.setHead(head);
        String uuid = dataBase.savePageData(pageData);
        when(mockedBootstrapBuilder.toHTML()).thenReturn("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "  <title>asd</title>\n" +
                "\n" +
                "  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "  <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark This is header-top\">\n" +
                "</body>" +
                "" +
                "</html>");
        assertEquals(dataBase.getPageData(uuid).toString(),pageData.toString());

    }

}