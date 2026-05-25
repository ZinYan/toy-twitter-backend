package me.zinwaiyan.twitter.tweet.service;

import lombok.RequiredArgsConstructor;
import me.zinwaiyan.twitter.tweet.domain.Tweet;
import me.zinwaiyan.twitter.tweet.dto.TweetResponseDto;
import me.zinwaiyan.twitter.tweet.repository.TweetRepository;
import me.zinwaiyan.twitter.user.domain.User;
import me.zinwaiyan.twitter.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TweetService {

    private final TweetRepository tweetRepository;
    private final UserRepository userRepository;

    public List<TweetResponseDto> getAllTweets() {
        return tweetRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(TweetResponseDto::from)
                .toList();
    }

    public TweetResponseDto getTweet(Long tweetId) {
        Tweet tweet = tweetRepository.findById(tweetId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 트윗입니다."));

        return TweetResponseDto.from(tweet);
    }

    @Transactional
    public TweetResponseDto createTweet(Long userId, String content, MultipartFile image) {
        User writer = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        String imageUrl = null;

        if (image != null && !image.isEmpty()) {
            imageUrl = "/images/" + image.getOriginalFilename();
        }

        Tweet tweet = Tweet.create(writer, content, imageUrl);
        Tweet savedTweet = tweetRepository.save(tweet);

        return TweetResponseDto.from(savedTweet);
    }

    @Transactional
    public void deleteTweet(Long tweetId) {
        Tweet tweet = tweetRepository.findById(tweetId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 트윗입니다."));

        tweetRepository.delete(tweet);
    }
}