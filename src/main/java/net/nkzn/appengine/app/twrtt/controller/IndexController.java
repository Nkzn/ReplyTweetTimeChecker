package net.nkzn.appengine.app.twrtt.controller;

import java.util.Date;
import java.util.Map;

import net.nkzn.appengine.app.twrtt.twitter4j.Rtt;

import com.google.appengine.repackaged.com.google.common.collect.Maps;

public class IndexController extends JsonController {
	@Override
	protected Map<String, Object> handle() throws Exception {
		
		long score = Rtt.getReplyTweetTime("Nkzn");
		
		Map<String, Object> map = Maps.newHashMap();
		map.put("message", "Hello, world! - " + (score/60000));
		return map;
	}
}