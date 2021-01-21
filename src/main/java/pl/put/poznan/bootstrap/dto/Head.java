package pl.put.poznan.bootstrap.dto;


import lombok.Data;
import java.util.List;

/**
 * Class created to make HTML body template
 *
 * Takes page title and 3 lists of used META, OpenGraph or Twitter tags.
 *
 * @author Bogumiła Walkowiak
 * @version 1.0
 */

@Data
public class Head {

    String title;
    List<Meta> meta_tags;
    List<OGMeta> og_tags;
    List<TwitterMeta> twitter_tags;

    /**
     * Class created to make HTML body template
     *
     * @return Beginning of HTML document - CDN tag for Bootstrap and head.
     */

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
            twitter_tags.forEach(element -> sb.append(String.format("  %s\n", element)));
        }

        if(meta_tags == null && og_tags == null && twitter_tags == null && title == null) return "";

        return String.format("<head>\n%s\n" +
                "  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n</head>\n", sb.toString());
    }
}
