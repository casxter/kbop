package com.kbop.bean;

/**
 * json 返回bean
 *
 * @author WallaceTang
 */
public class JsonMsg<E> {
    //    返回码
    private Integer code;
    //    消息
    private String msg;
    //    数据
    private E data;

    public JsonMsg() {
    }

    public JsonMsg(Integer code, String msg, E data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public E getData() {
        return data;
    }

    @SuppressWarnings(value = "unchecked")
    public void setData(E data) {
        this.data = data;
    }
}
