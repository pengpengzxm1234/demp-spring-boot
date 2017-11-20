package org.project.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.project.domain.resp.Response;
import org.project.domain.dto.User;
import org.project.service.BaseDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author pengpeng
 * @date 2017/11/17 下午3:43
 * @desc
 */
@Api(value = "base-rest", description = "基础信息接口")
@RestController
@RequestMapping(value = BaseController.url)
public class BaseController {
    public static final String url = "/base";
    private static final Logger log = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    private BaseDataService baseDataService;

    @RequestMapping(value = "queryCity/{pageNum}", method = RequestMethod.GET)
    @ApiOperation(value = "获取城市列表",httpMethod = "GET", response = Response.class, notes = "获取城市列表")
    Response queryCity(@PathVariable("pageNum") int pageNum){
        Response response = new Response();
        response.setData(baseDataService.queryCity(pageNum));
        log.info("{}", pageNum);
        return response;
    }

    @RequestMapping(value = "getUser", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户",httpMethod = "POST", response = Response.class, notes = "获取城市列表")
    Response getUser(@RequestBody User user){
        Response response = new Response();
        response.setData(user);
        return response;
    }
}
