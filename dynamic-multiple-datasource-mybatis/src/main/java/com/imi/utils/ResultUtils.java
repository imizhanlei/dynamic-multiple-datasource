package com.imi.utils;

import com.imi.entity.Result;

/**
 * Created by mi on 2018/5/24.
 */
public class ResultUtils {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(200);
        result.setData(object);
        result.setMsg("成功");

        return result;
    }

    public static Result success(){
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");

        return result;
    }

    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);

        return result;
    }
}