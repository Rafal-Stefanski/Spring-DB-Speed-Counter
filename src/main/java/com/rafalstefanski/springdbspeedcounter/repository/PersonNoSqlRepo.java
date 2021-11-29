package com.rafalstefanski.springdbspeedcounter.repository;

import com.rafalstefanski.springdbspeedcounter.model.PersonNoSql;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonNoSqlRepo extends MongoRepository<PersonNoSql, String> {
}
