package com.act3.demoCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.act3.demoCRUD.model.City;

public interface CityRepository extends JpaRepository<City, Integer> {
}