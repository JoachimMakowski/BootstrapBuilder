package pl.put.poznan.bootstrap.dto;

import lombok.Data;

import java.util.List;

@Data
public class Nav {
    List<Link> links;
    @Override
    public String toString() {
        if (links.isEmpty()) return "";
        else {
            var sb = new StringBuilder();
            links.forEach(element -> sb.append(String.format("  <li>%s</li>\n", element)));
            return String.format("<nav>\n%s</nav>", sb.toString());
        }
    }
}
