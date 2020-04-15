package com.api.tests;

import java.io.IOException;
import java.util.logging.Logger;
import org.testng.annotations.Test;
import com.api.pageobjects.RestAPI_PO;

public class TestCases {

	private static final Logger LOGGER = Logger.getLogger(TestCases.class.getName());
	RestAPI_PO object;

	TestCases() {
		object = new RestAPI_PO();
	}

	@Test(priority = 0, enabled = true)
	public void verifyGetAPI() throws InterruptedException, IOException {
		LOGGER.info("Scenario 1 is running");
		object.testGetapi();

	}

	@Test(priority = 1, enabled = true)
	public void verifyPostAPI() throws InterruptedException, IOException {
		LOGGER.info("Scenario 2 is running");
		object.testPostapi();

	}

}
