package com.os.service.impl;

import com.os.entity.Administrator;
import com.os.enums.DataBaseSelector;
import com.os.exception.DataBaseConnectionException;
import com.os.exception.DataBaseNotSupportedException;
import com.os.exception.IncorrectPropertyException;
import com.os.factory.DaoFactory;
import com.os.persistance.interfaces.AdministratorDao;
import com.os.persistance.poolConnection.TransactionManager;
import org.apache.log4j.Logger;

public class AdministratorServiceImpl {
    private static final Logger LOGGER = Logger.getLogger(AuthorServiceImpl.class);
    private static final DataBaseSelector source = DataBaseSelector.MS_SQL;
    private static DaoFactory daoFactory;
    private static AdministratorDao administratorDao;

    static {
        try {
            daoFactory = DaoFactory.getDaoFactory(source);
            administratorDao = daoFactory.getAdministratorDao();
        } catch (IncorrectPropertyException | DataBaseConnectionException | DataBaseNotSupportedException ex) {
            LOGGER.error(ex);
        }
    }

    public Administrator getAdministratorByLoginAndPassword(String login, String password){
        TransactionManager.getInstance().beginTransaction();
        Administrator administrator;
        try (AdministratorDao administratorDao = daoFactory.createAdministratorDao()){
            administrator = administratorDao.getByLoginAndPassword(login, password);
        }
        if (administrator != null) {
            TransactionManager.getInstance().commit();
        } else {
            TransactionManager.getInstance().rollback();
        }
        return administrator;
    }

    public boolean isExist(String login, String password){
        boolean exist;
        try(AdministratorDao administratorDao = daoFactory.createAdministratorDao()){
            exist = administratorDao.isExist(login, password);
        }
        return exist;
    }
}
