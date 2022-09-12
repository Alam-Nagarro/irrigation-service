package com.assignment.irrigation.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.assignment.irrigation.model.Slot;
import com.assignment.irrigation.repository.SlotRepository;

@ExtendWith(MockitoExtension.class)
public class SlotServiceImplTest {
	@Mock
	SlotRepository slotRepository;
	
	@InjectMocks
	SlotServiceImpl slotService = new SlotServiceImpl();
	
	@Test
	public void getSlot() throws Exception {
		Slot expected = createMockSlot();		
		
		Mockito.when(slotRepository.findBySlotId(Mockito.anyLong())).thenReturn(expected);
		Slot actual = slotService.getSlot(3001L);
		
		assertEquals(expected.getSlotId(), actual.getSlotId());
		assertEquals(expected.getName(), actual.getName());
	}
	
	@Test
	public void saveSlot() throws Exception {
		Slot expected = createMockSlot();		
		
		Mockito.when(slotRepository.save(Mockito.any(Slot.class))).thenReturn(expected);
		Slot actual = slotService.saveSlot(expected);
		
		assertEquals(expected.getSlotId(), actual.getSlotId());
		assertEquals(expected.getName(), actual.getName());
	}
	
	@Test
	public void updateSot() throws Exception {
		Slot expected = createMockSlot();		
		
		Mockito.when(slotRepository.findBySlotId(Mockito.anyLong())).thenReturn(expected);
		Slot actual = slotService.updateSlot(expected);
		
		assertEquals(expected.getSlotId(), actual.getSlotId());
		assertEquals(expected.getName(), actual.getName());
	}
	
	@Test
	public void getAllSlots() throws Exception {
		Slot expected = createMockSlot();
		List<Slot> slots = new ArrayList<>();
		slots.add(expected);
		
		Mockito.when(slotRepository.findAll()).thenReturn(slots);
		
		List<Slot> actual = slotService.getAllSlots();
		
		assertEquals(1, actual.size());
		assertEquals(expected.getSlotId(), actual.get(0).getSlotId());
	}
	
	@Test
	public void deletSlot() throws Exception{
		Slot expected = createMockSlot();
		Mockito.when(slotRepository.findBySlotId(Mockito.anyLong())).thenReturn(expected);
		Mockito.doNothing().when(slotRepository).delete(expected);
		slotService.deleteSlot(3001L);
	}
	
	private Slot createMockSlot() {
		Slot mockSlot = new Slot();
		mockSlot.setSlotId(3001L);
		mockSlot.setName("SLOT1");
		mockSlot.setStartTime(LocalDateTime.of(2022, 9, 12, 0, 0));
		mockSlot.setEndTime(LocalDateTime.of(2022, 9, 12, 0, 0));
		mockSlot.setWaterAmountLtr(4000);
		mockSlot.setIrrigationStatus("CREATED");
		mockSlot.setPlotId(2001L);
		return mockSlot;
	}
}
