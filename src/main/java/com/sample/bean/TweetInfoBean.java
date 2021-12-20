package com.sample.bean;

import com.sample.model.TweetInfo;
import java.time.LocalDateTime;
import org.apache.camel.Exchange;
import org.joda.time.DateTime;

import twitter4j.Status;

public class TweetInfoBean {
    
    public void MakeTweetInfo(Exchange exchange) {
        Status bodyIn = (Status) exchange.getIn().getBody();
        TweetInfo tweetInfo = new TweetInfo();
        tweetInfo.setTweetId(bodyIn.getId());
        tweetInfo.setText(bodyIn.getText());

        if (bodyIn.getUser() != null) {
            tweetInfo.setUsername(bodyIn.getUser().getName());
            tweetInfo.setLanguage(bodyIn.getUser().getLang());
            tweetInfo.setLocation(bodyIn.getUser().getLocation());
            tweetInfo.setUserDescription(bodyIn.getUser().getDescription());
        }

        tweetInfo.setFavouriteCount(bodyIn.getFavoriteCount());
        DateTime dateTime = new DateTime(bodyIn.getCreatedAt());
        tweetInfo.setCreationDate(dateTime.toString("yyyy-MM-dd HH:mm:ss"));

        exchange.getIn().setBody(tweetInfo, TweetInfo.class);
    }
}
