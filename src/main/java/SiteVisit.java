import com.jaunt.Document;
import com.jaunt.ResponseException;
import com.jaunt.UserAgent;

public class SiteVisit {

    public static Document visit(String url) {
        try {
            UserAgent userAgent = new UserAgent();
            userAgent.visit(url);
            return userAgent.doc;
        } catch (ResponseException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
