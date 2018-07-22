/*
 * This file is generated by jOOQ.
 */
package sql;


import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;

import sql.tables.Keyword;
import sql.tables.ScrapedDocument;


/**
 * A class modelling indexes of tables of the <code>webcrawler</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index KEYWORD_PRIMARY = Indexes0.KEYWORD_PRIMARY;
    public static final Index SCRAPED_DOCUMENT_PRIMARY = Indexes0.SCRAPED_DOCUMENT_PRIMARY;
    public static final Index SCRAPED_DOCUMENT_URL_UNIQUE = Indexes0.SCRAPED_DOCUMENT_URL_UNIQUE;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index KEYWORD_PRIMARY = Internal.createIndex("PRIMARY", Keyword.KEYWORD, new OrderField[] { Keyword.KEYWORD.ID }, true);
        public static Index SCRAPED_DOCUMENT_PRIMARY = Internal.createIndex("PRIMARY", ScrapedDocument.SCRAPED_DOCUMENT, new OrderField[] { ScrapedDocument.SCRAPED_DOCUMENT.ID }, true);
        public static Index SCRAPED_DOCUMENT_URL_UNIQUE = Internal.createIndex("url_UNIQUE", ScrapedDocument.SCRAPED_DOCUMENT, new OrderField[] { ScrapedDocument.SCRAPED_DOCUMENT.URL }, true);
    }
}
