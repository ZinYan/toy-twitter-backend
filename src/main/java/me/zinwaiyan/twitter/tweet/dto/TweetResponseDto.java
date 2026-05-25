package me.zinwaiyan.twitter.tweet.dto;

import me.zinwaiyan.twitter.tweet.domain.Tweet;
import me.zinwaiyan.twitter.user.dto.WriterResponseDto;

import java.time.LocalDateTime;

public record TweetResponseDto(
        Long tweetId,
        String content,
        String imageUrl,
        LocalDateTime createdAt,
        Integer commentCount,
        Integer repostCount,
        Integer likeCount,
        Integer viewCount,
        WriterResponseDto writer
) {
    public static TweetResponseDto from(Tweet tweet) {
        return new TweetResponseDto(
                tweet.getTweetId(),
                tweet.getContent(),
                tweet.getImageUrl(),
                tweet.getCreatedAt(),
                tweet.getCommentCount(),
                tweet.getRepostCount(),
                tweet.getLikeCount(),
                tweet.getViewCount(),
                WriterResponseDto.from(tweet.getWriter())
        );
    }
}