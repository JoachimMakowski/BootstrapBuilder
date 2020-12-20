package pl.put.poznan.bootstrap.dto;

import lombok.Data;

@Data
public class TwitterMeta {

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