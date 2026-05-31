package me.zinwaiyan.twitter.user.dto.response;

import lombok.Getter;
import me.zinwaiyan.twitter.user.domain.User;

@Getter
public class WriterResponse {

    private final Long userId;
    private final String name;
    private final String handle;
    private final String profileImageUrl;

    public WriterResponse(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.handle = user.getHandle();
        this.profileImageUrl = user.getProfileImageUrl();
    }
}