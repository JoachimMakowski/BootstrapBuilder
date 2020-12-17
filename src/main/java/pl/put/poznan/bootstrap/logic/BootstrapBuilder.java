package pl.put.poznan.bootstrap.logic;

import pl.put.poznan.bootstrap.dto.PageData;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class BootstrapBuilder {

    private final PageData pageData;

    public BootstrapBuilder(PageData pageData){
        this.pageData = pageData;
    }

    public String transform(String text){
        // of course, normally it would do something based on the transforms
        return text.toUpperCase();
    }
    public String toHTML(){
        return "HTML String";
    }
}
