package com.ragdollcatstudio.pojo;

/**
 * class Result
 * 用于封装网络程序的返回值<p>
 *  Integer code:
 *      状态码，1表示成功返回，0表示失败
 *  String message:
 *      返回消息，成功返回"sussess"，失败返回对应消息
 *  Object data
 *      返回内容，可以是任意类型的对象
 *  <p>
 *  public static Result success()
 *      默认的成功返回，data 为 null
 *  public static Result success(Object data)
 *      成功返回，数据为 Object 对象
 *  public static Result error(String message)
 *      错误返回，message 为对应的错误消息，data 为 null
 */
public class Result {
    private Integer code;
    private String message;
    private Object data;

    public Result() {}

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
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

    public static Result success() {
        return new Result(1, "success", null);
    }

    public static Result success(Object data) {
        return new Result(1, "success", data);
    }

    public static Result error(String message) {
        return new Result(0, message, null);
    }

    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message=" + message +
                ", data=" + data +
                '}';
    }
}
