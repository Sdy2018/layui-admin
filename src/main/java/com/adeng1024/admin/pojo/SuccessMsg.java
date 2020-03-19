package com.adeng1024.admin.pojo;

public class SuccessMsg extends Msg {
    private Object data;

    public SuccessMsg(Integer code,String msg,Object data) {
        super(code,msg);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SuccessMsg{" +
                "data=" + data +
                '}';
    }
}
