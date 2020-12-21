package pl.put.poznan.bootstrap.dto;


import lombok.Data;
import java.util.List;

@Data
public class Head {

    String title;
    List<Meta> meta_tags;
    List<OGMeta> og_tags;
    List<TwitterMeta> twitter_tags;

    public String toString() {

        var sb = new StringBuilder();

        if (meta_tags != null) {
            meta_tags.forEach(element -> sb.append(String.format("  %s\n", element)));
        }

        if (title != null){
            sb.append(String.format("  <title>%s</title>\n", title));
        }

        if (og_tags != null) {
            og_tags.forEach(element -> sb.append(String.format("  %s\n", element)));
        }

        if (twitter_tags != null) {
            //!twitter_tags.isEmpty()
            twitter_tags.forEach(element -> sb.append(String.format("  %s\n", element)));
        }

        if(meta_tags == null && og_tags == null && twitter_tags == null && title == null) return "";

        return String.format("<head>\n%s</head>", sb.toString());
    }
}
