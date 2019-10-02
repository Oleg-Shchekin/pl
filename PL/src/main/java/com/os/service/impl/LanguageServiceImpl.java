package com.os.service.impl;

import com.os.entity.Language;
import com.os.factory.DaoFactory;
import com.os.persistance.interfaces.LanguageDao;

public class LanguageServiceImpl {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public Language getLanguageByName(String languageName){
        try(LanguageDao languageDao = daoFactory.createLanguageDao()){
            return languageDao.getLanguageByLanguageName(languageName);
        }
    }
}
