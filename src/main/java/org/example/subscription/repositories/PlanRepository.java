package org.example.subscription.repositories;

import jakarta.transaction.Transactional;
import org.example.subscription.models.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long>{
    //save plan
    //get me a code to save a plan

    Plan save(Plan plan);
    
    
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM features_plans WHERE plans_id = :planId AND features_id = :featureId", nativeQuery = true)
    void deleteFeatureFromPlan(@Param("planId") Long planId, @Param("featureId") Long featureId);


    @Transactional
    @Modifying
    @Query(value = "DELETE FROM plans WHERE id = :id", nativeQuery = true)
    void deletePlanById(@Param("id")Long id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO features_plans(features_id, plans_id) VALUES (:feature_id, :plan_id)", nativeQuery = true)
    void addFeatureToPlan(Long feature_id, Long plan_id);
}
