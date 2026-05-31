package me.zinwaiyan.twitter.tweet.dto.response;

import lombok.Getter;
import me.zinwaiyan.twitter.tweet.domain.Tweet;
import me.zinwaiyan.twitter.user.dto.response.WriterResponse;

import java.time.LocalDateTime;

@Getter
public class TweetResponse {

    private final Long tweetId;
    private final String content;
    private final String imageUrl;
    private final LocalDateTime createdAt;
    private final Long commentCount;
    private final Long repostCount;
    private final Long likeCount;
    private final Long viewCount;
    private final WriterResponse writer;

    public TweetResponse(Tweet tweet) {
        this.tweetId = tweet.getTweetId();
        this.content = tweet.getContent();
        this.imageUrl = tweet.getImageUrl();
        this.createdAt = tweet.getCreatedAt();
        this.commentCount = tweet.getCommentCount();
        this.repostCount = tweet.getRepostCount();
        this.likeCount = tweet.getLikeCount();
        this.viewCount = tweet.getViewCount();
        this.writer = new WriterResponse(tweet.getUser());
    }
}