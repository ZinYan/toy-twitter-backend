package me.zinwaiyan.twitter.user.service;

import lombok.RequiredArgsConstructor;
import me.zinwaiyan.twitter.global.exception.CustomException;
import me.zinwaiyan.twitter.global.exception.ErrorCode;
import me.zinwaiyan.twitter.tweet.domain.Tweet;
import me.zinwaiyan.twitter.tweet.repository.TweetRepository;
import me.zinwaiyan.twitter.user.domain.User;
import me.zinwaiyan.twitter.user.dto.response.UserProfileResponse;
import me.zinwaiyan.twitter.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;

    public UserProfileResponse getUserProfile(Long userId) {
        User user = findByUserId(userId);

        List<Tweet> tweets = tweetRepository.findAllByUserOrderByCreatedAtDesc(user);
        Long tweetCount = tweetRepository.countByUser(user);

        return new UserProfileResponse(user, tweetCount, tweets);
    }

    public User findByUserId(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
    }
}