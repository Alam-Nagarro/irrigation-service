package com.assignment.irrigation.service;

import java.util.List;

import com.assignment.irrigation.model.Crop;

public interface CropService {
	/**
	 * Get crop.
	 * @return
	 */
	public Crop getCrop(Long cropId);
	/**
	 * Save crop.
	 * @param crop
	 * @return
	 */
	public Crop saveCrop(Crop crop);
	/**
	 * Update crop.
	 * @param crop
	 * @return
	 */
	public Crop updateCrop(Crop crop);
	/**
	 * Get all crop list.
	 * @return
	 */
	public List<Crop> getAllCrops();
	/**
	 * Delete crop.
	 * @param cropId
	 */
	public void deleteCrop(Long cropId);
}
