package com.member.tracking.model.common;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class ApiResponse<T> {
    @Builder.Default
    private int resultCode = 0;

    @Builder.Default
    private String message = "SUCCESS";

    private T data;

    public static <T> ApiResponse<T> ok(T data) {
        return ApiResponse.<T>builder()
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> fail(int resultCode, String message, T data) {
        return ApiResponse.<T>builder()
                .resultCode(resultCode)
                .message(message)
                .data(data)
                .build();
    }

    /*
        ApiResponse<T>

        private T data;
        private String code;
        private String message;

        public static <T> ApiResponse<T> ok(T data) {
            return new ApiResponse<T>(data, "OK", null);
        }

        public static <T> ApiResponse<T> fail(T data, ErrorCode code) {
            return new ApiResponse<T>(data, code.getCode(), code.getMessage());
        }

        public static <T> ApiResponse<T> fail(T data, ErrorCode code, String message) {
            return new ApiResponse<T>(data, code.getCode(), message);
        }
     */
}
