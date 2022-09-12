package com.assignment.irrigation.service;

import java.util.List;

import com.assignment.irrigation.model.Slot;

public interface SlotService {

	/**
	 * Get slot.
	 * @param slotId
	 * @return
	 */
	public Slot getSlot(Long slotId);
	/**
	 * Save slot.
	 * @param slot
	 * @return
	 */
	public Slot saveSlot(Slot slot);
	/**
	 * Update slot.
	 * @param slot
	 * @return
	 */
	public Slot updateSlot(Slot slot);
	/**
	 * Get all slots.
	 * @return
	 */
	public List<Slot> getAllSlots();
	/**
	 * Delete a slot.
	 * @param slotId
	 */
	public void deleteSlot(Long slotId);
	
}
