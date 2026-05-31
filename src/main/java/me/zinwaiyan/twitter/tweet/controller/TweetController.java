package me.zinwaiyan.twitter.tweet.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.zinwaiyan.twitter.tweet.dto.request.TweetCreateRequest;
import me.zinwaiyan.twitter.tweet.dto.response.TweetResponse;
import me.zinwaiyan.twitter.tweet.service.TweetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tweets")
@RequiredArgsConstructor
public class TweetController {

    private final TweetService tweetService;

    // 트윗 작성
    @PostMapping
    public ResponseEntity<TweetResponse> createTweet(
            @Valid @ModelAttribute TweetCreateRequest request,
            @RequestPart(required = false) MultipartFile image
    ) {
        TweetResponse response = tweetService.createTweet(request, image);
        return ResponseEntity
                .created(URI.create("/tweets/" + response.getTweetId()))
                .body(response);
    }

    // 전체 트윗 조회
    @GetMapping
    public ResponseEntity<List<TweetResponse>> getAllTweets() {
        return ResponseEntity.ok(tweetService.getAllTweets());
    }

    // 트윗 상세 조회
    @GetMapping("/{tweetId}")
    public ResponseEntity<TweetResponse> getTweet(@PathVariable("tweetId") Long tweetId) {
        return ResponseEntity.ok(tweetService.getTweet(tweetId));
    }

    // 트윗 삭제
    @DeleteMapping("/{tweetId}")
    public ResponseEntity<Void> deleteTweet(@PathVariable("tweetId") Long tweetId) {
        tweetService.deleteTweet(tweetId);
        return ResponseEntity.noContent().build();
    }
}