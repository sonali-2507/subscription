//package org.example.subscription.ControllerTest;
//
//
//import org.example.subscription.controllers.PlanController;
//import org.example.subscription.models.Plan;
//import org.example.subscription.services.PlanService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//public class PlanControllerTest {
//    //create a PlanController object
//    @Autowired
//    private PlanController planController;
//    @MockBean
//    private PlanService planServiceMock;
//    //give me a code
//    @Test
//    public void testGetPlan() {
//    }
//    @Test
//    public void testGetPlanReturnsEmptyObjectWhenNoPlanIsFound() {
//        when(planServiceMock.getPlanById(any(Long.class)))
//                .thenReturn(null);
//        Plan response = planController.getPlan(1L);
//        Assertions.assertNotNull(response);
//    }
//
//
//
//
//        //test all the methods of the PlanController
//    //test the createPlan method
//
//
//
//
//
//
//    //test the getPlan method
//    //test the addFeatureToPlan method
//    //test the getFeature method
//    //test the deleteFeatureFromPlan method
//    //test the deletePlan method
//
//}
