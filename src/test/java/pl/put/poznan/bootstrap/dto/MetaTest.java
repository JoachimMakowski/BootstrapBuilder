package pl.put.poznan.bootstrap.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MetaTest {

    @Test
    void everythingNull(){
        Meta meta = new Meta();
        assertEquals(null,meta.toString());
    }

    @Test
    void contentAndName(){
        Meta meta = new Meta();
        meta.setName("viewport");
        meta.setContent("width=device-width, initial-scale=1, shrink-to-fit=no");
        assertEquals("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">",meta.toString());
    }

    @Test
    void charsetTest(){
        Meta meta = new Meta();
        meta.setCharset("utf-8");
        assertEquals("<meta charset=\"utf-8\">",meta.toString());
    }
}