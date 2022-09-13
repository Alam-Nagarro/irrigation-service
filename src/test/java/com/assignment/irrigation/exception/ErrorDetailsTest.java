package com.assignment.irrigation.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ErrorDetailsTest {
	
	@Test
	public void test() throws Exception {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.of(2022, 12, 13, 0, 0), "message", "details");
		assertEquals("message", errorDetails.getMessage());
		assertEquals("details", errorDetails.getDetails());
	}

}
