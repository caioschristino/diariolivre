package com.caiodev.diario.diariolivreoficial.Model;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public class Pages {
    private int current_page;
    private int next_page;
    private Object prev_page;
    private int total_pages;
    private int limit_value;
    private int offset_value;
    private int total_count;
    private boolean is_first_page;
    private boolean is_last_page;

    public int getCurrent_page() {
        return current_page;
    }

    public int getNext_page() {
        return next_page;
    }

    public Object getPrev_page() {
        return prev_page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public int getLimit_value() {
        return limit_value;
    }

    public int getOffset_value() {
        return offset_value;
    }

    public int getTotal_count() {
        return total_count;
    }

    public boolean is_first_page() {
        return is_first_page;
    }

    public boolean is_last_page() {
        return is_last_page;
    }
}
