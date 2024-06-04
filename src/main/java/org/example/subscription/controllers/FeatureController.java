package org.example.subscription.controllers;

import org.example.subscription.models.Feature;
import org.example.subscription.services.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("features")
public class FeatureController {

    private FeatureService featureService;
    @Autowired
    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    //get all features
    @GetMapping
    public List<Feature> getAllFeatures() {
        return featureService.getAllFeatures();
    }
    //get feature by id
    @GetMapping("/{id}")
    public Feature getFeature(@PathVariable Long id) {
        return featureService.getFeatureById(id);
    }

    //save feature
    @PostMapping
    public Feature saveFeature(@RequestBody Feature feature) {
        return featureService.saveFeature(feature);
    }
    //update feature
    @PutMapping("/{id}")
    public Feature updateFeature(@PathVariable Long id, @RequestBody Feature feature) {
        return featureService.updateFeature(id, feature);
    }
}
