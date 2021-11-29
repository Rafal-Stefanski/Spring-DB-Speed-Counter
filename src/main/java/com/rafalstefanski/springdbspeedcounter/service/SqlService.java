package com.rafalstefanski.springdbspeedcounter.service;

import com.rafalstefanski.springdbspeedcounter.aspect.TimeCountAnnotation;
import com.rafalstefanski.springdbspeedcounter.model.PersonNoSql;
import com.rafalstefanski.springdbspeedcounter.model.PersonSql;
import com.rafalstefanski.springdbspeedcounter.repository.PersonNoSqlRepo;
import com.rafalstefanski.springdbspeedcounter.repository.PersonSqlRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SqlService {

    private static final String MOCK_DATA = "src/main/resources/MOCK_DATA.csv";
    private final List<PersonSql> personSqlList;
    private final List<PersonNoSql> personNoSqlList;
    private final PersonSqlRepo personSqlRepo;
    private final PersonNoSqlRepo personNoSqlRepo;
    private final Logger logger = LoggerFactory.getLogger(SqlService.class);

    @Autowired
    public SqlService(PersonSqlRepo personSqlRepo, PersonNoSqlRepo personNoSqlRepo) {
        this.personSqlList = new ArrayList<>();
        this.personNoSqlList = new ArrayList<>();
        this.personSqlRepo = personSqlRepo;
        this.personNoSqlRepo = personNoSqlRepo;
    }

    @TimeCountAnnotation
    public void readCsvForSql() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(MOCK_DATA))) {
            String nextLine;
            logger.info("   Reading CSV file for PersonSql Model");
            String headerLine = bufferedReader.readLine(); // removes title line from file
            while ((nextLine = bufferedReader.readLine()) != null) {
                String[] personRecord = nextLine.split(",");
                PersonSql personSql = new PersonSql(
                        personRecord[1],
                        personRecord[2],
                        personRecord[3],
                        personRecord[4],
                        personRecord[5]);
                personSqlList.add(personSql);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("   File reading finished");
    }

    @TimeCountAnnotation
    public void readCsvForNoSql() {
        logger.info("   Reading CSV file for PersonNoSql Model");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader((MOCK_DATA)))) {
            String nextLine;
            bufferedReader.readLine(); // removes title line from file
            while ((nextLine = bufferedReader.readLine()) != null) {
                String[] personRecord = nextLine.split(",");
                PersonNoSql personNoSql = new PersonNoSql(
                        personRecord[1],
                        personRecord[2],
                        personRecord[3],
                        personRecord[4],
                        personRecord[5]);
                personNoSqlList.add(personNoSql);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("   File reading finished");
    }

    @TimeCountAnnotation
    public void saveToSql() {
        personSqlRepo.saveAll(personSqlList);
        logger.info("   List of PersonSql saved to MySQL DB");
    }

    @TimeCountAnnotation
    public void saveToNoSql() {
        personNoSqlRepo.saveAll(personNoSqlList);
        logger.info("   List of PersonNoSql saved to NoSQL DB");
    }


    public List<PersonSql> getPersonSqlList() {
        return personSqlList;
    }

    public List<PersonNoSql> getPersonNoSqlList() {
        return personNoSqlList;
    }

    @TimeCountAnnotation
    public List<PersonSql> findAllSql() {
        logger.info("   Reading data from MySQL DB with PersonSql");
        return personSqlRepo.findAll();
    }

    @TimeCountAnnotation
    public List<PersonNoSql> findAllNoSql() {
        logger.info("   Reading data from NoSQL DB with PersonNoSql");
        return personNoSqlRepo.findAll();
    }
}
