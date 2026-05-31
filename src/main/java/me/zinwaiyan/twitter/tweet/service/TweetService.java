package me.zinwaiyan.twitter.tweet.service;

import lombok.RequiredArgsConstructor;
import me.zinwaiyan.twitter.global.exception.CustomException;
import me.zinwaiyan.twitter.global.exception.ErrorCode;
import me.zinwaiyan.twitter.tweet.domain.Tweet;
import me.zinwaiyan.twitter.tweet.dto.request.TweetCreateRequest;
import me.zinwaiyan.twitter.tweet.dto.response.TweetResponse;
import me.zinwaiyan.twitter.tweet.repository.TweetRepository;
import me.zinwaiyan.twitter.user.domain.User;
import me.zinwaiyan.twitter.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TweetService {

    private final TweetRepository tweetRepository;
    private final UserService userService;

    @Transactional
    public TweetResponse createTweet(TweetCreateRequest request, MultipartFile image) {
        User user = userService.findByUserId(request.getUserId());

        String imageUrl = getImageUrl(image);

        Tweet tweet = request.toEntity(user, imageUrl);
        tweetRepository.save(tweet);

        return new TweetResponse(tweet);
    }

    @Transactional
    public TweetResponse getTweet(Long tweetId) {
        Tweet tweet = findByTweetId(tweetId);

        tweet.increaseViewCount();

        return new TweetResponse(tweet);
    }

    @Transactional(readOnly = true)
    public List<TweetResponse> getAllTweets() {
        return tweetRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(TweetResponse::new)
                .toList();
    }

    @Transactional
    public void deleteTweet(Long tweetId) {
        Tweet tweet = findByTweetId(tweetId);
        tweetRepository.delete(tweet);
    }

    public Tweet findByTweetId(Long tweetId) {
        return tweetRepository.findById(tweetId)
                .orElseThrow(() -> new CustomException(ErrorCode.TWEET_NOT_FOUND));
    }

    private String getImageUrl(MultipartFile image) {
        if (image == null || image.isEmpty()) {
            return null;
        }

        return "/images/" + image.getOriginalFilename();
    }
}