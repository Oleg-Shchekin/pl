package com.os.persistance.interfaces;

import com.os.entity.Administrator;

public interface AdministratorDao extends Dao<Administrator> {
    Administrator getByLoginAndPassword(String login, String password);
    boolean isExist(String login, String password);
}
