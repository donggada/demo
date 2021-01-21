package com.example.test.demo.Repository;

import com.example.test.demo.Entity.BusinessTimes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessTimesReposity extends JpaRepository<BusinessTimes,Long> {
}
