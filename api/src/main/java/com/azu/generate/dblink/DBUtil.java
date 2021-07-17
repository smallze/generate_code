package com.azu.generate.dblink;

import com.azu.generate.domain.DBConnectExt;
import com.azu.generate.domain.dto.DBConnectDTO;
import org.springframework.beans.BeanUtils;

import java.sql.*;

/**
 * @author zzs
 * @date 2021/7/16 14:41
 */
public class DBUtil {

    private static final String DB_TYPE_MYSQL = "mysql";

    private static final String DB_TYPE_ORACLE = "oracle";

    private static final String DB_TYPE_MS_SQL = "mssql";

    /**
     * 获取数据库驱动
     *
     * @param dto
     * @return
     */
    public static DBConnectExt getDrive(DBConnectDTO dto) throws Exception {
        DBConnectExt dbConnectExt = new DBConnectExt();
        BeanUtils.copyProperties(dto, dbConnectExt);
        switch (dto.getDbType()) {
            case DB_TYPE_MYSQL:
                dbConnectExt.setDriveName("com.mysql.cj.jdbc.Driver");
                String connectUrl = "jdbc:mysql://" + dto.getDbIP() + ":" + dto.getDbPort() + "/" + dto.getDbName();
                dbConnectExt.setConnectUrl(connectUrl);
                break;
            case DB_TYPE_ORACLE:
                dbConnectExt.setDriveName("com.mysql.jdbc.Driver");
                break;
            default:
                throw new Exception("请选择正确的数据库类型");
        }
        return dbConnectExt;
    }
}
