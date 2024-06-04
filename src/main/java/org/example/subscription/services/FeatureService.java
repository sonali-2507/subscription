package org.example.subscription.services;

import org.example.subscription.models.Feature;
import org.example.subscription.repositories.FeatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureService {
    private FeatureRepository featureRepository;

    public FeatureService(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }


    public List<Feature> getAllFeatures() {
        return featureRepository.findAll();
    }

    public Feature getFeatureById(Long id) {
        return featureRepository.findById(id).orElseThrow(() -> new RuntimeException("Feature not found"));
    }

    public Feature saveFeature(Feature feature) {
        return featureRepository.save(feature);
    }

    public Feature updateFeature(Long id, Feature feature) {
        Feature featureToUpdate = featureRepository.findById(id).orElseThrow(() -> new RuntimeException("Feature not found"));
        featureToUpdate.setName(feature.getName());
        featureToUpdate.setDescription(feature.getDescription());
        return featureRepository.save(featureToUpdate);
    }
}
