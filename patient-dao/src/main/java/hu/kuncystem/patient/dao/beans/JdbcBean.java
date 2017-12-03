package hu.kuncystem.patient.dao.beans;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. dec. 3.
 * 
 * @version 1.0
 */
@Configuration
public class JdbcBean {
    @Bean
    public JdbcOperations jdbTemplates(DataSource ds) {
        return new JdbcTemplate(ds);
    }
}
