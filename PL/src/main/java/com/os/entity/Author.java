package com.os.entity;

import java.util.List;

public class Author {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final List<Book> books;
    private Language language;


    private Author(int id, String firstName, String lastName, List<Book> books, Language language) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Language getLanguage() {
        return language;
    }

    public static class AuthorBuilder{
        private int id;
        private String firstName;
        private String lastName;
        private List<Book> books;
        private Language language;

        public AuthorBuilder() {
        }

        public AuthorBuilder setId(final int id) {
            this.id = id;
            return this;
        }

        public AuthorBuilder setFirstName( final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public AuthorBuilder setLastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public AuthorBuilder setBooks(final List<Book> books) {
            this.books = books;
            return this;
        }

        public AuthorBuilder setLanguage(Language language) {
            this.language = language;
            return this;
        }

        public Author build(){
            return new Author(this.id, this.firstName, this.lastName, this.books, this.language);
        }
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                ", language=" + language +
                '}';
    }
}
