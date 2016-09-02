package com.example.cxfrj.test;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class BaseTest {

	protected ApplicationContext applicationContext;

	@Before
	public void setUp() {
		
	}

	@After
	public void destroy() {

	}

	protected void loadContexts(String...contexts) {
		applicationContext = new ClassPathXmlApplicationContext(buildPaths(contexts));

	}

	protected static String[] buildPaths(String...contexts) {
		String path = "classpath:META-INF/spring/";
		String suffix = ".xml";
		String[] contextPaths = new String[contexts.length + 1];
		contextPaths[0] = path + "test-properties-context.xml";
		for (int i = 0; i < contexts.length; i++) {
			String context = contexts[i];
			if (!context.endsWith(suffix)) {
				context = context + suffix;
			}
			String contextPath = path + context;
			contextPaths[i + 1] = contextPath;
			org.junit.Assert.assertTrue("added context: " + contextPath, true);
		}
		return contextPaths;
	}

}
