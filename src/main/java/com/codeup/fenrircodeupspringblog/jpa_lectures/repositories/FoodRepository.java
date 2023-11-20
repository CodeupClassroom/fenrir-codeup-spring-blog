package com.codeup.fenrircodeupspringblog.jpa_lectures.repositories;

import com.codeup.fenrircodeupspringblog.jpa_lectures.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

    Food findByNameIs(String name); //SELECT * from food where name = ?;

    Food findByCaloriesIsLessThan(int num); //SELECT * from food where calories < ?;



}
