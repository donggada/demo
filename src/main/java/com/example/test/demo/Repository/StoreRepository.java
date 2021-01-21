package com.example.test.demo.Repository;

import com.example.test.demo.Entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store,Long> {
    @Modifying
    @Query(value = "UPDATE  store s SET s.holidays = :#{#store.holidays} WHERE s.id = :#{#store.id}",nativeQuery = true)
    int holidayssave(Store store);

    @Query(value = "SELECT * FROM store ORDER BY level ASC",nativeQuery = true)
    List<Store> list();

    @Query(value = "SELECT * FROM store WHERE id= :id",nativeQuery = true)
    Store listdetail(Long id);
}