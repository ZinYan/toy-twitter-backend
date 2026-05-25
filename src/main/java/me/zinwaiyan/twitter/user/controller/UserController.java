package me.zinwaiyan.twitter.user.controller;

import lombok.RequiredArgsConstructor;
import me.zinwaiyan.twitter.user.dto.UserProfileResponseDto;
import me.zinwaiyan.twitter.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}/profile")
    public UserProfileResponseDto getProfile(@PathVariable Long userId) {
        return userService.getProfile(userId);
    }
}