// package com.bsoft.anthony.springbootmaster.config.ds;
//
// import org.apache.ibatis.session.SqlSessionFactory;
// import org.mybatis.spring.SqlSessionFactoryBean;
// import org.mybatis.spring.SqlSessionTemplate;
// import org.mybatis.spring.annotation.MapperScan;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.boot.jdbc.DataSourceBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
// import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
// import javax.sql.DataSource;
//
// @Configuration
// @MapperScan(basePackages = "com.bsoft.anthony.springbootmaster.dao.portal", sqlSessionFactoryRef = "portalSqlSessionFactory")
// public class DataSourcePortalConfig {
//
// 	 // dao xml路径
//     static final String MAPPER_LOCATION_ORACLE = "classpath:mapper/portal/*.xml";
//
// 	@Value("${spring.datasource.portal.dbType}")
//     private String dbType;
//
// 	@Bean(name = "portalDataSource")
// 	@ConfigurationProperties(prefix = "spring.datasource.portal")
//
// 	public DataSource testDataSource() {
// 		return DataSourceBuilder.create().build();
// 	}
//
// 	@Bean(name = "portalSqlSessionFactory")
// 	public SqlSessionFactory testSqlSessionFactory(@Qualifier("portalDataSource") DataSource dataSource)
// 			throws Exception {
// 		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
// 		bean.setDataSource(dataSource);
//
//
// 			bean.setMapperLocations(
// 					new PathMatchingResourcePatternResolver().getResources(DataSourcePortalConfig.MAPPER_LOCATION_ORACLE));
//
// 		return bean.getObject();
// 	}
//
// 	@Bean(name = "portalTransactionManager")
// 	public DataSourceTransactionManager testTransactionManager(@Qualifier("portalDataSource") DataSource dataSource) {
// 		return new DataSourceTransactionManager(dataSource);
// 	}
//
// 	@Bean(name = "portalSqlSessionTemplate")
//
// 	public SqlSessionTemplate testSqlSessionTemplate(
// 			@Qualifier("portalSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
// 		return new SqlSessionTemplate(sqlSessionFactory);
// 	}
//
// }