package com.assignment.irrigation.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.assignment.irrigation.model.Slot;
import com.assignment.irrigation.service.SlotServiceImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = TimeSlotController.class)
public class TimeSlotControllerTest {


	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SlotServiceImpl slotService;
	
	private String expectedResult = "{\"slotId\":3001,\"name\":\"SLOT1\",\"startTime\":\"2022-09-12T00:00:00\",\"endTime\":\"2022-09-12T00:00:00\",\"waterAmountLtr\":4000,\"irrigationStatus\":\"CREATED\",\"plotId\":2001}";
	
	@Test
	public void getSlot() throws Exception {

		Slot mockSlot = createMockSlot();		
		
		Mockito.when(slotService.getSlot(Mockito.anyLong())).thenReturn(mockSlot);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/irri/api/v1/slots/3001").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		JSONAssert.assertEquals(expectedResult, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void createSlot() throws Exception{
		Slot mockSlot = createMockSlot();		
		Mockito.when(slotService.saveSlot(Mockito.any(Slot.class))).thenReturn(mockSlot);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/irri/api/v1/slots")
				.accept(MediaType.APPLICATION_JSON).content(expectedResult)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		JSONAssert.assertEquals(expectedResult, response.getContentAsString(), false);
	}
	
	@Test
	public void updateSlot() throws Exception{
		Slot mockSlot = createMockSlot();		
		Mockito.when(slotService.updateSlot(Mockito.any(Slot.class))).thenReturn(mockSlot);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(
				"/irri/api/v1/slots")
				.accept(MediaType.APPLICATION_JSON).content(expectedResult)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		JSONAssert.assertEquals(expectedResult, response.getContentAsString(), false);
	}
	
	@Test
	public void getAllSlots() throws Exception {
		List<Slot> slotList =  new ArrayList<>();
		Slot mockSlot = createMockSlot();	
		slotList.add(mockSlot);
		expectedResult = "[{\"slotId\":3001,\"name\":\"SLOT1\",\"startTime\":\"2022-09-12T00:00:00\",\"endTime\":\"2022-09-12T00:00:00\",\"waterAmountLtr\":4000,\"irrigationStatus\":\"CREATED\",\"plotId\":2001}]";
		
		Mockito.when(slotService.getAllSlots()).thenReturn(slotList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/irri/api/v1/slots").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		JSONAssert.assertEquals(expectedResult, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void deleteSlot() throws Exception {
		Mockito.doNothing().when(slotService).deleteSlot(Mockito.anyLong());
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
