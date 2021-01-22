package pl.put.poznan.bootstrap.logic;

import pl.put.poznan.bootstrap.dto.PageData;

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

        String html = pageData.toString();

        return html;
    }
}
