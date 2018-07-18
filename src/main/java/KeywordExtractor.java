import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class KeywordExtractor {

    public static Map<String, Integer> extract(Set<String> blindKeywords, String text) {
        try (InputStream modelIn = KeywordExtractor.class.getResourceAsStream("/en-pos-maxent.bin")) {
            POSModel model = new POSModel(modelIn);
            POSTaggerME tagger = new POSTaggerME(model);

            String[] split = text.split(" ");
            String tags[] = tagger.tag(split);

            Map<String, Integer> result = new HashMap<>();
            for (int i = 0; i < tags.length; i++) {
                if (acceptableTag(tags[i])) {
                    String key = cleanKey(split[i]);
                    if (acceptableKey(blindKeywords, key)) {
                        if (result.get(key) == null) {
                            result.put(key, 1);
                        } else {
                            result.put(key, result.get(key) + 1);
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
