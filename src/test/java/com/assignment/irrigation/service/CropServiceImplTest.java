package com.assignment.irrigation.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.assignment.irrigation.model.Crop;
import com.assignment.irrigation.repository.CropRepository;

@ExtendWith(MockitoExtension.class)
public class CropServiceImplTest {
	
	@Mock
	CropRepository cropRepository;
	
	@InjectMocks
	CropServiceImpl cropService = new CropServiceImpl();
	
	//private String expectedResult = "{\"cropId\":1001,\"name\":\"WHEAT\",\"cultivationPeriodDays\":120,\"irrigationGapDays\":30}";
	
	@Test
	public void getCrop() throws Exception {
		Crop expected = createMockCrop();		
		
		Mockito.when(cropRepository.findByCropId(Mockito.anyLong())).thenReturn(expected);
		Crop actual = cropService.getCrop(1000L);
		
		assertEquals(expected.getCropId(), actual.getCropId());
		assertEquals(expected.getName(), actual.getName());
	}
	
	@Test
	public void saveCrop() throws Exception {
		Crop expected = createMockCrop();		
		
		Mockito.when(cropRepository.save(Mockito.any(Crop.class))).thenReturn(expected);
		Crop actual = cropService.saveCrop(expected);
		
		assertEquals(expected.getCropId(), actual.getCropId());
		assertEquals(expected.getName(), actual.getName());
	}
	
	@Test
	public void updateCrop() throws Exception {
		Crop expected = createMockCrop();		
		
		Mockito.when(cropRepository.findByCropId(Mockito.anyLong())).thenReturn(expected);
		Mockito.when(cropRepository.save(Mockito.any(Crop.class))).thenReturn(expected);
		Crop actual = cropService.updateCrop(expected);
		
		assertEquals(expected.getCropId(), actual.getCropId());
		assertEquals(expected.getName(), actual.getName());
	}
	
	@Test
	public void getAllCrops() throws Exception {
		Crop expected = createMockCrop();
		List<Crop> crops = new ArrayList<>();
		crops.add(expected);
		
		Mockito.when(cropRepository.findAll()).thenReturn(crops);
		
		List<Crop> actual = cropService.getAllCrops();
		
		assertEquals(1, actual.size());
		assertEquals(expected.getCropId(), actual.get(0).getCropId());
	}
	
	@Test
	public void deletCrop() throws Exception{
		Crop expected = createMockCrop();
		Mockito.when(cropRepository.findByCropId(Mockito.anyLong())).thenReturn(expected);
		Mockito.doNothing().when(cropRepository).delete(expected);
		cropService.deleteCrop(1000L);
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
