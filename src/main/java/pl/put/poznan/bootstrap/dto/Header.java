package pl.put.poznan.bootstrap.dto;

import lombok.Data;

@Data
public class Header {
    String pageHeader;
    public String toString() {

        var sb = new StringBuilder();

        if(pageHeader != null){
            sb.append(String.format(
                    "<header class=\"page-header\">\n" +
                    "   <h1>%s</h1>\n" +
                    "</header>\n", pageHeader));
        }

        if(pageHeader == null) return "";

        return sb.toString();
    }
}
