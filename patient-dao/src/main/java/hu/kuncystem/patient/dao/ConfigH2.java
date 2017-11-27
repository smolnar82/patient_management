package hu.kuncystem.patient.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * this for comment of classes
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. nov. 10.
 *  
 * @version 1.0
 */
@Configuration
@ComponentScan(basePackages = {"hu.kuncystem.patient.dao"})
public class ConfigH2 {

	@Bean
	public DataSource dataSource(){
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.addScript("schema.sql")
				.addScript("sql_data.sql")
				.build();
	}
	
	@Bean
	public JdbcOperations jdbTemplates(DataSource ds){
		return new JdbcTemplate(ds);
	}
}
