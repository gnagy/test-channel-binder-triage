package com.example.testchannelbindertriage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest
@Import(TestChannelBinderConfiguration.class)
class TestChannelBinderTriageApplicationTests {

	@Autowired
	private CardEventProcessor cardEventProcessor;

	@Test
	void test() throws InterruptedException {
		cardEventProcessor.getReceivedEvents().clear(); // just in case
		CardEvent testEvent = new CardEvent("test");
		cardEventProcessor.process(testEvent);
		cardEventProcessor.process(testEvent);

		Thread.sleep(1000); // poor man's awaitility
		Assertions.assertEquals(Arrays.asList(testEvent, testEvent), cardEventProcessor.getReceivedEvents(), "received events");
	}
}
