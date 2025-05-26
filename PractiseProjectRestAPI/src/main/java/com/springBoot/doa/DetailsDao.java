package com.springBoot.doa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.entities.Details;

@Repository
public interface DetailsDao extends CrudRepository<Details, Integer> {

}
