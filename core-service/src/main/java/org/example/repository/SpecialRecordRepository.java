package org.example.repository;

import org.example.modal.SpecialRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialRecordRepository extends JpaRepository<SpecialRecord, Long> {
}
