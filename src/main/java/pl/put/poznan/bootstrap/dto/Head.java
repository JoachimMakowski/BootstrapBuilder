package pl.put.poznan.bootstrap.dto;


import lombok.Data;
import java.util.List;

@Data
public class Head {

    List<Meta> meta_tags;

    public String toString() {
        if (meta_tags.isEmpty()) return "";
        else {
            var sb = new StringBuilder();
            meta_tags.forEach(element -> sb.append(String.format("  %s\n", element)));
            return String.format("<head>\n%s</head>", sb.toString());
        }
    }
}
