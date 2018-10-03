package com.brande.Spring.repo;

import com.brande.Spring.domain.TourRating;
import com.brande.Spring.domain.TourRatingPk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface TourRatingRepository  extends CrudRepository<TourRating, TourRatingPk> {

    List<TourRating> findByPkTourId(Integer tourId);

    TourRating findByPkTourIdAndPkCustomerId(Integer tourId, Integer customerId);
}
