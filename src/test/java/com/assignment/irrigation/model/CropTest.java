package com.assignment.irrigation.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CropTest {

		
	@Test
	public void test() throws Exception {
		String expected = "Crop(cropId=1001, name=WHEAT, cultivationPeriodDays=120, irrigationGapDays=30)";
		Crop crop = createCrop();
		Crop crop1 = createCrop();
		assertEquals(expected, crop.toString());
		assertTrue(crop.equals(crop1));
		assertTrue(crop.canEqual(crop1));
		
	}
	
	private Crop createCrop() {
		Crop mockCrop = new Crop();
		mockCrop.setCropId(1001L);
		mockCrop.setName("WHEAT");
		mockCrop.setCultivationPeriodDays(120);
		mockCrop.setIrrigationGapDays(30);
		return mockCrop;
	}
}
