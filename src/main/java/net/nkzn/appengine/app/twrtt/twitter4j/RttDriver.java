package net.nkzn.appengine.app.twrtt.twitter4j;

public class RttDriver {

	public static void main(String[] args) {
		try {
			System.out.println(Rtt.getReplyTweetTime("half_island"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
