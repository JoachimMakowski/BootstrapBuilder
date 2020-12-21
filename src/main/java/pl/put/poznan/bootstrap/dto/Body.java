package pl.put.poznan.bootstrap.dto;


import lombok.Data;

@Data
public class Body {

    @Override
    public String toString() {

        var sb = new StringBuilder();

        return String.format("<body>\n%s</body>", sb.toString());
    }
}