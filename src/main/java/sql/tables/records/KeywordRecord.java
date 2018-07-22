/*
 * This file is generated by jOOQ.
 */
package sql.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

import sql.tables.Keyword;


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
public class KeywordRecord extends UpdatableRecordImpl<KeywordRecord> implements Record4<Integer, String, String, Integer> {

    private static final long serialVersionUID = -1246429841;

    /**
     * Setter for <code>webcrawler.keyword.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>webcrawler.keyword.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>webcrawler.keyword.game</code>.
     */
    public void setGame(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>webcrawler.keyword.game</code>.
     */
    public String getGame() {
        return (String) get(1);
    }

    /**
     * Setter for <code>webcrawler.keyword.keyword</code>.
     */
    public void setKeyword(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>webcrawler.keyword.keyword</code>.
     */
    public String getKeyword() {
        return (String) get(2);
    }

    /**
     * Setter for <code>webcrawler.keyword.strength</code>.
     */
    public void setStrength(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>webcrawler.keyword.strength</code>.
     */
    public Integer getStrength() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, String, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, String, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Keyword.KEYWORD.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Keyword.KEYWORD.GAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Keyword.KEYWORD.KEYWORD_;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Keyword.KEYWORD.STRENGTH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getGame();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getKeyword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getStrength();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getGame();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getKeyword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getStrength();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public KeywordRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public KeywordRecord value2(String value) {
        setGame(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public KeywordRecord value3(String value) {
        setKeyword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public KeywordRecord value4(Integer value) {
        setStrength(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public KeywordRecord values(Integer value1, String value2, String value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached KeywordRecord
     */
    public KeywordRecord() {
        super(Keyword.KEYWORD);
    }

    /**
     * Create a detached, initialised KeywordRecord
     */
    public KeywordRecord(Integer id, String game, String keyword, Integer strength) {
        super(Keyword.KEYWORD);

        set(0, id);
        set(1, game);
        set(2, keyword);
        set(3, strength);
    }
}
