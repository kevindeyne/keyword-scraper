import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class KeywordExtractor {

    private static final String SPACE = " ";

    public static Map<String, Integer> extract(String title, Set<String> blindKeywords, String text) {
        try (InputStream modelIn = KeywordExtractor.class.getResourceAsStream("/en-pos-maxent.bin")) {
            POSModel model = new POSModel(modelIn);
            POSTaggerME tagger = new POSTaggerME(model);

            String[] split = text.split(SPACE);
            String tags[] = tagger.tag(split);

            int locationOfTitle = Arrays.stream(split).collect(Collectors.toList()).indexOf(ContentTrimmer.splitTitle(title).get(0));

            Map<String, Integer> result = new HashMap<>();
            for (int i = 0; i < tags.length; i++) {

                if (acceptableTag(tags[i])) {
                    String key = cleanKey(split[i]);
                    if (acceptableKey(blindKeywords, key)) {
                        //key += "["+tags[i]+"]";
                        int distance = Math.abs(locationOfTitle - i);
                        if (result.get(key) == null || result.get(key) > distance) {
                            result.put(key, distance);
                        }
                    }
                }
            }

            if(result.size() == 0){
                throw new RuntimeException("Ignore me");
            }

            return result;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static String cleanKey(String s) {
        return s.replaceAll(ContentTrimmer.REGEX, "").toLowerCase().trim();
    }

    private static boolean acceptableKey(Set<String> blindKeywords, String key) {
        return key.length() > 2 && !blindKeywords.contains(key);
    }

    private static List<String> acceptable = Arrays.asList("NNS", "NNP", "NN");

    private static boolean acceptableTag(String tag) {
        return acceptable.contains(tag);
    }
}
