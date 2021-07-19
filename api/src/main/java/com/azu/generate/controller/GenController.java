package com.azu.generate.controller;

import com.azu.generate.dblink.DBUtil;
import com.azu.generate.domain.TableVO;
import com.azu.generate.domain.dto.DBConnectDTO;
import com.azu.generate.service.GenTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zzs
 * @date 2021/7/17 9:11
 */
@RestController
@RequestMapping(value = "/gen")
public class GenController {


    @Autowired
    private GenTableService genTableService;



    /**
     * 获取表结构
     *
     * @param dto
     * @return
     */
    @RequestMapping(value = "/getTables", method = RequestMethod.POST)
    @ResponseBody
    public List<TableVO> getTables(@RequestBody DBConnectDTO dto) {
        List<TableVO> tables = genTableService.getTableList(dto);
        return tables;
    }
}
