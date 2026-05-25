package me.zinwaiyan.twitter.user.dto;

import me.zinwaiyan.twitter.user.domain.User;

public record WriterResponseDto(
        Long userId,
        String name,
        String handle,
        String profileImageUrl
) {
    public static WriterResponseDto from(User user) {
        return new WriterResponseDto(
                user.getUserId(),
                user.getName(),
                user.getHandle(),
                user.getProfileImageUrl()
        );
    }
}