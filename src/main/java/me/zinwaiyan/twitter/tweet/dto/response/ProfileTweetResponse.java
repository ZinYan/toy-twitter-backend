package me.zinwaiyan.twitter.tweet.dto.response;

import lombok.Getter;
import me.zinwaiyan.twitter.tweet.domain.Tweet;

import java.time.LocalDateTime;

@Getter
public class ProfileTweetResponse {

    private final Long tweetId;
    private final String content;
    private final String imageUrl;
    private final LocalDateTime createdAt;
    private final Long commentCount;
    private final Long repostCount;
    private final Long likeCount;
    private final Long viewCount;

    public ProfileTweetResponse(Tweet tweet) {
        this.tweetId = tweet.getTweetId();
        this.content = tweet.getContent();
        this.imageUrl = tweet.getImageUrl();
        this.createdAt = tweet.getCreatedAt();
        this.commentCount = tweet.getCommentCount();
        this.repostCount = tweet.getRepostCount();
        this.likeCount = tweet.getLikeCount();
        this.viewCount = tweet.getViewCount();
    }
}