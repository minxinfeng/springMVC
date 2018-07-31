package com.bcps.controller.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcps.model.request.TestEntityRequest;
import com.bcps.model.response.TestEntityResponse;
import com.bcps.service.TestService;
import com.google.gson.stream.JsonWriter;

@Controller
@Lazy
public class HelloWorldController {
	@Autowired
	private TestService testService;
	
	@RequestMapping("/hello")
    public String hello(@RequestParam(value="name", required=false, defaultValue="hello") String name, Model model) {
        model.addAttribute("name", name);
        return "index.jsp";
    }

	@RequestMapping(value = "/helloagain", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model) {
		model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
		return "welcome.jsp";
	}
	
	@RequestMapping(value = "/postdemo", method = RequestMethod.POST)
	public @ResponseBody TestEntityRequest postDemo(@RequestBody Map<Object, Object> body) {
		String desc = "";
		for (Map.Entry<Object, Object> entry : body.entrySet()) {
			 //Map.entry<Integer,String> 映射项（键-值对）  有几个方法：用上面的名字entry
			//entry.getKey() ;entry.getValue(); entry.setValue();
			//map.entrySet()  返回此映射中包含的映射关系的 Set视图。
			desc = desc + "key= " + entry.getKey() + " and value= "
			+ entry.getValue() + "|||||||||||";
		}
		
		TestEntityRequest testEntity = new TestEntityRequest();
		testEntity.setTestId("1123");
		testEntity.setTestName("test");
		testEntity.setTestDesc(desc);
		return testEntity;
	}
	
	@RequestMapping(value = "/postdemoentity", method = RequestMethod.POST)
	public @ResponseBody TestEntityResponse postDemoEntity(@RequestBody TestEntityRequest testEntity) {
		return testService.getTestEntity(testEntity);
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index.jsp";
	}

	public TestService getTestService() {
		return testService;
	}
}
