package com.example.demo.repository;

import com.example.demo.entity.Cadre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadreRepository extends JpaRepository<Cadre, Long> {
}
