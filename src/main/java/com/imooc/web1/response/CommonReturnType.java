package com.imooc.web1.response;

public class CommenReturnType {
    private String status;
    private Object data;

    public static CommenReturnType create(Object result)
    {
        return CommenReturnType.create(result,"success");
    }

    public static CommenReturnType create(Object result,String status)
    {
        CommenReturnType type = new CommenReturnType();
        type.setData(result);
        type.setStatus(status);
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object message) {
        this.data = message;
    }
}
