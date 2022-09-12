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

import com.assignment.irrigation.model.Plot;
import com.assignment.irrigation.repository.PlotRepository;

@ExtendWith(MockitoExtension.class)
public class PlotServiceImplTest {
	@Mock
	PlotRepository plotRepository;
	
	@InjectMocks
	PlotServiceImpl plotService = new PlotServiceImpl();
	
	@Test
	public void getPlot() throws Exception {
		Plot expected = createMockPlot();		
		
		Mockito.when(plotRepository.findByPlotId(Mockito.anyLong())).thenReturn(expected);
		Plot actual = plotService.getPlot(2001L);
		
		assertEquals(expected.getPlotId(), actual.getPlotId());
		assertEquals(expected.getName(), actual.getName());
	}
	
	@Test
	public void savePlot() throws Exception {
		Plot expected = createMockPlot();		
		
		Mockito.when(plotRepository.save(Mockito.any(Plot.class))).thenReturn(expected);
		Plot actual = plotService.savePlot(expected);
		
		assertEquals(expected.getPlotId(), actual.getPlotId());
		assertEquals(expected.getName(), actual.getName());
	}
	
	@Test
	public void updateSlot() throws Exception {
		Plot expected = createMockPlot();		
		
		Mockito.when(plotRepository.findByPlotId(Mockito.anyLong())).thenReturn(expected);
		Mockito.when(plotRepository.save(Mockito.any(Plot.class))).thenReturn(expected);
		Plot actual = plotService.updatePlot(expected);
		
		assertEquals(expected.getPlotId(), actual.getPlotId());
		assertEquals(expected.getName(), actual.getName());
	}
	
	@Test
	public void getAllPlots() throws Exception {
		Plot expected = createMockPlot();
		List<Plot> plots = new ArrayList<>();
		plots.add(expected);
		
		Mockito.when(plotRepository.findAll()).thenReturn(plots);
		
		List<Plot> actual = plotService.getAllPlots();
		
		assertEquals(1, actual.size());
		assertEquals(expected.getPlotId(), actual.get(0).getPlotId());
	}
	
	@Test
	public void deletPlot() throws Exception{
		Plot expected = createMockPlot();
		Mockito.when(plotRepository.findByPlotId(Mockito.anyLong())).thenReturn(expected);
		Mockito.doNothing().when(plotRepository).delete(expected);
		plotService.deletePlot(2001L);
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
