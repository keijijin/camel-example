package com.sample;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

public class TwitterSearchRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("twitter-search:{{twitter.word}}?accessToken={{twitter.accesstoken}}&accessTokenSecret={{twitter.accesstokensecret}}&consumerKey={{twitter.apikey}}&consumerSecret={{twitter.apisecretkey}}&delay={{twitter.interval}}")
            .bean("com.sample.bean.TweetInfoBean", "MakeTweetInfo")
            .marshal().json(JsonLibrary.Jackson, true)
            .log("${body}");
        
    }
    
}
