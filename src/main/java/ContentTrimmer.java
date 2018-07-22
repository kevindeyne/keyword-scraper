import com.jaunt.Document;
import com.jaunt.Element;
import com.jaunt.Elements;

import java.util.ArrayList;
import java.util.List;

public class ContentTrimmer {

    public static final String REGEX = "[\\-“”\".;',:—…'’)]";

    public static String trim(String title, Document doc) {
        StringBuilder sb = new StringBuilder();
        Elements paragraphs = doc.findEvery("<p>");
        List<String> titleElements = splitTitle(title);
        for (Element paragraph : paragraphs) {
            String innerText = paragraph.innerText();
            if (doesContain(titleElements, innerText)) {
                sb.append(innerText.replaceAll(REGEX, " "));

                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static List<String> splitTitle(String title) {
        List<String> result = new ArrayList<>();
        String[] splitTitle = title.split(" ");
        for (String titlePart : splitTitle) {
            String e = titlePart.replaceAll(ContentTrimmer.REGEX, " ").toLowerCase();
            if (e.length() > 3) {
                result.add(e);
            }
        }

        if (result.isEmpty()) {
            result.add(title);
        }
        return result;
    }

    private static boolean doesContain(List<String> titleParts, String innerText) {
        for (String titlePart : titleParts) {
            if (innerText.toLowerCase().contains(titlePart)) {
                return true;
            }
        }
        return false;
    }
}
