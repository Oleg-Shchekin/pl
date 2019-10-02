package com.os.entity;

public class Administrator {
    private final int id;
    private final String login;
    private final String password;

    public Administrator(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public static class AdministratorBuilder{
        private int id;
        private String login;
        private String password;

        public AdministratorBuilder() {
        }

        public AdministratorBuilder setId(final int id){
            this.id = id;
            return this;
        }

        public AdministratorBuilder setPassword(final String password) {
            this.password = password;
            return this;
        }

        public AdministratorBuilder setLogin(final String login) {
            this.login = login;
            return this;
        }

        public Administrator build(){
            return new Administrator(id, login, password);
        }
    }
}
