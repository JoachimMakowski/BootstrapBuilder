package pl.put.poznan.bootstrap.db;

import org.junit.jupiter.api.Test;
import pl.put.poznan.bootstrap.dto.Body;
import pl.put.poznan.bootstrap.dto.Head;
import pl.put.poznan.bootstrap.dto.PageData;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseTest {
    DataBase dataBase = new DataBase();
    @Test
    void deleteFromDataBase() {
        PageData pageData = new PageData();
        Body body = new Body();
        Head head = new Head();
        head.setTitle("asd");
        body.setHeader("This is header");
        pageData.setBody(body);
        pageData.setHead(head);
        String uuid = dataBase.savePageData(pageData);
        assertTrue(dataBase.deletePageData(uuid));
    }

    @Test
    void insertIntoDatabase() {
        PageData pageData = new PageData();
        Body body = new Body();
        Head head = new Head();
        head.setTitle("asd");
        body.setHeader("This is header");
        pageData.setBody(body);
        pageData.setHead(head);
        String uuid = dataBase.savePageData(pageData);
        assertEquals(dataBase.getPageData(uuid),pageData);
    }
}