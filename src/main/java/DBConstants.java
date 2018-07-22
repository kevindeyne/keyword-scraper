import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import sql.Tables;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConstants {

    public static String userName = "root";
    public static String password = "";
    public static String dburl = "jdbc:mysql://localhost:3306/webcrawler?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";


    public static boolean hasProcessedUrl(String url){
        try (Connection conn = DriverManager.getConnection(dburl, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            return create.fetchExists(create.selectOne()
                    .from(Tables.SCRAPED_DOCUMENT)
                    .where(Tables.SCRAPED_DOCUMENT.URL.eq(url)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void persistDocument(String text, String url) {
        try (Connection conn = DriverManager.getConnection(dburl, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            create.insertInto(Tables.SCRAPED_DOCUMENT,
                    Tables.SCRAPED_DOCUMENT.TEXT, Tables.SCRAPED_DOCUMENT.URL)
                    .values(text, url)
                    .execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void persistKeyword(String game, String keyword, Integer strength) {
        try (Connection conn = DriverManager.getConnection(dburl, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            create.insertInto(Tables.KEYWORD,
                    Tables.KEYWORD.GAME, Tables.KEYWORD.KEYWORD_, Tables.KEYWORD.STRENGTH)
                    .values(game, keyword, strength)
                    .execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
