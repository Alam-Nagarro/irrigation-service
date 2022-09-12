package com.assignment.irrigation.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlotTest {
	
	@Test
	public void test() throws Exception {
		String expected = "Plot(plotId=2001, name=PLOT1, areaSqrmtr=400, cultivationStartDate=2022-09-12T00:00, cropId=1001)";
		Plot plot = createPlot();
		Plot plot1 = createPlot();
		assertEquals(expected, plot.toString());
		assertTrue(plot.equals(plot1));
		assertTrue(plot.canEqual(plot1));
	}
	
	private Plot createPlot() {
		Plot plot = new Plot();
		plot.setPlotId(2001L);
		plot.setName("PLOT1");
		plot.setAreaSqrmtr(400);
		plot.setCultivationStartDate(LocalDateTime.of(2022, 9, 12, 0, 0));
		plot.setCropId(1001L);
		return plot;
	}

}
