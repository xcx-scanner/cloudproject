package com.xcx.springcloud.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: 肖朝翔
 * @Date: 2020/3/7 15:59
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResult<T> {
    private Integer code;
    private String msg;
    private T data;
    public CommonResult(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }

}
