package me.peterae86.demo.dao.auto;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.peterae86.demo.annotation.AutoDao;
import me.peterae86.demo.model.Foo;

@AutoDao
public interface FooDao {
	Foo select();

	Integer insert(Foo foo);

	List<Foo> selectFoo(@Param("time")int timestamp); 
}
