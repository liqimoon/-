

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Log4jConfigurer;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SpringTest {
	
	@Autowired
	private WebApplicationContext wac;
	protected MockMvc mockMvc;
	
	static {  
		try {  
			Log4jConfigurer.initLogging("classpath:properties/log4j.properties");  
		} catch (FileNotFoundException ex) {  
			System.err.println("Cannot Initialize log4j");  
		}  
	}  
	
	@Before
	public void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	public Object getContext(String name,Class<?> clazz){
		return wac.getBean(name,clazz);
	}

}