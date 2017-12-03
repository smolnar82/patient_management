package hu.kuncystem.patient.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import hu.kuncystem.patient.dao.beans.JdbcBean;

/**
 * This is the test settings of h2 database. This config will create the test
 * data in the database.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 10.
 * 
 * @version 1.0
 */
@Configuration
@ComponentScan(basePackages = { "hu.kuncystem.patient.dao" })
@Import(JdbcBean.class)
public class H2TestConfig {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("schema.sql")
                .addScript("sql_data.sql").build();
    }
}
