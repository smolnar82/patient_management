package hu.kuncystem.patient.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * This is the settings of h2 database.
 *
 * @author Csaba Kun <kuncy88@gmail.com>
 * @date 2017. dec. 1.
 * 
 * @version 1.0
 */
@Configuration
@ComponentScan(basePackages = { "hu.kuncystem.patient.dao" })
@EnableTransactionManagement
public class H2Config {

    @Bean
    @Profile("liveOnDisk")
    public DataSource dataSourceLiveOnDisk() throws ScriptException,SQLException {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:~/patient_managament");
        ds.setUser("admin");
        ds.setPassword("12345678");

        ResourceLoader rsLoader = new DefaultResourceLoader();
        EncodedResource encodedScript = new EncodedResource(rsLoader.getResource("schema.sql"));
        ScriptUtils.executeSqlScript(ds.getConnection(), encodedScript, false, false,
                ScriptUtils.DEFAULT_COMMENT_PREFIX, ScriptUtils.DEFAULT_STATEMENT_SEPARATOR,
                ScriptUtils.DEFAULT_BLOCK_COMMENT_START_DELIMITER, ScriptUtils.DEFAULT_BLOCK_COMMENT_END_DELIMITER);
  

        System.out.println("datasource from disk: " + ds.getURL() + " - " + ds.getUrl());
        return ds;
    }

    @Bean
    @Profile("live")
    public DataSource dataSourceLive() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("schema.sql").build();
    }

    @Bean
    @Profile("test")
    public DataSource dataSourceTest() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("schema.sql")
                .addScript("sql_data.sql").build();
    }

    @Bean
    public JdbcOperations jdbcTemplatesTest(DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean(name = "txManager")
    public PlatformTransactionManager transactionManager(DataSource ds) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(ds);
        return transactionManager;
    }
}
