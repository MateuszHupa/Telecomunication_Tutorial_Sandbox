package Aplikacja_do_treningu_konsultantow.database.dao;

import Aplikacja_do_treningu_konsultantow.database.dbutils.DataBaseManager;
import Aplikacja_do_treningu_konsultantow.database.model.BaseModel;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

public abstract class CommonDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonDao.class);
    protected final ConnectionSource connectionSource;

    public CommonDao() {
        this.connectionSource = DataBaseManager.getConnectionSource();
    }

    public <T extends BaseModel, I> void creatOrUpdate(BaseModel baseModel) {
        Dao<T, I> dao = getDao((Class<T>) baseModel.getClass());
        try {
            dao.createOrUpdate((T) baseModel);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public <T extends BaseModel, I> void refresh(BaseModel baseModel) {
        try {
            Dao<T, I> dao = getDao((Class<T>) baseModel.getClass());
            dao.refresh((T) baseModel);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public  <T extends BaseModel, I> void delete(BaseModel baseModel) {
        try {
            Dao<T, I> dao = getDao((Class<T>) baseModel.getClass());
            dao.delete((T) baseModel);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public  <T extends BaseModel, I> List<T> queryForAll(Class<T> cls) {
        try {
            Dao<T, I> dao = getDao(cls);
            return dao.queryForAll();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    public <T extends BaseModel, I> Dao<T, I> getDao(Class<T> cls) {
        try{
            return DaoManager.createDao(connectionSource, cls);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
        return null;
    }

}
