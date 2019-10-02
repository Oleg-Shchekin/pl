package com.os.entity;

import com.os.enums.Status;

import java.sql.Time;

public class Order {
    private final int id;
    private final Reader reader;
    private final Book book;
    private final Time time;
    private final Status status;

    private Order(int id, Reader reader, Book book, Time time, Status status) {
        this.id = id;
        this.reader = reader;
        this.book = book;
        this.time = time;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Reader getReader() {
        return reader;
    }

    public Book getBook() {
        return book;
    }

    public Time getTime() {
        return time;
    }

    public Status getStatus() {
        return status;
    }

    public static class OrderBuilder{
        private int id;
        private Reader reader;
        private Book book;
        private Time time;
        private Status status;

        public OrderBuilder setId(final int id) {
            this.id = id;
            return this;
        }

        public OrderBuilder setReader(final Reader reader) {
            this.reader = reader;
            return this;
        }

        public OrderBuilder setBook(final Book book) {
            this.book = book;
            return this;
        }

        public OrderBuilder setTime(final Time time) {
            this.time = time;
            return this;
        }

        public OrderBuilder setStatus(final Status status) {
            this.status = status;
            return this;
        }

        public Order build(){
            return new Order(id, reader, book, time, status);
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", reader=" + reader +
                ", book=" + book +
                ", time=" + time +
                '}';
    }
}
