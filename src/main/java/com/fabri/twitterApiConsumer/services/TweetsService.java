package com.fabri.twitterApiConsumer.services;

import com.fabri.twitterApiConsumer.responseDTO.TweetsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public final class TweetsService {

    private static final Logger log = LoggerFactory.getLogger(TweetsService.class);
    // Twitter user id of twitter.com/malisssimo. To check your desired twitter user id, use twitter API
    public static final String TWITTER_USER_ID = "1295493138002345985";
    public static int MAX_RESULTS = 100;
    public static String URL = "https://api.twitter.com/2/users/"+ TWITTER_USER_ID +"/tweets?max_results="+MAX_RESULTS;

    private HttpHeaders headers;
    private HttpEntity request;

    public TweetsService() {
        this.headers = new HttpHeaders();
        this.headers.add("Authorization", "Bearer "+System.getenv("TWITTER_BEARER"));
        this.request = new HttpEntity(headers);
    }

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Retrieve one random text-based tweet from the latest "MAX_RESULT" tweets
     * @return String tweet
     */
    public String retrieveRandomTweet() {
        String tweet;
        try {
          tweet = this.retrieveFilteredTweet();
        } catch(HttpClientErrorException e) {
            log.error(e.getMessage());
            tweet = e.getMessage();
        } catch (Exception e) {
            log.error(e.getMessage());
            tweet = e.getMessage();
        }
        return tweet;
    }

    /**
     * Prevents tweets with only an image-link.
     * @return String tweet
     */
    private String retrieveFilteredTweet() {
        String tweetText;
        TweetsResponse response = this.retrieveTweets();
        do {
            Random rnd = new Random();
            tweetText = response.getData().get(rnd.nextInt(response.getMeta().getResult_count()-1)).getText();
        } while(tweetText.matches("[a-zA-Z0-9:\\/ ]*t\\.co[a-zA-Z0-9:\\/ ]*"));
        return tweetText;
    }

    @Cacheable("jokes")
    private TweetsResponse retrieveTweets() {
        return restTemplate.exchange(
                URL,
                HttpMethod.GET,
                this.request,
                TweetsResponse.class)
                .getBody();
    }

}
