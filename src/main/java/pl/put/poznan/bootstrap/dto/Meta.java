package pl.put.poznan.bootstrap.dto;

import lombok.Data;

@Data
public class Meta {

    String charset;
    String content;
    String http_equiv;
    String name;

    @Override
    public String toString(){
        if (charset != null){
            return String.format("<meta charset=\"%s\">", this.charset);
        }
        else if (name != null && content != null){
            return String.format("<meta name=\"%s\" content=\"%s\">", this.name, this.content);
        }
        else if (http_equiv != null && content != null){
            return String.format("<meta http-equiv=\"%s\" content=\"%s\">", this.http_equiv, this.content);
        }
        else return null;
    }

}