package me.zinwaiyan.twitter.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // Default
    INTERNAL_SERVER_ERROR(500, "서버 내부 오류가 발생했습니다."),
    ERROR(400, "요청 처리에 실패했습니다."),

    // user
    USER_NOT_FOUND(404, "존재하지 않는 사용자입니다."),

    // tweet
    TWEET_NOT_FOUND(404, "존재하지 않는 트윗입니다."),
    INVALID_TWEET_CONTENT(400, "트윗 내용은 비어 있을 수 없습니다."),
    TWEET_CONTENT_TOO_LONG(400, "트윗 내용은 280자를 초과할 수 없습니다."),
    INVALID_IMAGE_TYPE(400, "지원하지 않는 이미지 형식입니다."),
    IMAGE_SIZE_EXCEEDED(400, "이미지 크기는 10MB를 초과할 수 없습니다.");

    private final int status;
    private final String message;
}