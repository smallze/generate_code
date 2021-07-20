package com.azu.generate.controller;

import com.azu.generate.domain.Result;
import com.azu.generate.domain.TableColumnVO;
import com.azu.generate.domain.TableVO;
import com.azu.generate.domain.dto.CommonDTO;
import com.azu.generate.domain.dto.DBConnectDTO;
import com.azu.generate.domain.dto.TableColumnDTO;
import com.azu.generate.domain.vo.ConnectDBVO;
import com.azu.generate.service.GenTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/getTables", method = RequestMethod.POST)
    @ResponseBody
    public Result getTables(@RequestBody DBConnectDTO dto) {
        ConnectDBVO connectDBVO = new ConnectDBVO();
        List<TableVO> tables = genTableService.getTableList(dto);
        connectDBVO.setTableList(tables);
        String token = UUID.randomUUID().toString();
        connectDBVO.setToken(token);
        dbLinks.put(token, dto);
        return Result.success(connectDBVO);
    }

    @RequestMapping(value = "/getTableColumns", method = RequestMethod.POST)
    @ResponseBody
    public Result getTableColumns(@RequestBody TableColumnDTO dto) {
        DBConnectDTO connectDTO = (DBConnectDTO) dbLinks.get(dto.getToken());
        List<TableColumnVO> columns = genTableService.getTableColumns(connectDTO, dto.getTableName());
        return Result.success(columns);
    }

}
