package org.project.config.interceptor;

import net.sf.json.JSONObject;
import org.project.domain.resp.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author pengpeng
 * @date 2017/11/17 下午3:27
 * @desc
 */
public class MyInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(HandlerInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.info("url:{}",httpServletRequest.getRequestURL().toString());

        return true;
    }


    private void setResponseError(HttpServletResponse response){
        Response resp = new Response();
        resp.setRlt("false");
        resp.setCode("000000");
        resp.setMsg("发送请求结构错误");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.append(JSONObject.fromObject(resp).toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(out != null){
                out.close();
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
