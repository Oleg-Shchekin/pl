package com.os.persistance.interfaces;


import com.os.entity.Book;
import com.os.entity.BookAttribute;
import com.os.entity.Language;

import java.util.List;

public interface BookDao extends Dao<Book>{
    Book getByIdAndLanguage(int bookId, Language language);
    List<Book> getAllAvailable();
    List<Book> getAllAvailableByLanguage(Language language);
    List<Book> getLastThree(Language language);
    List<Book> searchByParam(String param);
    List<BookAttribute> getBookAttributesByBookId(int book_id);
    List<BookAttribute> getBookAttributesByBookIdAndLanguage(int book_id, Language language);
}
