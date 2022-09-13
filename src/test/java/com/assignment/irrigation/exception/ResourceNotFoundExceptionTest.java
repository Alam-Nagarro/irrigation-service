package com.assignment.irrigation.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ResourceNotFoundExceptionTest {

	@Test
	public void test() throws Exception {
		ResourceNotFoundException ex = new ResourceNotFoundException("message");
		assertEquals("message", ex.getMessage());
	}
}
