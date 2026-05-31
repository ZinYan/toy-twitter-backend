package me.zinwaiyan.twitter.tweet.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.zinwaiyan.twitter.global.domain.BaseEntity;
import me.zinwaiyan.twitter.user.domain.User;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tweet extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tweetId;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(nullable = false, length = 280)
    private String content;

    private String imageUrl;

    @Column(nullable = false)
    private Long commentCount;

    @Column(nullable = false)
    private Long repostCount;

    @Column(nullable = false)
    private Long likeCount;

    @Column(nullable = false)
    private Long viewCount;

    @Builder
    public Tweet(User user, String content, String imageUrl) {
        this.user = user;
        this.content = content;
        this.imageUrl = imageUrl;
        this.commentCount = 0L;
        this.repostCount = 0L;
        this.likeCount = 0L;
        this.viewCount = 0L;
    }
    public void increaseViewCount() {
        this.viewCount += 1;
    }
}