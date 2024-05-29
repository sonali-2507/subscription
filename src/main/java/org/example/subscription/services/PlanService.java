package org.example.subscription.services;

import org.example.subscription.dtos.FeatureDto;
import org.example.subscription.models.Feature;
import org.example.subscription.models.Plan;
import org.example.subscription.repositories.FeatureRepository;
import org.example.subscription.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PlanService {
    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private FeatureRepository featureRepository;

//    public FeatureDto getPlanById(Long id)  {
//        Optional<Plan> planOptional = planRepository.findById(id);
//
//        if (planOptional.isPresent()) {
////            Plan plan = planOptional.get();
//            Set<Feature> featuress = featureRepository.findAllByPlansId(id);
//            FeatureDto featureDto = new FeatureDto();
//            featureDto.setFeatureSet(featuress);
//            return featureDto;
//        } else {
////            return null;
//            throw new RuntimeException("Plan not found");
//        }
//    }

    public Plan getPlanById(Long id)  {
        Optional<Plan> planOptional = planRepository.findById(id);

        if (planOptional.isPresent()) {
            Plan plan = planOptional.get();

            return plan;
        } else {
//
            throw new RuntimeException("Plan not found");
        }
    }

//    public Feature addNewFeature(Feature feature) {
//        return featureRepository.save(feature);
//    }




//    give me a code to add the feature into plan and return the plan
    public Plan addFeatureToPlan(Long planId, Feature feature) {
        Optional<Plan> planOptional = planRepository.findById(planId);
        if (planOptional.isPresent()) {
            Plan plan = planOptional.get();
            Set<Feature> features = plan.getFeatures();
            if(features.contains(feature)){
                throw new RuntimeException("Feature already exists in the plan");

            }
            else if (featureRepository.existsByName(feature.getName())){
                //feature exists in the feature table in some other plan
                Feature existingFeature = featureRepository.findByName(feature.getName());
                Set<Feature> featureSet = plan.getFeatures();
                featureSet.add(existingFeature);
                plan.setFeatures(featureSet);
               return planRepository.save(plan);
//                return plan;
            }
            else{
                features.add(feature);
                plan.setFeatures(features);
                Set<Plan> planSet = new HashSet<>();
                planSet.add(plan);
                feature.setPlans(planSet);
                featureRepository.save(feature);
                planRepository.save(plan);
                return plan;
            }

        } else {
            throw new RuntimeException("Plan not found");
        }
    }
}

