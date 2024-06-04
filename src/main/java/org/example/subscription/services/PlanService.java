package org.example.subscription.services;
import org.example.subscription.Exceptions.NotFoundException;
import org.example.subscription.models.Feature;
import org.example.subscription.models.Plan;
import org.example.subscription.repositories.FeatureRepository;
import org.example.subscription.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PlanService {

    private PlanRepository planRepository;
    private FeatureRepository featureRepository;
    @Autowired
    public PlanService(PlanRepository planRepository, FeatureRepository featureRepository) {
        this.planRepository = planRepository;
        this.featureRepository = featureRepository;
    }
    public Plan getPlanById(Long id) throws NotFoundException {
        Optional<Plan> planOptional = planRepository.findById(id);

        if (planOptional.isPresent()) {
            Plan plan = planOptional.get();
            return plan;
        }else{
            throw new NotFoundException("Plan not found");
        }
    }
    //     code to add the feature into plan and return the plan
    public Plan addFeatureToPlan(Long planId, Feature feature) throws NotFoundException {
        Optional<Plan> planOptional = planRepository.findById(planId);
        if (planOptional.isPresent()) {
            Plan plan = planOptional.get();
            Set<Feature> features = plan.getFeatures();

            //check if the feature exists in the plan
            if (features.stream().anyMatch(f -> f.getName().equals(feature.getName()))){
                throw new NotFoundException("Feature already exists in the plan");
            }

            else if (featureRepository.existsByName(feature.getName())){
                //feature exists in the feature table in some other plan

                Feature existingFeature = featureRepository.findByName(feature.getName());
                Set<Feature> featureSet = plan.getFeatures();
                featureSet.add(existingFeature);
                plan.setFeatures(featureSet);
                Long existingFeatureId = existingFeature.getId();
             planRepository.addFeatureToPlan(existingFeatureId, planId);
                return planRepository.save(plan);
            }
            else{
                //new feature then add it to the plan
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
            throw new NotFoundException("Plan not found");
        }
    }
//To create a new plan
    public Plan createPlan(Plan plan) {
        return planRepository.save(plan);
    }

    public void deleteFeatureFromPlan(Long planId, Long featureId) throws NotFoundException {
        if(!planRepository.existsById(planId)) {
            throw new NotFoundException("Plan not found");
        } else if (!featureRepository.existsById(featureId)){
            throw new NotFoundException("Feature not found");
        }
       else{
           planRepository.deleteFeatureFromPlan(planId, featureId);
        }
    }
//To delete a plan
    public void deletePlan(Long id) throws NotFoundException {
        if(!planRepository.existsById(id)) {
            throw new NotFoundException("Plan not found");
        }else{
            planRepository.deletePlanById(id);
        }

    }
//To get all plans
    public Iterable<Plan> getAllPlans() {
        return planRepository.findAll();
    }

}

