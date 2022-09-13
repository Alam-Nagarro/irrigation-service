package com.assignment.irrigation.controller;

import static com.assignment.irrigation.constants.IrrigationConstants.IRRI_API_V1_PREFIX;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Slot> getSlot(@PathVariable Long slotId) {
		Slot slot = slotService.getSlot(slotId);
		return ResponseEntity.ok(slot);
	}
	
	@PostMapping
	public ResponseEntity<Slot> createSlot(@RequestBody Slot slot) {
		Slot savedSlot = slotService.saveSlot(slot);
		return ResponseEntity.created(null).body(savedSlot);
	}
	
	@PutMapping
	public ResponseEntity<Slot> updateSlot(@RequestBody Slot slot) {
		Slot updatedSlot = slotService.updateSlot(slot);
		return ResponseEntity.ok(updatedSlot);
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
