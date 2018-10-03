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

public interface TourRepository extends PagingAndSortingRepository<Tour,Integer> {
    /**
     * Lookup a Page of Tours associated with a TourPackage
     *
     * @param code the tour Package code.
     * @param pageable details for finding the correct page.
     * @return A page of tours if found, empty otherwise.
     */
    Page<Tour> findByTourPackageCode(@Param("code") String code, Pageable pageable);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    <S extends Tour> S save(S s);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    <S extends Tour> Iterable<S> save(Iterable<S> iterable);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(Integer integer);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(Tour tour);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends Tour> iterable);

    //Not exposed by Spring Data REST
    @Override
    @RestResource(exported = false)
    void deleteAll();
}
