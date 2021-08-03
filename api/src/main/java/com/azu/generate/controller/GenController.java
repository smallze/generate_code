package com.azu.generate.controller;

import com.azu.generate.domain.TableColumnVO;
import com.azu.generate.domain.TableVO;
import com.azu.generate.domain.dto.DBConnectDTO;
import com.azu.generate.domain.dto.TableColumnDTO;
import com.azu.generate.domain.vo.ConnectDBVO;
import com.azu.generate.service.GenTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author zzs
 * @date 2021/7/17 9:11
 */
@RestController
@RequestMapping(value = "/gen")
public class GenController {


    @Autowired
    private GenTableService genTableService;

    private final HashMap<String, Object> dbLinks;

    public GenController() {
        this.dbLinks = new HashMap<>();
    }


    /**
     * 获取表结构
     *
     * @param dto
     * @return
     */
    @PostMapping("/getTables")
    public ConnectDBVO getTables(DBConnectDTO dto) throws Exception {
        ConnectDBVO connectDBVO = new ConnectDBVO();
        List<TableVO> tables = genTableService.getTableList(dto);
        connectDBVO.setTableList(tables);
        String token = UUID.randomUUID().toString();
        connectDBVO.setToken(token);
        dbLinks.put(token, dto);
        return connectDBVO;
    }

    @PostMapping("/getTableColumns")
    public List<TableColumnVO> getTableColumns(TableColumnDTO dto) throws Exception {
        DBConnectDTO connectDTO = (DBConnectDTO) dbLinks.get(getToken());
        List<TableColumnVO> columns = genTableService.getTableColumns(connectDTO, dto.getTableName());
        return columns;
    }


    /**
     * 获取token
     *
     * @return
     */
    public static String getToken() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = attributes.getRequest();
        return httpServletRequest.getHeader("accessToken");
    }
}
