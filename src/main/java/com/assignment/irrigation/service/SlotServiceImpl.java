package com.assignment.irrigation.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.irrigation.constants.IrrigationStatus;
import com.assignment.irrigation.exception.ResourceNotFoundException;
import com.assignment.irrigation.model.Slot;
import com.assignment.irrigation.repository.SlotRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SlotServiceImpl implements SlotService {

	@Autowired
	SlotRepository slotRepository;
	
	@Override
	public Slot getSlot(Long slotId) {
		Slot slot = slotRepository.findBySlotId(slotId);
		if(Objects.isNull(slot)) {
			throw new ResourceNotFoundException("id:" + slotId);
		}
		return slot;
	}

	@Override
	public Slot saveSlot(Slot slot) {
		log.debug("Received slot to save: " + slot);
		slot.setIrrigationStatus(IrrigationStatus.getIrrigationStatus(slot.getIrrigationStatus()));
		return slotRepository.save(slot);
	}

	@Override
	public Slot updateSlot(Slot slot) {
		log.debug("Received slot to update: " + slot);
		Slot persistedSlot = slotRepository.findBySlotId(slot.getSlotId());
		if(Objects.nonNull(persistedSlot)) {
			persistedSlot = updatePersistedSlot(persistedSlot, slot);
		} else {
			throw new ResourceNotFoundException("id:" + slot.getSlotId());
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
		}else {
			log.info("Slot with id {} does not exist.", slotId);
			throw new ResourceNotFoundException("id:" + slotId);
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
			persistedSlot.setIrrigationStatus(IrrigationStatus.getIrrigationStatus(newSlot.getIrrigationStatus()));
		}
		if(Objects.nonNull(newSlot.getPlotId())) {
			persistedSlot.setPlotId(newSlot.getPlotId());
		}
		return persistedSlot;
	}

}
