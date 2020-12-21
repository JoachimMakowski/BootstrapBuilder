package pl.put.poznan.bootstrap.dto;


import lombok.Data;
import java.util.List;

@Data
public class Body {

    String navBar;
    String buttonOne;
    String pageText;


    public String toString() {

        var sb = new StringBuilder();

        if (navBar != null){
            sb.append(String.format(
                    "  <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark static-top\">\n" +
                    "    <div class=\"container\">\n" +
                    "      <a class=\"navbar-brand\" href=\"#\">%s</a>\n" +
                    "      <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
                    "        <span class=\"navbar-toggler-icon\"></span>\n" +
                    "      </button>\n" +
                    "      <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\n" +
                    "        <ul class=\"navbar-nav ml-auto\">\n" +
                    "          <li class=\"nav-item active\">\n", navBar));
        }

        if (buttonOne != null){
            sb.append(String.format(
                    "            <a class=\"nav-link\" href=\"#\">%s</a>\n" +
                    "          </li>\n" +
                    "        </ul>\n" +
                    "      </div>\n" +
                    "    </div>\n" +
                    "  </nav>\n", buttonOne));
        }

        if (pageText != null){
            sb.append(String.format(
                    "  <div class=\"container\">\n" +
                    "    <div class=\"row\">\n" +
                    "      <div class=\"col-lg-12 text-center\">\n" +
                    "        <ul class=\"list-unstyled\">\n" +
                    "          <li>%s</li>\n" +
                    "        </ul>\n" +
                    "      </div>\n" +
                    "    </div>\n" +
                    "  </div>\n", pageText));
        }

        if(navBar == null && buttonOne == null && pageText == null) return "";

        return String.format("\n<body>\n%s</body>\n\n</html>", sb.toString());
    }
}
