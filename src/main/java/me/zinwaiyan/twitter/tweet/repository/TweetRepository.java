package me.zinwaiyan.twitter.tweet.repository;

import me.zinwaiyan.twitter.tweet.domain.Tweet;
import me.zinwaiyan.twitter.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findAllByOrderByCreatedAtDesc();

    List<Tweet> findByWriterOrderByCreatedAtDesc(User writer);

    long countByWriter(User writer);
}