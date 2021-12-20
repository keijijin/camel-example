package com.sample.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TweetInfo {
    private Long tweetId;
	private String text;
	private String username;
	private String language;
	private String location;
    private String userDescription;
	private Integer favouriteCount;
	private String creationDate;
}
