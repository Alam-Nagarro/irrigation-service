package com.assignment.irrigation.controller;

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

import com.assignment.irrigation.model.Crop;
import com.assignment.irrigation.service.CropServiceImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = CropController.class)
public class CropControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CropServiceImpl cropService;
	
	private String expectedResult = "{\"cropId\":1001,\"name\":\"WHEAT\",\"cultivationPeriodDays\":120,\"irrigationGapDays\":30}";
	
	@Test
	public void getCrop() throws Exception {

		Crop mockCrop = createMockCrop();		
		
		Mockito.when(cropService.getCrop(Mockito.anyLong())).thenReturn(mockCrop);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/irri/api/v1/crops/1001").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		JSONAssert.assertEquals(expectedResult, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void createCrop() throws Exception{
		Crop mockCrop = createMockCrop();		
		Mockito.when(cropService.saveCrop(Mockito.any(Crop.class))).thenReturn(mockCrop);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/irri/api/v1/crops")
				.accept(MediaType.APPLICATION_JSON).content(expectedResult)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		JSONAssert.assertEquals(expectedResult, response.getContentAsString(), false);
	}
	
	@Test
	public void updateCrop() throws Exception{
		Crop mockCrop = createMockCrop();		
		Mockito.when(cropService.updateCrop(Mockito.any(Crop.class))).thenReturn(mockCrop);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(
				"/irri/api/v1/crops")
				.accept(MediaType.APPLICATION_JSON).content(expectedResult)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		JSONAssert.assertEquals(expectedResult, response.getContentAsString(), false);
	}
	
	@Test
	public void getAllCrops() throws Exception {
		List<Crop> cropList =  new ArrayList<>();
		Crop mockCrop = createMockCrop();	
		cropList.add(mockCrop);
		expectedResult = "[{\"cropId\":1001,\"name\":\"WHEAT\",\"cultivationPeriodDays\":120,\"irrigationGapDays\":30}]";
		
		Mockito.when(cropService.getAllCrops()).thenReturn(cropList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/irri/api/v1/crops").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		JSONAssert.assertEquals(expectedResult, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void deleteCrop() throws Exception {
		Mockito.doNothing().when(cropService).deleteCrop(Mockito.anyLong());
	}
	private Crop createMockCrop() {
		Crop mockCrop = new Crop();
		mockCrop.setCropId(1001L);
		mockCrop.setName("WHEAT");
		mockCrop.setCultivationPeriodDays(120);
		mockCrop.setIrrigationGapDays(30);
		return mockCrop;
	}
}
