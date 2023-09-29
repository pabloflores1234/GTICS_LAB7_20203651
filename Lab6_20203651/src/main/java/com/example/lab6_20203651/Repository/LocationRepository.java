package com.example.lab6_20203651.Repository;

import com.example.lab6_20203651.Entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationEntity, Integer> {
}
