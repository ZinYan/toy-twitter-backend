package me.zinwaiyan.twitter.tweet.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.zinwaiyan.twitter.tweet.domain.Tweet;
import me.zinwaiyan.twitter.user.domain.User;

@Getter
@Setter
@NoArgsConstructor
public class TweetCreateRequest {

    @NotNull(message = "작성자 ID는 필수입니다.")
    private Long userId;

    @NotBlank(message = "트윗 내용은 비어 있을 수 없습니다.")
    @Size(max = 280, message = "트윗 내용은 280자를 초과할 수 없습니다.")
    private String content;

    public Tweet toEntity(User user, String imageUrl) {
        return Tweet.builder()
                .user(user)
                .content(content)
                .imageUrl(imageUrl)
                .build();
    }
}