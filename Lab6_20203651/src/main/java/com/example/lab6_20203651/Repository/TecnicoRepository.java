package com.example.lab6_20203651.Repository;

import com.example.lab6_20203651.Entity.TechnicianEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<TechnicianEntity, Integer> {
}
