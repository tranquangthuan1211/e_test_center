package com.example.eTestCenter.repository;

import com.example.eTestCenter.entity.TestSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestScheduleRepository extends JpaRepository<TestSchedule, String> {
}
