package com.brande.Spring.services;

import com.brande.Spring.domain.Difficulty;
import com.brande.Spring.domain.Region;
import com.brande.Spring.domain.Tour;
import com.brande.Spring.domain.TourPackage;
import com.brande.Spring.repo.TourPackageRepository;
import com.brande.Spring.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {
    private TourPackageRepository tourPackageRepository;
    private TourRepository tourRepository;

    @Autowired
    public TourService(TourPackageRepository tourPackageRepository, TourRepository tourRepository) {
        this.tourPackageRepository = tourPackageRepository;
        this.tourRepository = tourRepository;
    }

    public Tour createTour(String title, String description, String blurb, Integer price,
                           String duration, String bullets, String keywords, String tourPackageName,
                           Difficulty difficulty, Region region) {

        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName);
        if (tourPackage == null) {
                throw new RuntimeException(("Tour package nto ex"+tourPackageName));
            }
        return tourRepository.save(new Tour(title, description, blurb, price, duration,
                bullets, keywords, tourPackage, difficulty, region));

    }

    public Iterable<Tour> lookup() {
        return tourRepository.findAll();
    }

    public long total() {
        return tourRepository.count();
    }


}