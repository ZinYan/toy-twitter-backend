package me.zinwaiyan.twitter.tweet.dto;

import me.zinwaiyan.twitter.tweet.domain.Tweet;

import java.time.LocalDateTime;

public record ProfileTweetResponseDto(
        Long tweetId,
        String content,
        String imageUrl,
        LocalDateTime createdAt,
        Integer commentCount,
        Integer repostCount,
        Integer likeCount,
        Integer viewCount
) {
    public static ProfileTweetResponseDto from(Tweet tweet) {
        return new ProfileTweetResponseDto(
                tweet.getTweetId(),
                tweet.getContent(),
                tweet.getImageUrl(),
                tweet.getCreatedAt(),
                tweet.getCommentCount(),
                tweet.getRepostCount(),
                tweet.getLikeCount(),
                tweet.getViewCount()
        );
    }
}