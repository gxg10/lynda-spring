package com.brande.Spring.repo;

import com.brande.Spring.domain.Tour;
import com.brande.Spring.domain.TourPackage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface TourRepository extends PagingAndSortingRepository<Tour, Integer> {
    Page<Tour> findByTourPackageCode(@Param("code") String code, Pageable pageable);

    @Override
    @RestResource(exported = false)
    <S extends Tour> S save(S s);

    @Override
    @RestResource(exported = false)
    <S extends Tour> Iterable<S> save(Iterable<S> iterable);

    @Override
    @RestResource(exported = false)
    void delete(Integer integer);

    @Override
    @RestResource(exported = false)
    void delete(Tour tour);

    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends Tour> iterable);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
