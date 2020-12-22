package pl.put.poznan.bootstrap.dto;

import lombok.Data;

/**
 * Twitter tag class
 *
 * @author Bogumiła Walkowiak
 * @version 1.0
 */

@Data
public class TwitterMeta {

    /**
     * Takes name and content of a tag to create a web page fragment
     *
     * @return Single Twitter tag for the list
     */

    String content;
    String name;

    @Override
    public String toString(){
        if (name != null && content != null){
            return String.format("<meta name=\"%s\" content=\"%s\">", this.name, this.content);
        }
        else if(content == null){
            return String.format("<meta name=\"%s\" content=\"\">", this.name);
        }
        else return null;
    }

}