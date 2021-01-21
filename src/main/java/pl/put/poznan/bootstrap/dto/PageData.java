package pl.put.poznan.bootstrap.dto;

import lombok.Data;

/**
 * Class created to pass HTML elements from .json to head and body classes
 *
 * @author JoachimMakowski
 * @version 1.0
 */

@Data
public class PageData {
    /**
     * Takes page's head and body; rest of parameters are for testing only
     */

    Head head;
    Body body;

    public String toString() {
        var sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html>\n");
        if (head != null){
            sb.append(head.toString());
        }
        if(body != null){
            sb.append(body.toString());
        }

        if (body ==null && head ==null) return "";
        sb.append("\n</html>");
        return sb.toString();
    }
}
