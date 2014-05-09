package com.my.test.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

@DirtiesContext
@ContextConfiguration(locations = "applicationContext.xml")
// 如果存在多个transactionManager，可以需显式指定
@TransactionConfiguration(transactionManager = "jpaTransactionManager", defaultRollback = false)
public class JpaTest2 {

	private static Logger logger = LoggerFactory
			.getLogger(JpaTest2.class);

	@PersistenceContext
	private EntityManager em;

	@Test
	public void allClassMapping() throws Exception {
		Metamodel model = em.getEntityManagerFactory().getMetamodel();

		assertThat(model.getEntities()).as("No entity mapping found")
				.isNotEmpty();

		for (@SuppressWarnings("rawtypes") EntityType entityType : model.getEntities()) {
			String entityName = entityType.getName();
			em.createQuery("select o from " + entityName + " o")
					.getResultList();
			logger.info("ok: " + entityName);
		}
	}

}
