package com.bsoft.anthony.springbootservice.config.ds;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.bsoft.anthony.springbootservice.dao.his", sqlSessionFactoryRef = "hisSqlSessionFactory")
public class DataSourceHisConfig {
	
	 // dao xml路径
    // static final String MAPPER_LOCATION = "classpath:mapper/his/sqlserver/*.xml";
    // static final String MAPPER_LOCATION_ORACLE = "classpath:mapper/his/oracle/*.xml";
    static final String MAPPER_LOCATION_ORACLE = "classpath:mapper/his/*.xml";

	@Value("${spring.datasource.his.dbType}")
    private String dbType;
	
	@Bean(name = "hisDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.his")
	@Primary
	public DataSource testDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "hisSqlSessionFactory")
	@Primary
	public SqlSessionFactory testSqlSessionFactory(@Qualifier("hisDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);

		// if (this.dbType.equals("1")) { // sqlserver
		// 	bean.setMapperLocations(
		// 			new PathMatchingResourcePatternResolver().getResources(DataSourceHisConfig.MAPPER_LOCATION));
		// } else { // oracle
			bean.setMapperLocations(
					new PathMatchingResourcePatternResolver().getResources(DataSourceHisConfig.MAPPER_LOCATION_ORACLE));
		// }
		return bean.getObject();
	}

	@Bean(name = "hisTransactionManager")
	@Primary
	public DataSourceTransactionManager testTransactionManager(@Qualifier("hisDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "hisSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate testSqlSessionTemplate(
			@Qualifier("hisSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}