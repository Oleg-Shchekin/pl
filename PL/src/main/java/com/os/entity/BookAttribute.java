package com.os.entity;

public class BookAttribute {
    private final int id;
    private final String keyWord;
    private final Language language;

    private final Book book;

    private BookAttribute(int id, String keyWord, Language language, Book book) {
        this.id = id;
        this.keyWord = keyWord;
        this.language = language;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public Language getLanguage() {
        return language;
    }

    public Book getBook() {
        return book;
    }

    public static class BookAttributeBuilder {
        private int id;
        private String keyWord;
        private Language language;
        private Book book;

        public BookAttributeBuilder() {
        }

        public BookAttributeBuilder setId(final int id) {
            this.id = id;
            return this;
        }

        public BookAttributeBuilder setKeyWord(final String keyWord) {
            this.keyWord = keyWord;
            return this;
        }

        public BookAttributeBuilder setLanguage(final Language language) {
            this.language = language;
            return this;
        }

        public BookAttributeBuilder setBook(final Book book) {
            this.book = book;
            return this;
        }
        public BookAttribute build(){
            return new BookAttribute(this.id, this.keyWord, this.language, this.book);
        }
    }

    @Override
    public String toString() {
        return "BookAttribute{" +
                "id=" + id +
                ", keyWord='" + keyWord + '\'' +
                ", language=" + language +
                '}';
    }
}
