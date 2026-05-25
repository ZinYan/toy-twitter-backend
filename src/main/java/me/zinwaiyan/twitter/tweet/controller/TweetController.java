package me.zinwaiyan.twitter.tweet.controller;

import lombok.RequiredArgsConstructor;
import me.zinwaiyan.twitter.tweet.dto.TweetResponseDto;
import me.zinwaiyan.twitter.tweet.service.TweetService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tweets")
public class TweetController {

    private final TweetService tweetService;

    @GetMapping
    public List<TweetResponseDto> getAllTweets() {
        return tweetService.getAllTweets();
    }

    @GetMapping("/{tweetId}")
    public TweetResponseDto getTweet(@PathVariable Long tweetId) {
        return tweetService.getTweet(tweetId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TweetResponseDto createTweet(
            @RequestParam Long userId,
            @RequestParam String content,
            @RequestPart(required = false) MultipartFile image
    ) {
        return tweetService.createTweet(userId, content, image);
    }

    @DeleteMapping("/{tweetId}")
    public Map<String, String> deleteTweet(@PathVariable Long tweetId) {
        tweetService.deleteTweet(tweetId);
        return Map.of("message", "트윗 삭제 성공");
    }
}