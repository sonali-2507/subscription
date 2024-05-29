package org.example.subscription.controllers;

import org.example.subscription.models.Feature;
import org.example.subscription.models.Plan;
import org.example.subscription.services.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plans")
public class PlanController {
    @Autowired
    private PlanService planService;

//    @GetMapping("/{id}")
//    public FeatureDto getPlan(@PathVariable Long id)  {
//        return planService.getPlanById(id);
//    }

    @GetMapping("/{id}")
    public Plan getPlan(@PathVariable Long id)  {
        return planService.getPlanById(id);
    }

    @PostMapping("/{id}/features")
    public Plan addFeatureToPlan(@PathVariable Long id, @RequestBody Feature feature) {
        return planService.addFeatureToPlan(id, feature);
    }

//    //I want to add new feature into the feature table
//    @PostMapping("/features")
//    public Feature addNewFeature(@RequestBody Feature feature) {
//        return planService.addNewFeature(feature);
//    }
}

