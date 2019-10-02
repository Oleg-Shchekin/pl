package com.os.service.interfaces;

import com.os.entity.Administrator;

public interface AdministratorService extends GrudService<Administrator> {
    Administrator getAdministratorByLoginAndPassword(String login, String password);
    boolean isExist(String login, String password);
}
