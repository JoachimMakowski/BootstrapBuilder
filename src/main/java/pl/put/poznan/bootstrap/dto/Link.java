package pl.put.poznan.bootstrap.dto;

import lombok.Data;

@Data
public class Link {
    String name;
    String url;

    @Override
    public String toString(){
        return String.format("<a href=\"%s\" name=\"%s\" </a>", this.url, this.name);
    }
}
