package com.azu.generate.domain.vo;

import com.azu.generate.domain.TableVO;

import java.util.List;

/**
 * @author zzs
 * @date 2021/7/20 23:26
 */
public class ConnectDBVO {

    private String token;

    private List<TableVO> tableList;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<TableVO> getTableList() {
        return tableList;
    }

    public void setTableList(List<TableVO> tableList) {
        this.tableList = tableList;
    }
}
