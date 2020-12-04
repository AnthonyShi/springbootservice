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
@MapperScan(basePackages = "com.bsoft.anthony.springbootservice.dao.sys", sqlSessionFactoryRef = "sysSqlSessionFactory")
public class DataSourceSysConfig {
	
	 // dao xml路径
    // static final String MAPPER_LOCATION = "classpath:mapper/his/sqlserver/*.xml";
    // static final String MAPPER_LOCATION_ORACLE = "classpath:mapper/his/oracle/*.xml";
    static final String MAPPER_LOCATION_ORACLE = "classpath:mapper/sys/*.xml";

	@Value("${spring.datasource.his.dbType}")
    private String dbType;
	
	@Bean(name = "sysDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.sys")
	@Primary
	public DataSource testDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "sysSqlSessionFactory")
	@Primary
	public SqlSessionFactory testSqlSessionFactory(@Qualifier("sysDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);

		// if (this.dbType.equals("1")) { // sqlserver
		// 	bean.setMapperLocations(
		// 			new PathMatchingResourcePatternResolver().getResources(DataSourceHisConfig.MAPPER_LOCATION));
		// } else { // oracle
			bean.setMapperLocations(
					new PathMatchingResourcePatternResolver().getResources(DataSourceSysConfig.MAPPER_LOCATION_ORACLE));
		// }
		return bean.getObject();
	}

	@Bean(name = "sysTransactionManager")
	@Primary
	public DataSourceTransactionManager testTransactionManager(@Qualifier("sysDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "sysSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate testSqlSessionTemplate(
			@Qualifier("sysSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}