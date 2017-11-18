package org.project.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.project.Response;
import org.project.User;
import org.project.service.BaseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author pengpeng
 * @date 2017/11/17 下午3:43
 * @desc
 */
@RestController
@RequestMapping(value = BaseController.url)
public class BaseController {
    public static final String url = "/base";

    @Autowired
    private BaseDataService baseDataService;

    @RequestMapping(value = "queryCity/{pageNum}", method = RequestMethod.GET)
    Response queryCity(@PathVariable("pageNum") int pageNum){
        Response response = new Response();
        response.setData(baseDataService.queryCity(pageNum));
        return response;
    }

    @RequestMapping(value = "getUser", method = RequestMethod.POST)
    Response getUser(@RequestBody User user){
        Response response = new Response();
        response.setData(user);
        return response;
    }
}
