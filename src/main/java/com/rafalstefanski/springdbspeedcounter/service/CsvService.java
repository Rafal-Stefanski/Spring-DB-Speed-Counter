package com.rafalstefanski.springdbspeedcounter.service;

import com.rafalstefanski.springdbspeedcounter.model.PersonSql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CsvService {
    private static final String MOCK_DATA = "src/main/resources/MOCK_DATA.csv";
    private final List<PersonSql> personSqlList;

    @Autowired
    public CsvService(List<PersonSql> personSqlList) {
        this.personSqlList = new ArrayList<>();
    }

//    public List<PersonSql> readSQL() {
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(MOCK_DATA))) {
//            String nextLine;
//            System.out.println("start reading file");
////            int line = 1;
//            String headerLine = bufferedReader.readLine(); // removes title line from file
//            while ((nextLine = bufferedReader.readLine()) != null) {
//                String[] personRecord = nextLine.split(",");
//                PersonSql personSql = new PersonSql(
//                        personRecord[1],
//                        personRecord[2],
//                        personRecord[3],
//                        personRecord[4],
//                        personRecord[5]);
////                line++;
//                personSqlList.add(personSql);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("File reading finished");
//        return personSqlList;
//    }

}
