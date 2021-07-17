package com.azu.generate.domain;


/**
 * @author zzs
 * @date 2021/7/17 9:53
 */
public class DBConnectExt{

    private String driveName;

    private String connectUrl;

    public String getDriveName() {
        return driveName;
    }

    public void setDriveName(String driveName) {
        this.driveName = driveName;
    }

    public String getConnectUrl() {
        return connectUrl;
    }

    public void setConnectUrl(String connectUrl) {
        this.connectUrl = connectUrl;
    }
}
