package dev.goormthon.jejucart.global.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import dev.goormthon.jejucart.global.status.ErrorStatus;
import dev.goormthon.jejucart.global.status.SuccessStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"code", "result", "message", "data"})
public class BaseResponseDto<T> {

    private final int code;
    private final String result;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T data;

    // 성공한 경우 응답 생성
    public static <T>BaseResponseDto<T> SuccessResponse(SuccessStatus status, T data) {
        return new BaseResponseDto<>(status.getCode(), "SUCCESS", status.getMessage(), data);
    }
    public static BaseResponseDto SuccessResponse(SuccessStatus status) {
        return new BaseResponseDto<>(status.getCode(), "SUCCESS", status.getMessage(), "");
    }

    public static BaseResponseDto ErrorResponse(ErrorStatus status) {
        return new BaseResponseDto<>(status.getCode(), "FAILURE", status.getMessage(), "");
    }
}
