package com.idiot.exam.util;
import com.idiot.exam.common.Result;

public class ApiResult {

    public static Result succ(Object data)
    {
        return succ(200,"操作成功",data);
    }
    public static Result succ(int code, String mess, Object data)
    {
        Result apiResult=new Result();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg("mess");
        return apiResult;
    }
    public static Result fail(String mess)
    {
        return fail(400,mess,null);
    }
    public static Result fail(String mess, Object data)
    {
        return fail(400,mess,data);
    }
    public static Result fail(int code, String mess, Object data)
    {
        Result apiResult=new Result();
        apiResult.setCode(code);
        apiResult.setData(null);
        apiResult.setMsg(mess);
        return apiResult;
    }
}
