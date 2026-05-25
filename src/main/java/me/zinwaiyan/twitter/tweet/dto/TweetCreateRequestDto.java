package me.zinwaiyan.twitter.tweet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TweetCreateRequestDto(
        @NotNull(message = "작성자 ID는 필수입니다.")
        Long userId,

        @NotBlank(message = "트윗 내용은 비어 있을 수 없습니다.")
        @Size(max = 280, message = "트윗 내용은 280자를 초과할 수 없습니다.")
        String content
) {
}