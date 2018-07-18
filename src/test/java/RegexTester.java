import org.junit.Assert;
import org.junit.Test;

public class RegexTester {

    @Test
    public void testRegex() {
        Assert.assertEquals("bugs", "bugs.".replaceAll(ContentTrimmer.REGEX, ""));
        Assert.assertEquals("vampyr", "vampyr;".replaceAll(ContentTrimmer.REGEX, ""));
        Assert.assertEquals("vampyrs", "vampyr's".replaceAll(ContentTrimmer.REGEX, ""));
        Assert.assertEquals("relationships", "relationships,".replaceAll(ContentTrimmer.REGEX, ""));
        Assert.assertEquals("sequel", "sequel…".replaceAll(ContentTrimmer.REGEX, ""));
    }
}
