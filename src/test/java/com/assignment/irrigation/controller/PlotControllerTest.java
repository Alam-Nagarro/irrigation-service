package com.assignment.irrigation.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

import com.assignment.irrigation.model.Plot;
import com.assignment.irrigation.service.PlotServiceImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = PlotController.class)
public class PlotControllerTest {


	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PlotServiceImpl plotService;
	
	private String expectedResult = "{\"plotId\":2001,\"name\":\"PLOT1\",\"areaSqrmtr\":400,\"cultivationStartDate\":\"2022-09-12T00:00:00\",\"cropId\":1001}";
	
	@Test
	public void getCrop() throws Exception {
		Plot mockPlot = createMockPlot();		
		Mockito.when(plotService.getPlot(Mockito.anyLong())).thenReturn(mockPlot);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/irri/api/v1/plots/2001").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		JSONAssert.assertEquals(expectedResult, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void createPlot() throws Exception{
		Plot mockPlot = createMockPlot();		
		Mockito.when(plotService.savePlot(Mockito.any(Plot.class))).thenReturn(mockPlot);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/irri/api/v1/plots")
				.accept(MediaType.APPLICATION_JSON).content(expectedResult)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		JSONAssert.assertEquals(expectedResult, response.getContentAsString(), false);
	}
	
	@Test
	public void updatePlot() throws Exception{
		Plot mockPlot = createMockPlot();		
		Mockito.when(plotService.updatePlot(Mockito.any(Plot.class))).thenReturn(mockPlot);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(
				"/irri/api/v1/plots")
				.accept(MediaType.APPLICATION_JSON).content(expectedResult)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		JSONAssert.assertEquals(expectedResult, response.getContentAsString(), false);
	}
	
	@Test
	public void getAllPlots() throws Exception {
		List<Plot> plotList =  new ArrayList<>();
		Plot mockPlot = createMockPlot();	
		plotList.add(mockPlot);
		expectedResult = "[{\"plotId\":2001,\"name\":\"PLOT1\",\"areaSqrmtr\":400,\"cultivationStartDate\":\"2022-09-12T00:00:00\",\"cropId\":1001}]";
		
		Mockito.when(plotService.getAllPlots()).thenReturn(plotList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/irri/api/v1/plots").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		JSONAssert.assertEquals(expectedResult, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void deletePlot() throws Exception {
		Mockito.doNothing().when(plotService).deletePlot(Mockito.anyLong());
	}
	
	@Test
	public void CalculateAmountOfWaterForThePlot() throws Exception {
		Integer expectedWaterAmountLtr = 4000;
		Mockito.when(plotService.calculateAmountOfWaterForThePlot(Mockito.anyLong())).thenReturn(expectedWaterAmountLtr);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/irri/api/v1/plots/water-amount-ltr/2001").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result);
		assertEquals(expectedWaterAmountLtr, Integer.parseInt( result.getResponse().getContentAsString()));
	}
	
	private Plot createMockPlot() {
		Plot mockPlot = new Plot();
		mockPlot.setPlotId(2001L);
		mockPlot.setName("PLOT1");
		mockPlot.setAreaSqrmtr(400);
		mockPlot.setCultivationStartDate(LocalDateTime.of(2022, 9, 12, 0, 0));
		mockPlot.setCropId(1001L);
		return mockPlot;
	}
}
