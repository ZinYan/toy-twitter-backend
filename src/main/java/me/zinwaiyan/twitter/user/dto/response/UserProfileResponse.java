package me.zinwaiyan.twitter.user.dto.response;

import lombok.Getter;
import me.zinwaiyan.twitter.tweet.domain.Tweet;
import me.zinwaiyan.twitter.tweet.dto.response.ProfileTweetResponse;
import me.zinwaiyan.twitter.user.domain.User;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class UserProfileResponse {

    private final Long userId;
    private final String name;
    private final String handle;
    private final String profileImageUrl;
    private final LocalDateTime joinedAt;
    private final String bio;
    private final Long followingCount;
    private final Long followerCount;
    private final Long tweetCount;
    private final List<ProfileTweetResponse> tweets;

    public UserProfileResponse(User user, Long tweetCount, List<Tweet> tweets) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.handle = user.getHandle();
        this.profileImageUrl = user.getProfileImageUrl();
        this.joinedAt = user.getJoinedAt();
        this.bio = user.getBio();
        this.followingCount = user.getFollowingCount();
        this.followerCount = user.getFollowerCount();
        this.tweetCount = tweetCount;
        this.tweets = tweets.stream()
                .map(ProfileTweetResponse::new)
                .toList();
    }
}