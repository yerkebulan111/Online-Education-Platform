package strategy;

import user.IUser;

public class RecommendationContext {
    private RecommendationService recommendationService;

    public RecommendationContext(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    public void setRecommendationService(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    public void executeRecommendation(IUser user) {
        recommendationService.recommendCourses(user);
    }
}

