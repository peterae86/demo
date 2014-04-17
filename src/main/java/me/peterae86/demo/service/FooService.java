package me.peterae86.demo.service;

import java.util.List;

import me.peterae86.demo.model.Foo;

public interface FooService {
	String get(Integer id);
	void postmsg(Foo foo); 
	List<Foo> getmsg(int timestamp);
}
