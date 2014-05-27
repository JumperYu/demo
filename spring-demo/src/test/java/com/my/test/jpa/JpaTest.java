package com.my.test.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.my.repository.jpa.UserDao;
import com.my.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("/config/applicationContext**.xml") 
public class JpaTest {

	private static Logger logger = LoggerFactory
			.getLogger(JpaTest.class);

	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private UserDao userDao;
	
	@Resource
	private AccountService accountService;
	
	@Test
	public void allClassMapping() throws Exception {
		Metamodel model = em.getEntityManagerFactory().getMetamodel();

		assertThat(model.getEntities()).as("No entity mapping found")
				.isNotEmpty();

		for (@SuppressWarnings("rawtypes") EntityType entityType : model.getEntities()) {
			String entityName = entityType.getName();
			em.createQuery("select o from " + entityName + " o").getResultList();
			logger.info("ok: " + entityName);
		}
	}
	
	@Test
	public void testDaoFindByLoginName(){
		logger.info(userDao.findByLoginName("admin").toString());
	}
	
	@Test
	public void testAccountService(){
		logger.info("" + accountService.findUserByLoginName("admin"));
	}

}
