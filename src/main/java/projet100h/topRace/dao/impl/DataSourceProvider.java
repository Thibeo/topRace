package projet100h.topRace.dao.impl;


import javax.sql.DataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceProvider {

    private static MysqlDataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new MysqlDataSource();
            dataSource.setServerName("localhost");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("toprace");
            dataSource.setUser("root");
            dataSource.setPassword("PH2Qiy8yLqRc3G3y");
        }
        return dataSource;
    }
}
