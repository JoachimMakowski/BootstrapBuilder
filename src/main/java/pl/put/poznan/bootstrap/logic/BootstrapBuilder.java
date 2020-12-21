package pl.put.poznan.bootstrap.logic;

import pl.put.poznan.bootstrap.dto.PageData;

import java.sql.SQLOutput;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class BootstrapBuilder {

    private final PageData pageData;

    public BootstrapBuilder(PageData pageData){
        this.pageData = pageData;
    }

    public String toHTML(){

        String head = pageData.getHead().toString();
        //String header = pageData.getHeader().toString();
        String body = pageData.getBody().toString();
        StringBuilder html = new StringBuilder();
        html.append(head);
        //html.append(header);
        html.append(body);

        return html.toString();
    }
}
