import com.jaunt.*;

import java.util.ArrayList;
import java.util.List;

public class Googler {

    private static final String GOOGLE_URL = "http://google.com";
    private static final String GOOGLE_SEARCH = "Google Search";

    private static final String H3_CLASS_R = "<h3 class=r>";
    private static final String A = "<a>";

    private static final String REVIEW = " review";
    private static final String HREF = "href";

    public static List<Element> googleSearch(String title) {
        try {
            List<Element> result = new ArrayList<>();

            UserAgent userAgent = new UserAgent();
            userAgent.visit(GOOGLE_URL);
            userAgent.doc.apply(title + REVIEW);
            userAgent.doc.submit(GOOGLE_SEARCH);

            Elements every = userAgent.doc.findEvery(H3_CLASS_R).findEvery(A);
            for (Element e : every) {
                result.add(e);
            }

            return result;
        } catch (JauntException je) {
            throw new RuntimeException(je.getMessage(), je);
        }
    }

    public static String getURLFromGoogleLink(Element elem) {
        try {
            return elem.getAt(HREF);
        } catch (JauntException je) {
            throw new RuntimeException(je.getMessage(), je);
        }
    }
}
