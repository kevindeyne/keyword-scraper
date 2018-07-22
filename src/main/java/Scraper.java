import com.jaunt.*;

import java.util.*;

public class Scraper {

    private String title;

    public Scraper(String title) {
        this.title = title;

        //TODO which keywords appear in multiple documents but not the test document?
        //TODO the sooner added the more important? (more relevant search results with google)
        //TODO words earlier are more important?
        //TODO words around the game name are more important?
        //TODO detect if english

        Set<String> blindKeywords = getBlindKeywords();

        List<Element> links = Googler.googleSearch(title);
        for (Element element : links) {
            try {
                String link = Googler.getURLFromGoogleLink(element);
                if(!DBConstants.hasProcessedUrl(link)){
                    String content = trimPageContentToRelevantSection(link);
                    DBConstants.persistDocument(content, link);

                    Map<String, Integer> keywords = KeywordExtractor.extract(title, blindKeywords, content);
                    //keywords = sortHashMapByValues(keywords);
                    for(String keyword : keywords.keySet()){
                        DBConstants.persistKeyword(title, keyword, keywords.get(keyword));
                    }

                    System.out.println("... " + keywords);
                }
            } catch (RuntimeException re) {
                //TODO
            }
        }

        System.out.println("> done ");
    }

    public LinkedHashMap<String, Integer> sortHashMapByValues(Map<String, Integer> passedMap) {
        List<String> mapKeys = new ArrayList<>(passedMap.keySet());
        List<Integer> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

        Iterator<Integer> valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Integer val = valueIt.next();
            Iterator<String> keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                String key = keyIt.next();
                Integer comp1 = passedMap.get(key);
                Integer comp2 = val;

                if (comp1.equals(comp2)) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        return sortedMap;
    }

    private Set<String> getBlindKeywords() {
        System.out.println("> Blind loaded");
        return KeywordExtractor.extract("", new HashSet<>(), Blinds.CALL_OF_DUTY).keySet();
    }

    private String trimPageContentToRelevantSection(String link) {
        link = LinkCleaner.unGoogleURL(link);
        Document visit = SiteVisit.visit(link);
        String trimmedText = ContentTrimmer.trim(title, visit);
        //System.out.println("> printing scraper: " + trimmedText);
        return trimmedText;
    }
}