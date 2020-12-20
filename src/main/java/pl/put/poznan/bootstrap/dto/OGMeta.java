package pl.put.poznan.bootstrap.dto;

import lombok.Data;

@Data
public class OGMeta {

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