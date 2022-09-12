package com.assignment.irrigation.controller;

import static com.assignment.irrigation.constants.IrrigationConstants.IRRI_API_V1_PREFIX;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.irrigation.model.Slot;
import com.assignment.irrigation.service.SlotService;

@RestController
@RequestMapping(IRRI_API_V1_PREFIX + "/slots")
public class TimeSlotController {

	@Autowired
	SlotService slotService;
	
	@GetMapping("/{slotId}")
	public Slot getSlot(@PathVariable Long slotId) {
		return slotService.getSlot(slotId);
	}
	
	@PostMapping
	public Slot createSlot(@RequestBody Slot slot) {
		return slotService.saveSlot(slot);
	}
	
	@PutMapping
	public Slot updateSlot(@RequestBody Slot slot) {
		return slotService.updateSlot(slot);
	}
	
	@GetMapping
	public List<Slot> getAllSlots(){
		return slotService.getAllSlots();
	}
	
	@DeleteMapping("/{slotId}")
	public void deleteSlot(@PathVariable Long slotId) {
		slotService.deleteSlot(slotId);
	}

}
