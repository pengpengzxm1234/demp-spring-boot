package org.project;

/**
 * @author pengpeng
 * @date 2017/11/17 上午11:40
 * @desc
 */
public class Response {
    private String rlt = "true";
    private String code = "100000";
    private String msg = "ok";
    private Object data;

    public String getRlt() {
        return rlt;
    }

    public void setRlt(String rlt) {
        this.rlt = rlt;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
