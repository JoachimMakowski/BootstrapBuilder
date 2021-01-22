package pl.put.poznan.bootstrap.dto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class HeadTest {

    Meta mockedMeta = mock(Meta.class);
    OGMeta mockedOGMeta = mock(OGMeta.class);
    TwitterMeta mockedTwitterMeta = mock(TwitterMeta.class);
    Head head = new Head();

    @Test
    void metaTags(){
        when(mockedMeta.toString()).thenReturn("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
        List<Meta> meta_tags= new ArrayList<>();
        meta_tags.add(mockedMeta);
        head.setMeta_tags(meta_tags);
        assertEquals("<head>\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n\n" +
                "  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n" +
                "</head>\n",head.toString());
    }

    @Test
    void OGMetaTags(){
        when(mockedOGMeta.toString()).thenReturn("<meta property=\"og:title\" content=\"Open Graph title\">");
        List<OGMeta> OGMeta_tags= new ArrayList<>();
        OGMeta_tags.add(mockedOGMeta);
        head.setOg_tags(OGMeta_tags);
        assertEquals("<head>\n" +
                "  <meta property=\"og:title\" content=\"Open Graph title\">\n\n" +
                "  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n" +
                "</head>\n",head.toString());
    }

    @Test
    void TwitterMetaTags(){
        when(mockedTwitterMeta.toString()).thenReturn("<meta name=\"twitter:title\" content=\"Twitter title\">");
        List<TwitterMeta> TwitterMeta_tags= new ArrayList<>();
        TwitterMeta_tags.add(mockedTwitterMeta);
        head.setTwitter_tags(TwitterMeta_tags);
        assertEquals("<head>\n" +
                "  <meta name=\"twitter:title\" content=\"Twitter title\">\n\n" +
                "  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n" +
                "</head>\n",head.toString());
    }

    @Test
    void nullTest(){
        assertEquals("",head.toString());
    }

    @Test
    void fullTest(){
        when(mockedMeta.toString()).thenReturn("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
        List<Meta> meta_tags= new ArrayList<>();
        meta_tags.add(mockedMeta);
        head.setMeta_tags(meta_tags);
        when(mockedOGMeta.toString()).thenReturn("<meta property=\"og:title\" content=\"Open Graph title\">");
        List<OGMeta> OGMeta_tags= new ArrayList<>();
        OGMeta_tags.add(mockedOGMeta);
        OGMeta_tags.add(mockedOGMeta);
        OGMeta_tags.add(mockedOGMeta);
        head.setOg_tags(OGMeta_tags);
        when(mockedTwitterMeta.toString()).thenReturn("<meta name=\"twitter:title\" content=\"Twitter title\">");
        List<TwitterMeta> TwitterMeta_tags= new ArrayList<>();
        TwitterMeta_tags.add(mockedTwitterMeta);
        head.setTwitter_tags(TwitterMeta_tags);
        assertEquals("<head>\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                "  <meta property=\"og:title\" content=\"Open Graph title\">\n" +
                "  <meta property=\"og:title\" content=\"Open Graph title\">\n" +
                "  <meta property=\"og:title\" content=\"Open Graph title\">\n" +
                "  <meta name=\"twitter:title\" content=\"Twitter title\">\n\n" +
                "  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n" +
                "</head>\n",head.toString());
        verify(mockedOGMeta,times(3));
    }
}