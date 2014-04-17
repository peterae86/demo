package me.peterae86.demo.web.controller;

import java.util.List;

import javax.annotation.Resource;

import me.peterae86.demo.model.Foo;
import me.peterae86.demo.service.FooService;
import me.peterae86.demo.service.impl.FooServiceImpl;
import me.peterae86.demo.web.view.JsonAndView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FooController {

	@Resource
	private FooService fooService;

	@RequestMapping("ajax")
	public ModelAndView test1() {
		return new ModelAndView("nima").addObject("name", fooService.get(0));
	}

	@RequestMapping("postmsg")
	public JsonAndView test2(@RequestParam("name") String name,
			@RequestParam("message") String msg,
			@RequestParam("timestamp") int timestamp) {
		Foo foo=new Foo();
		foo.setUsername(name);
		foo.setMessage(msg);
		fooService.postmsg(foo);
		System.out.println(name + " " + msg);
		List<Foo> list=fooService.getmsg(timestamp);
		if(list.size()>0)
			timestamp= list.get(list.size()-1).getId();
		return new JsonAndView().addData("data", list).addData("time",timestamp);
		
	}

	@RequestMapping("getmsg")
	public JsonAndView test3(@RequestParam("timestamp") int timestamp) {
		
		List<Foo> list=fooService.getmsg(timestamp);
		if(list.size()>0)
			timestamp= list.get(list.size()-1).getId();
		return new JsonAndView().addData("data", list).addData("time",timestamp);
	
	}

}