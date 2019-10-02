package com.os.persistance.interfaces;

import com.os.entity.Reader;

public interface ReaderDao extends Dao<Reader>{
    boolean isExist(Reader reader);
    Reader getReaderByEmailAndPassword(String email, String password);

    boolean isEmailExist(String email);
}
