package ua.kpi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.models.Statistics;

@Service
public class StatisticsService {
    private CompositionService compositionService;
    private ComposerService composerService;
    private AdService adService;

    public StatisticsService(CompositionService compositionService, ComposerService composerService, AdService adService) {
        this.compositionService = compositionService;
        this.composerService = composerService;
        this.adService = adService;
    }

    public Statistics getStatistics() {
        return Statistics.builder()
                .composerCount(this.composerService.getComposersCount())
                .compositionCount(this.compositionService.getCompositionCount())
                .adCount(this.adService.getAdsCount())
                .build();
    }
}
