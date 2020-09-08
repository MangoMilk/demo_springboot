package com.example.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
public class CustomDataSourceInitializer {

    @Value("classpath:sql/2020_09_07_171105_create_t_room_table.sql")
    private Resource functionScript;

    @Bean
    public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
        final DataSourceInitializer initializer = new DataSourceInitializer();

        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulator());
        return initializer;
    }

    private DatabasePopulator databasePopulator() {
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScripts(functionScript);
//        populator.setSeparator("$$");

//        ClassPathResource recordsSys = new ClassPathResource("sql/2020_09_07_171105_create_t_room_table.sql");
//        populator = new ResourceDatabasePopulator(true, true, "utf-8", recordsSys);
        return populator;
    }
}
