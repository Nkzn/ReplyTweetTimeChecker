package net.nkzn.appengine.app.twrtt.twitter4j;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class Rtt {

	/**
	 * 自分へのリプライに対してリプライを返すまでの時間<br/>
	 * OAuth通さない版
	 * @param screenName Twitter上のユーザー名
	 * @return 累積リプライ時間÷サンプル数
	 */
	public static long getReplyTweetTime(String screenName) throws Exception {
		Twitter twitter = new TwitterFactory().getInstance();
		ResponseList<Status> statusList = null;
		
		try {
			statusList =  twitter.getUserTimeline(screenName, new Paging(1,200));
		} catch (TwitterException e) {
			return 0;
		}
		
		int counter = 0;
		long alltime = 0;

		for(Status statusA : statusList){
			if(statusA.getInReplyToStatusId() != -1){
				Status statusB = null;
				try {
					statusB = twitter.showStatus(statusA.getInReplyToStatusId());
				} catch (TwitterException e) {
					continue;
				}
				
				long a_createdAt = statusA.getCreatedAt().getTime(); // 自分のツイート
				long b_createdAt = statusB.getCreatedAt().getTime(); // リプライ先ツイート
				if(statusB.getText().contains("@"+screenName)){
					++counter;
					alltime += a_createdAt - b_createdAt;
				}
			}
		}
		
		return alltime/counter;
	}
}
