package com.assignment.irrigation.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.irrigation.model.Slot;
import com.assignment.irrigation.repository.SlotRepository;

@Service
public class SlotServiceImpl implements SlotService {

	@Autowired
	SlotRepository slotRepository;
	
	@Override
	public Slot getSlot(Long slotId) {
		return slotRepository.findBySlotId(slotId);
	}

	@Override
	public Slot saveSlot(Slot slot) {
		return slotRepository.save(slot);
	}

	@Override
	public Slot updateSlot(Slot slot) {
		Slot persistedSlot = slotRepository.findBySlotId(slot.getSlotId());
		if(Objects.nonNull(persistedSlot)) {
			persistedSlot = updatePersistedSlot(persistedSlot, slot);
		}
		return persistedSlot;
	}

	@Override
	public List<Slot> getAllSlots() {
		return slotRepository.findAll();
	}

	@Override
	public void deleteSlot(Long slotId) {
		Slot persistedSlot = slotRepository.findBySlotId(slotId);
		if(Objects.nonNull(persistedSlot)) {
			slotRepository.delete(persistedSlot);
		}
	}
	
	private Slot updatePersistedSlot(Slot persistedSlot, Slot newSlot) {
		if(Objects.nonNull(newSlot.getName())) {
			persistedSlot.setName(newSlot.getName());
		}
		if(Objects.nonNull(newSlot.getStartTime())) {
			persistedSlot.setStartTime(newSlot.getStartTime());
		}
		if(Objects.nonNull(newSlot.getEndTime())) {
			persistedSlot.setEndTime(newSlot.getEndTime());
		}
		if(Objects.nonNull(newSlot.getWaterAmountLtr())) {
			persistedSlot.setWaterAmountLtr(newSlot.getWaterAmountLtr());
		}
		if(Objects.nonNull(newSlot.getIrrigationStatus())) {
			persistedSlot.setIrrigationStatus(newSlot.getIrrigationStatus());
		}
		if(Objects.nonNull(newSlot.getPlotId())) {
			persistedSlot.setPlotId(newSlot.getPlotId());
		}
		return persistedSlot;
	}


}
