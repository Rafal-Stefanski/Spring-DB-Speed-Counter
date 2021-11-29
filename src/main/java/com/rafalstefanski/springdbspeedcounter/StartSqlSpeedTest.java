package com.rafalstefanski.springdbspeedcounter;

import com.rafalstefanski.springdbspeedcounter.service.SqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartSqlSpeedTest {

    private SqlService sqlService;

    @Autowired
    public StartSqlSpeedTest(SqlService sqlService) {
        this.sqlService = sqlService;
    }

    @EventListener(ApplicationReadyEvent.class)
    private void init() {
        sqlService.readCsvForSql();
        sqlService.saveToSql();

        sqlService.readCsvForNoSql();
        sqlService.saveToNoSql();

        sqlService.findAllSql();
        sqlService.findAllNoSql();
    }
}
