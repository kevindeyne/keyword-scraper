import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;

public class ScrapeList {

    private static final String METACRITIC_PC_LIST = "http://www.metacritic.com/browse/games/score/metascore/all/pc/filtered?sort=desc&page=";
    private static final String DIV_MAIN = "<div id=main>";
    private static final String A = "<a>";
    private int page = 0;

    public ScrapeList() {
        try {
            UserAgent userAgent = new UserAgent();
            userAgent.visit(METACRITIC_PC_LIST + page);

            Elements elems = userAgent.doc.findFirst(DIV_MAIN).findEvery(A);
            for (Element e : elems) {
                if(e.getAt("href").contains("/game/pc/")){
                    System.out.println(e.innerText().trim());
                }
            }

        } catch (JauntException je) {
            throw new RuntimeException(je.getMessage(), je);
        }
    }

}
