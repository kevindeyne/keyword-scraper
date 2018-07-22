/*
 * This file is generated by jOOQ.
 */
package sql.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import sql.Indexes;
import sql.Keys;
import sql.Webcrawler;
import sql.tables.records.ScrapedDocumentRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ScrapedDocument extends TableImpl<ScrapedDocumentRecord> {

    private static final long serialVersionUID = 2119520979;

    /**
     * The reference instance of <code>webcrawler.scraped_document</code>
     */
    public static final ScrapedDocument SCRAPED_DOCUMENT = new ScrapedDocument();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ScrapedDocumentRecord> getRecordType() {
        return ScrapedDocumentRecord.class;
    }

    /**
     * The column <code>webcrawler.scraped_document.id</code>.
     */
    public final TableField<ScrapedDocumentRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>webcrawler.scraped_document.text</code>.
     */
    public final TableField<ScrapedDocumentRecord, String> TEXT = createField("text", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>webcrawler.scraped_document.url</code>.
     */
    public final TableField<ScrapedDocumentRecord, String> URL = createField("url", org.jooq.impl.SQLDataType.VARCHAR(1000).nullable(false), this, "");

    /**
     * Create a <code>webcrawler.scraped_document</code> table reference
     */
    public ScrapedDocument() {
        this(DSL.name("scraped_document"), null);
    }

    /**
     * Create an aliased <code>webcrawler.scraped_document</code> table reference
     */
    public ScrapedDocument(String alias) {
        this(DSL.name(alias), SCRAPED_DOCUMENT);
    }

    /**
     * Create an aliased <code>webcrawler.scraped_document</code> table reference
     */
    public ScrapedDocument(Name alias) {
        this(alias, SCRAPED_DOCUMENT);
    }

    private ScrapedDocument(Name alias, Table<ScrapedDocumentRecord> aliased) {
        this(alias, aliased, null);
    }

    private ScrapedDocument(Name alias, Table<ScrapedDocumentRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> ScrapedDocument(Table<O> child, ForeignKey<O, ScrapedDocumentRecord> key) {
        super(child, key, SCRAPED_DOCUMENT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Webcrawler.WEBCRAWLER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.SCRAPED_DOCUMENT_PRIMARY, Indexes.SCRAPED_DOCUMENT_URL_UNIQUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ScrapedDocumentRecord, Integer> getIdentity() {
        return Keys.IDENTITY_SCRAPED_DOCUMENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ScrapedDocumentRecord> getPrimaryKey() {
        return Keys.KEY_SCRAPED_DOCUMENT_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ScrapedDocumentRecord>> getKeys() {
        return Arrays.<UniqueKey<ScrapedDocumentRecord>>asList(Keys.KEY_SCRAPED_DOCUMENT_PRIMARY, Keys.KEY_SCRAPED_DOCUMENT_URL_UNIQUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScrapedDocument as(String alias) {
        return new ScrapedDocument(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScrapedDocument as(Name alias) {
        return new ScrapedDocument(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ScrapedDocument rename(String name) {
        return new ScrapedDocument(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ScrapedDocument rename(Name name) {
        return new ScrapedDocument(name, null);
    }
}