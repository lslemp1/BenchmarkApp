package org.ssa.ironyard.services;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mysql.cj.jdbc.MysqlDataSource;

@Configuration
public class DataSourceConfiguration {

    static String URL = "jdbc:mysql://localhost/benchmark?" + "user=root&password=Fireproof!007" + "&useServerPrepStmt=true";
    static final Logger LOGGER = LogManager.getLogger(DataSourceConfiguration.class);

    @Bean(name = "datasource")
    public DataSource datasource() {
	LOGGER.debug("YEAH Annotation based processing is working");
	MysqlDataSource mysqlDataSource = new MysqlDataSource();
	mysqlDataSource.setUrl(URL);
	return mysqlDataSource;
    }

}
