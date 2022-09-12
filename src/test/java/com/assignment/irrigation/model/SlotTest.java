package com.assignment.irrigation.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SlotTest {
	
	@Test
	public void test() throws Exception {
		String expected = "Slot(slotId=3001, name=SLOT1, startTime=2022-09-12T00:00, endTime=2022-09-12T00:00, waterAmountLtr=4000, irrigationStatus=CREATED, plotId=2001)";
		Slot slot = createSlot();
		Slot slot1 = createSlot();
		assertEquals(expected, slot.toString());
		assertTrue(slot.equals(slot1));
		assertTrue(slot.canEqual(slot1));
	}
	
	private Slot createSlot() {
		Slot slot = new Slot();
		slot.setSlotId(3001L);
		slot.setName("SLOT1");
		slot.setStartTime(LocalDateTime.of(2022, 9, 12, 0, 0));
		slot.setEndTime(LocalDateTime.of(2022, 9, 12, 0, 0));
		slot.setWaterAmountLtr(4000);
		slot.setIrrigationStatus("CREATED");
		slot.setPlotId(2001L);
		return slot;
	}

}
