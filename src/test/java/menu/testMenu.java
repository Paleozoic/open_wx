package menu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.open.wx.services.IMenuMgrService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/spring-web.xml"})
public class testMenu {
	@Autowired
	private IMenuMgrService menuService;
	@Test
	public void test() {
		menuService.create();
	}
}
