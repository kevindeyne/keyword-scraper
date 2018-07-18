import com.jaunt.*;

import java.util.*;

public class Scraper {

    private String title;

    public Scraper(String title) {
        this.title = title;

        //TODO which keywords appear in multiple documents but not the test document?

        Set<String> blindKeywords = getBlindKeywords();

        List<Element> links = Googler.googleSearch(title);
        for(Element element : links){
            try {
                String link = Googler.getURLFromGoogleLink(element);
                String content = trimPageContentToRelevantSection(link);
                //TODO detect if english
                Map<String, Integer> keywords = KeywordExtractor.extract(blindKeywords, content);
                System.out.println("> " + keywords);

            } catch (RuntimeException re) {
                //TODO
            }
        }
    }

    private Set<String> getBlindKeywords() {
        System.out.println("> Blind loaded");
        return KeywordExtractor.extract(new HashSet<>(), Blinds.CALL_OF_DUTY).keySet();
    }

    private String trimPageContentToRelevantSection(String link) {
        link = LinkCleaner.unGoogleURL(link);
        Document visit = SiteVisit.visit(link);
        String trimmedText = ContentTrimmer.trim(title, visit);
        //System.out.println("> printing scraper: " + trimmedText);
        return trimmedText;
    }
}