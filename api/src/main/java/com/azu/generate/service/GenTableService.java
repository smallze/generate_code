package com.azu.generate.service;

import com.azu.generate.dblink.DBUtil;
import com.azu.generate.dblink.XmlReader;
import com.azu.generate.domain.DBConnectExt;
import com.azu.generate.domain.TableColumnVO;
import com.azu.generate.domain.TableVO;
import com.azu.generate.domain.dto.DBConnectDTO;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zzs
 * @date 2021/7/17 9:19
 */
@Service
public class GenTableService {


    public List<TableVO> getTableList(DBConnectDTO dto) {
        List<TableVO> tableList = new ArrayList<>();
        try {
            DBConnectExt dbConnectExt = DBUtil.getDrive(dto);
            //加载数据库驱动
            Class.forName(dbConnectExt.getDriveName());
            //连接数据库
            Connection conn = DriverManager.getConnection(dbConnectExt.getConnectUrl(), dto.getUserName(), dto.getPassword());
            System.out.println("连接成功!");
            //创建Statement对象
            Statement stmt = conn.createStatement();
            //建立结果集
            XmlReader xmlReader = new XmlReader();
            ResultSet rs = stmt.executeQuery(xmlReader.getSQLStrByNodeName("getTableList"));
            System.out.println("查询成功!");
            while (rs.next()) {
                TableVO tableVO = new TableVO();
                tableVO.setTableName(rs.getString("table_name"));
                tableVO.setTableComment(rs.getString("table_comment"));
                tableVO.setCreateTime(rs.getString("create_time"));
                tableList.add(tableVO);
            }
            //关闭结果集
            rs.close();
            //关闭Statement对象
            stmt.close();
            //关闭数据库
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tableList;
    }

    public List<TableColumnVO> getTableColumns(DBConnectDTO dto, String tableName) {
        List<TableColumnVO> columnVOS = new ArrayList<>();
        try {
            DBConnectExt dbConnectExt = DBUtil.getDrive(dto);
            //加载数据库驱动
            Class.forName(dbConnectExt.getDriveName());
            //连接数据库
            Connection conn = DriverManager.getConnection(dbConnectExt.getConnectUrl(), dto.getUserName(), dto.getPassword());
            System.out.println("连接成功!");
            //创建Statement对象
            Statement stmt = conn.createStatement();
            //建立结果集
            XmlReader xmlReader = new XmlReader();
            String exeSql = xmlReader.getSQLStrByNodeName("getTableColumnList");
            exeSql = exeSql.replace("tableName", tableName);
            ResultSet rs = stmt.executeQuery(exeSql);
            System.out.println("查询成功!");
            while (rs.next()) {
                TableColumnVO tableColumnVO = new TableColumnVO();
                tableColumnVO.setColumnName(rs.getString("column_name"));
                tableColumnVO.setRequired(rs.getBoolean("is_required"));
                tableColumnVO.setColumnComment(rs.getString("column_comment"));
                tableColumnVO.setSort(rs.getInt("sort"));
                tableColumnVO.setColumnType(rs.getString("column_type"));
                columnVOS.add(tableColumnVO);
            }
            //关闭结果集
            rs.close();
            //关闭Statement对象
            stmt.close();
            //关闭数据库
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return columnVOS;
    }
}
