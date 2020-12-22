package pl.put.poznan.bootstrap.dto;

import lombok.Data;

/**
 * META tag class
 *
 * @author Bogumiła Walkowiak
 * @version 1.0
 */


@Data
public class Meta {

    /**
     * Takes charset and content of a tag to create a web page fragment
     *
     * @return Single META tag for the list
     */

    String charset;
    String content;
    String name;

    @Override
    public String toString(){
        if (charset != null){
            return String.format("<meta charset=\"%s\">", this.charset);
        }
        else if (name != null && content != null){
            return String.format("<meta name=\"%s\" content=\"%s\">", this.name, this.content);
        }
        else return null;
    }

}