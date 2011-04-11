package net.nkzn.appengine.app.twrtt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slim3.tester.ControllerTester;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class IndexControllerTest {
	@Test
	public void 正常系() throws NullPointerException, IllegalArgumentException,
		IOException, ServletException {
		tester.start("/");
		assertThat(tester.response.getStatus(), is(equalTo(HttpServletResponse.SC_OK)));
		JSONObject json = JSONObject.fromObject(tester.response.getOutputAsString());
		assertThat(json.getString(JsonController.STATUS), is(equalTo(JsonController.STATUS_OK)));
		assertThat(json.getString("message"), is(containsString("Hello, world!")));
	}

	ControllerTester tester;

	@Before
	public void setUp() throws Exception {
		tester = new ControllerTester(this.getClass());
		tester.setUp();
	}

	@After
	public void tearDown() throws Exception {
		tester.tearDown();
	}
}