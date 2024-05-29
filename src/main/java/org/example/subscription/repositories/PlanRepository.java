package org.example.subscription.repositories;

import org.example.subscription.models.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long>{
    //save plan
    //get me a code to save a plan
    Plan save(Plan plan);
}
