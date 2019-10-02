package com.os.persistance.interfaces;


import com.os.entity.BookAttribute;

import java.util.List;

public interface BookAttributeDao extends Dao<BookAttribute>{
    List<BookAttribute> getAttributesByBookId(int id);
}
