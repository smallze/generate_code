package com.azu.generate.dblink;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author zzs
 * @date 2021/7/17 10:05
 */
public class XmlReader {

    public String getSQLStrByNodeName(String nodeName) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sql/mysql.xml");
        if (null == inputStream) {
            throw new Exception("获取查询sql异常");
        }
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        String xmlStr = new String(bytes, "utf-8");
        Document document = DocumentHelper.parseText(xmlStr);
        Element root = document.getRootElement();
        Element getTableEl = root.element(nodeName);
        return getTableEl.getStringValue();
    }
}
