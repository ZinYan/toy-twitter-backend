package me.zinwaiyan.twitter.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true, length = 50)
    private String handle;

    @Column(length = 500)
    private String profileImageUrl;

    @Column(length = 255)
    private String bio;

    @Column(nullable = false)
    private Long followingCount;

    @Column(nullable = false)
    private Long followerCount;

    @Column(nullable = false)
    private LocalDateTime joinedAt;

    @Builder
    public User(String name, String handle, String profileImageUrl, String bio) {
        this.name = name;
        this.handle = handle;
        this.profileImageUrl = profileImageUrl;
        this.bio = bio;
        this.followingCount = 0L;
        this.followerCount = 0L;
        this.joinedAt = LocalDateTime.now();
    }
}