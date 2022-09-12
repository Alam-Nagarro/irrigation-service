package com.assignment.irrigation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.irrigation.model.Slot;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {

	public Slot findBySlotId(Long slotId);
}
