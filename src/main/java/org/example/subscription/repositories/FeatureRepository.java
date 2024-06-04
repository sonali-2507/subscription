package org.example.subscription.repositories;

import org.example.subscription.models.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
    boolean existsByName(String name);
    Feature findByName(String name);

}
