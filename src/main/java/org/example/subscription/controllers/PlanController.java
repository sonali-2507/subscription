package org.example.subscription.controllers;

import org.example.subscription.Exceptions.NotFoundException;
import org.example.subscription.models.Feature;
import org.example.subscription.models.Plan;
import org.example.subscription.services.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plans")
public class PlanController {

    private PlanService planService;
    @Autowired
    public PlanController(PlanService planService) {
        this.planService = planService;
    }
    //get all plans
    @GetMapping
    public Iterable<Plan> getAllPlans() {
        return planService.getAllPlans();
    }
//get plan by id
    @GetMapping("/{id}")
    public Plan getPlanById(@PathVariable Long id) throws NotFoundException {
        return planService.getPlanById(id);
    }
//add feature to plan
    @PutMapping("/{id}/features")
    public Plan addFeatureToPlan(@PathVariable Long id, @RequestBody Feature feature) throws NotFoundException {
       return planService.addFeatureToPlan(id, feature);
    }

    //delete feture from plan
    @DeleteMapping("/{planId}/features/{featureId}")
    public void deleteFeatureFromPlan(@PathVariable Long planId, @PathVariable Long featureId) throws NotFoundException {
         planService.deleteFeatureFromPlan(planId, featureId);
    }

    //delete plan
    @DeleteMapping("/{id}")
    public void deletePlan(@PathVariable Long id) throws NotFoundException {
        planService.deletePlan(id);
    }
    @PostMapping
    public Plan createPlan(@RequestBody Plan plan) {
        return planService.createPlan(plan);
    }

}

