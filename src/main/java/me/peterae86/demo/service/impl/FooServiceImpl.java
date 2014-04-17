package me.peterae86.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import me.peterae86.demo.dao.auto.FooDao;
import me.peterae86.demo.model.Foo;
import me.peterae86.demo.service.FooService;

import org.springframework.stereotype.Service;

@Service
public class FooServiceImpl implements FooService {
	@Resource
	private FooDao fooDao;
	
	public String get(Integer id) {
		return fooDao.select().getUsername();
	}

	public void postmsg(Foo foo) {
		// TODO Auto-generated method stub
		fooDao.insert(foo);
		return;
	}

	public List<Foo> getmsg(int timestamp) {
		// TODO Auto-generated method stub
		return fooDao.selectFoo(timestamp);
	}
}
