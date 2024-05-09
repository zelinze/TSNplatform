package com.example.tsn.basic;

public class RespEntity<T> {
    private String code;
    private String msg;
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public RespEntity() {
    }

    public RespEntity(T data) {
        this.data = data;
    }

    public static RespEntity success() {
        RespEntity respEntity = new RespEntity<>();
        respEntity.setCode("0");
        respEntity.setMsg("成功");
        return respEntity;
    }

    public static <T> RespEntity<T> success(T data) {
        RespEntity<T> respEntity = new RespEntity<>(data);
        respEntity.setCode("0");
        respEntity.setMsg("成功");
        return respEntity;
    }

    public static <T> RespEntity<T> success(T data,String msg) {
        RespEntity<T> respEntity = new RespEntity<>(data);
        respEntity.setCode("0");
        respEntity.setMsg(msg);
        return respEntity;
    }

    public static RespEntity error(String code, String msg) {
        RespEntity respEntity = new RespEntity();
        respEntity.setCode(code);
        respEntity.setMsg(msg);
        return respEntity;
    }
}
