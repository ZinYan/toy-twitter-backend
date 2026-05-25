package me.zinwaiyan.twitter.tweet.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.zinwaiyan.twitter.user.domain.User;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "tweet")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tweet_id")
    private Long tweetId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User writer;

    @Column(nullable = false, length = 280)
    private String content;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    @Column(name = "comment_count", nullable = false)
    private Integer commentCount = 0;

    @Column(name = "repost_count", nullable = false)
    private Integer repostCount = 0;

    @Column(name = "like_count", nullable = false)
    private Integer likeCount = 0;

    @Column(name = "view_count", nullable = false)
    private Integer viewCount = 0;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}