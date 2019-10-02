package com.os.entity;

public class Language {
    private int id;
    private String languageName;

    public Language(int id, String languageName) {
        this.id = id;
        this.languageName = languageName;
    }

    public int getId() {
        return id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public static class LanguageBuilder {
        private int id;
        private String languageName;

        public LanguageBuilder(){}

        public LanguageBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public LanguageBuilder setLanguageName(String languageName) {
            this.languageName = languageName;
            return this;
        }

        public Language build(){
            return new Language(this.id, this.languageName);
        }
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", languageName='" + languageName + '\'' +
                '}';
    }
}
