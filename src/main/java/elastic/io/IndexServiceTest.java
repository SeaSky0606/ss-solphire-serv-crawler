package elastic.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IndexServiceTest {
	
	IndexService is = new IndexService();
	
	@Before
	public void before() {
		System.out.println("----init---");
		is.init();
	}
	
	@After
	public void after(){
		System.out.println("----finish---");
	}
	

	@Test
	public void testWrite() {
		is.write();
	}

}
