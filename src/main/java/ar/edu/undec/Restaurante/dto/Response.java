package ar.edu.undec.Restaurante.dto;

public class Response {

    private Integer code;
    private String message;
    private Object data;

    public Response() {
        this.code = 0;
        this.message = "";
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
