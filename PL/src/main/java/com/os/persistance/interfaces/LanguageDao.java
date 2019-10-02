package com.os.persistance.interfaces;

import com.os.entity.Language;

public interface LanguageDao extends Dao<Language> {
    Language getLanguageByLanguageName(String languageName);
}
