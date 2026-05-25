package me.zinwaiyan.twitter.user.dto;

import me.zinwaiyan.twitter.tweet.dto.ProfileTweetResponseDto;
import me.zinwaiyan.twitter.user.domain.User;

import java.time.LocalDateTime;
import java.util.List;

public record UserProfileResponseDto(
        Long userId,
        String name,
        String handle,
        String profileImageUrl,
        LocalDateTime joinedAt,
        String bio,
        Integer followingCount,
        Integer followerCount,
        Long tweetCount,
        List<ProfileTweetResponseDto> tweets
) {
    public static UserProfileResponseDto of(
            User user,
            Long tweetCount,
            List<ProfileTweetResponseDto> tweets
    ) {
        return new UserProfileResponseDto(
                user.getUserId(),
                user.getName(),
                user.getHandle(),
                user.getProfileImageUrl(),
                user.getJoinedAt(),
                user.getBio(),
                user.getFollowingCount(),
                user.getFollowerCount(),
                tweetCount,
                tweets
        );
    }
}