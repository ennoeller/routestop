package com.enno.server.stop;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopRepository extends CrudRepository<Stop, Long> {
	
}
