package me.zinwaiyan.twitter.user.controller;

import lombok.RequiredArgsConstructor;
import me.zinwaiyan.twitter.user.dto.response.UserProfileResponse;
import me.zinwaiyan.twitter.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 프로필 조회
    @GetMapping("/{userId}/profile")
    public ResponseEntity<UserProfileResponse> getUserProfile(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.getUserProfile(userId));
    }
}