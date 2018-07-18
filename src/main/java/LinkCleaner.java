public class LinkCleaner {

    private static final String AMP_SA_U = "&amp;sa=U&";

    public static String unGoogleURL(String link) {
        return link.substring(28, link.indexOf(AMP_SA_U));
    }

}
