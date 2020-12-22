package pl.put.poznan.bootstrap.dto;

import lombok.Data;

/**
 * OpenGraph tag class
 *
 * @author Bogumiła Walkowiak
 * @version 1.0
 */

@Data
public class OGMeta {

    /**
     * Takes property and content of a tag to create a web page fragment
     *
     * @return Single OpenGraph tag for the list
     */

    String content;
    String property;

    @Override
    public String toString(){

        if (property != null && content != null){
            return String.format("<meta property=\"%s\" content=\"%s\">", this.property, this.content);
        }
        else if(content == null){
            return String.format("<meta property=\"%s\" content=\"\">", this.property);
        }
        else return null;
    }

}