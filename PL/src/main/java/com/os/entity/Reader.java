package com.os.entity;

public class Reader {
    private final int id;
    private final String email;
    private final String password;
    private final String telephoneNumber;
    private final String firstName;
    private final String lastName;

    public Reader(int id, String email, String password, String telephoneNumber, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.telephoneNumber = telephoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static class ReaderBuilder{

        private int id;
        private String email;
        private String password;
        private String telephoneNumber;
        private String firstName;
        private String lastName;

        public ReaderBuilder(){}

        public ReaderBuilder setId(final int id) {
            this.id = id;
            return this;
        }

        public ReaderBuilder setEmail(final String email) {
            this.email = email;
            return this;
        }

        public ReaderBuilder setPassword(final String password) {
            this.password = password;
            return this;
        }

        public ReaderBuilder setTelephoneNumber(final String telephoneNumber) {
            this.telephoneNumber = telephoneNumber;
            return this;
        }

        public ReaderBuilder setLastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ReaderBuilder setFirstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Reader build(){
            return new Reader(id, email, password, telephoneNumber, firstName, lastName);
        }
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }
}
