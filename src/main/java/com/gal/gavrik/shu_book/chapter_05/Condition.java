package com.gal.gavrik.shu_book.chapter_05;

@FunctionalInterface
public interface Condition {

    boolean evaluate(Facts facts);
}
