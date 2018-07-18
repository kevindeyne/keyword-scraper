import com.jaunt.Document;
import com.jaunt.Element;
import com.jaunt.Elements;

public class ContentTrimmer {

    public static final String REGEX = "[\\-“\".;',:—…'’)]";

    public static String trim(String title, Document doc) {
        StringBuilder sb = new StringBuilder();
        Elements paragraphs = doc.findEvery("<p>");
        for (Element paragraph : paragraphs) {
            String innerText = paragraph.innerText();
            if (innerText.contains(title)) {
                sb.append(innerText.replaceAll(REGEX, " "));

                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
