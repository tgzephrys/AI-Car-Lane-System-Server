package cn.net.luoma.aicarsystemserver.response;

import com.alibaba.fastjson.annotation.JSONField;
import cn.net.luoma.aicarsystemserver.common.ApiCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * REST API 返回结果
 * </p>
 *
 * @author luoma
 * @since 2020-02-04
 */

@ApiModel(value = "BaseResponse", description = "通用REST 返回类")


@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
public class BaseResponse<T> implements Serializable {

    @ApiModelProperty(value = "状态码(详情见API Code)", notes = "200 成功;500 失败", required = true)
    /**
     * 响应码
     */
    private int state;

    @ApiModelProperty(value = "响应消息", required = true)
    /**
     * 响应消息
     */
    private String msg;

    @ApiModelProperty(value = "是否成功", required = true)
    /**
     * 是否成功
     */
    private boolean success;

    @ApiModelProperty(value = "响应数据")
    /**
     * 响应数据
     */
    private T data;

    @ApiModelProperty(value = "响应时间")
    /**
     * 响应时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time = new Date();

    public BaseResponse() {

    }

    public static BaseResponse result(boolean flag) {
        if (flag) {
            return ok();
        }
        return fail();
    }

    public static BaseResponse result(ApiCode apiCode) {
        return result(apiCode, null);
    }

    public static BaseResponse result(ApiCode apiCode, Object data) {
        return result(apiCode, null, data);
    }

    public static BaseResponse result(ApiCode apiCode, String msg, Object data) {
        boolean success = false;
        if (apiCode.getCode() == ApiCode.SUCCESS.getCode()) {
            success = true;
        }
        String message = apiCode.getMsg();
        if (StringUtils.isNotBlank(msg)) {
            message = msg;
        }
        return BaseResponse.builder()
                .state(apiCode.getCode())
                .msg(message)
                .data(data)
                .success(success)
                .time(new Date())
                .build();
    }

    public static BaseResponse ok() {
        return ok(null);
    }

    public static BaseResponse ok(Object data) {
        return result(ApiCode.SUCCESS, data);
    }

    public static BaseResponse ok(Object data, String msg) {
        return result(ApiCode.SUCCESS, msg, data);
    }

    public static BaseResponse okMap(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return ok(map);
    }

    public static BaseResponse fail(ApiCode apiCode) {
    return result(apiCode, null);
}

    public static BaseResponse fail(String msg) {
        return result(ApiCode.FAIL, msg, null);

    }

    public static BaseResponse fail(ApiCode apiCode, Object data) {
        if (ApiCode.SUCCESS == apiCode) {
            throw new RuntimeException("失败结果状态码不能为" + ApiCode.SUCCESS.getCode());
        }
        return result(apiCode, data);

    }

    public static BaseResponse fail(String key, Object value) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, value);
        return result(ApiCode.FAIL, map);
    }

    public static BaseResponse fail() {
        return fail(ApiCode.FAIL);
    }
}