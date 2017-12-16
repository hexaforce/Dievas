package io.hexaforce.dievas.system.session;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@EnableJdbcHttpSession
public class HttpSessionConfig {
	
//	@Bean
//	public DataSource hikariDataSource() {
//		return new EmbeddedDatabaseBuilder()
//				.generateUniqueName(true)
//				.setType(EmbeddedDatabaseType.H2)
//				.setScriptEncoding("UTF-8")
//				.addScript("org/springframework/session/jdbc/schema-h2.sql").build();
//	}
	
	
//	CREATE TABLE SPRING_SESSION (
//			PRIMARY_ID CHAR(36) NOT NULL,
//			SESSION_ID CHAR(36) NOT NULL,
//			CREATION_TIME BIGINT NOT NULL,
//			LAST_ACCESS_TIME BIGINT NOT NULL,
//			MAX_INACTIVE_INTERVAL INT NOT NULL,
//			EXPIRY_TIME BIGINT NOT NULL,
//			PRINCIPAL_NAME VARCHAR(100),
//			CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (PRIMARY_ID)
//		) ENGINE=InnoDB;
//
//		CREATE UNIQUE INDEX SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);
//		CREATE INDEX SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);
//		CREATE INDEX SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);
//
//		CREATE TABLE SPRING_SESSION_ATTRIBUTES (
//			SESSION_PRIMARY_ID CHAR(36) NOT NULL,
//			ATTRIBUTE_NAME VARCHAR(200) NOT NULL,
//			ATTRIBUTE_BYTES BLOB NOT NULL,
//			CONSTRAINT SPRING_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_PRIMARY_ID, ATTRIBUTE_NAME),
//			CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID) REFERENCES SPRING_SESSION(PRIMARY_ID) ON DELETE CASCADE
//		) ENGINE=InnoDB;
//
//		CREATE INDEX SPRING_SESSION_ATTRIBUTES_IX1 ON SPRING_SESSION_ATTRIBUTES (SESSION_PRIMARY_ID);

}
