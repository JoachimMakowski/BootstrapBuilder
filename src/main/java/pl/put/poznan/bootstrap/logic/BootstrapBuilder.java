package pl.put.poznan.bootstrap.logic;

import pl.put.poznan.bootstrap.dto.PageData;

import java.sql.SQLOutput;

/**
 * Class creating ready-to-paste template
 *
 * @author Bogumiła Walkowiak
 * @version 1.0
 */
public class BootstrapBuilder {

    /**
     * Combining strings to one
     *
     * @params pageData (certain attributes)
     * @return BootstrapBuilder html template as a string
     */

    private final PageData pageData;

    public BootstrapBuilder(PageData pageData){
        this.pageData = pageData;
    }

    public String toHTML(){

        String head = pageData.getHead().toString();
        String body = pageData.getBody().toString();
        StringBuilder html = new StringBuilder();
        html.append(head);
        html.append(body);

        return html.toString();
    }
}
