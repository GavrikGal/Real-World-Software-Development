package com.gal.gavrik.shu_book.chapter_04;

import java.io.File;
import java.io.IOException;

public interface Importer {
    Document importFile(File file) throws IOException;
}