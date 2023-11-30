package com.oreilly.Project1.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.*;

public class HelloControllerUnitTest {

	@Test
	public void sayHello() {
		ProjectController pc = new ProjectController();
		Model model = new BindingAwareModelMap();
		String result = pc.sayHello("World", model);
		// assertAll runs all the assertions, if any one fail it doesnot stop there
		assertAll(
				() -> {
					System.out.println("Testing if correct user attribute is passed :------------");
					assertEquals("World", model.getAttribute("user"));
			
		},

				() -> {
					System.out.println("Testing return statement:-----------");
					assertEquals("hello", result);
		});

	}

}
