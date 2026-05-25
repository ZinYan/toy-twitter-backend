package me.zinwaiyan.twitter.user.service;

import lombok.RequiredArgsConstructor;
import me.zinwaiyan.twitter.tweet.domain.Tweet;
import me.zinwaiyan.twitter.tweet.dto.ProfileTweetResponseDto;
import me.zinwaiyan.twitter.tweet.repository.TweetRepository;
import me.zinwaiyan.twitter.user.domain.User;
import me.zinwaiyan.twitter.user.dto.UserProfileResponseDto;
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

    public UserProfileResponseDto getProfile(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        List<Tweet> tweets = tweetRepository.findByWriterOrderByCreatedAtDesc(user);

        List<ProfileTweetResponseDto> tweetDtos = tweets.stream()
                .map(ProfileTweetResponseDto::from)
                .toList();

        Long tweetCount = tweetRepository.countByWriter(user);

        return UserProfileResponseDto.of(user, tweetCount, tweetDtos);
    }
}