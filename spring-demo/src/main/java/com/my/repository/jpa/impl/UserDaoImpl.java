package com.my.repository.jpa.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.my.entity.User;
import com.my.repository.jpa.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Iterable<User> findAll(Sort sort) {

		return null;
	}

	@Override
	public Page<User> findAll(Pageable pageable) {

		return null;
	}

	@Override
	public <S extends User> S save(S entity) {

		return null;
	}

	@Override
	public <S extends User> Iterable<S> save(Iterable<S> entities) {

		return null;
	}

	@Override
	public User findOne(Long id) {

		return null;
	}

	@Override
	public boolean exists(Long id) {

		return false;
	}

	@Override
	public Iterable<User> findAll() {

		return null;
	}

	@Override
	public Iterable<User> findAll(Iterable<Long> ids) {

		return null;
	}

	@Override
	public long count() {

		return 0;
	}

	@Override
	public void delete(Long id) {

	}

	@Override
	public void delete(User entity) {

	}

	@Override
	public void delete(Iterable<? extends User> entities) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public User findOne(Specification<User> spec) {

		return null;
	}

	@Override
	public List<User> findAll(Specification<User> spec) {

		return null;
	}

	@Override
	public Page<User> findAll(Specification<User> spec, Pageable pageable) {

		return null;
	}

	@Override
	public List<User> findAll(Specification<User> spec, Sort sort) {

		return null;
	}

	@Override
	public long count(Specification<User> spec) {

		return 0;
	}

	@Override
	public User findByName(String name) {

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findByLoginName(String loginName) {
		List<User> result = em
				.createQuery("from User u where u.username=:username")
				.setParameter("username", loginName).getResultList();
		if (result != null && result.size() > 0)
			return result.get(0);
		else
			return null;
	}
}
