package com.gal.gavrik.shu_book.chapter_05;

import java.util.HashMap;
import java.util.Map;

public class Facts {
    private final Map<String, String> facts = new HashMap<>();

    public String getFact(final String name) {
        return this.facts.get(name);
    }

    public void setFact(final String name, final String value) {
        this.facts.put(name, value);
    }
}
