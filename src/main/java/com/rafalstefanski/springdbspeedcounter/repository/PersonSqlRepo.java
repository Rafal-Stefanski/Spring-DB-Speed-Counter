package com.rafalstefanski.springdbspeedcounter.repository;

import com.rafalstefanski.springdbspeedcounter.model.PersonSql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonSqlRepo extends JpaRepository<PersonSql, Long> {
}
