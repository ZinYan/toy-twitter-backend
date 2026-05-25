package me.zinwaiyan.twitter.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true, length = 50)
    private String handle;

    @Column(name = "profile_image_url", length = 500)
    private String profileImageUrl;

    @Column(length = 255)
    private String bio;

    @Column(name = "following_count", nullable = false)
    private Integer followingCount = 0;

    @Column(name = "follower_count", nullable = false)
    private Integer followerCount = 0;

    @Column(name = "joined_at", nullable = false)
    private LocalDateTime joinedAt;

    @PrePersist
    public void prePersist() {
        this.joinedAt = LocalDateTime.now();
    }
}