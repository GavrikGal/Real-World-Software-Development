package com.gal.gavrik.shu_book.chapter_05;

public interface ConditionalAction {
    void perform(Facts facts);
    boolean evaluate(Facts facts);

}
