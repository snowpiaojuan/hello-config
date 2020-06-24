package com.example.base_common.controller;

import com.example.base_common.common.rest.ReturnData;
import com.example.base_common.entity.DictCity;
import com.example.base_common.entity.DictProvince;
import com.example.base_common.service.DictCityService;
import com.example.base_common.service.DictProvinceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author vicky
 * @date 2019/5/27
 */
@Api(value = "地域管理API")
@RestController
@RequestMapping("/api")
public class ProvinceController {

    @Autowired
    private DictProvinceService dictProvinceService;

    @Autowired
    private DictCityService dictCityService;

    @ApiOperation(value = "查询所有省份信息")
    @GetMapping("/province/list")
    public ReturnData findAll(){
        List<DictProvince> list = dictProvinceService.selectAllProvince();
        return new ReturnData(list);
    }

    @ApiOperation(value = "根据省份ID查询城市信息")
    @GetMapping("/city/listByProvinceId")
    public ReturnData findCityByProvinceId(Integer provinceId){
        List<DictCity> list = dictCityService.selectByProvinceId(provinceId);
        return new ReturnData(list);
    }
}
