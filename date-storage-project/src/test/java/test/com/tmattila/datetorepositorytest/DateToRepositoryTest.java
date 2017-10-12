package test.com.tmattila.datetorepositorytest;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tmattila.launcher.App;
import com.tmattila.model.Dates;
import com.tmattila.repository.DateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class DateToRepositoryTest {

	@Autowired
	DateRepository dateRepository;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println("Start test");
		Date date = new Date();
		DateFormat dateF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String formattedDate = dateF.format(date);
		Dates dateModel = new Dates();
		dateModel.setTitle("TEST");
		dateModel.setDateForm(formattedDate);
		Assert.assertNotNull(dateRepository.save(dateModel));
		System.out.println(formattedDate);
		System.out.println("Test complete");
		System.out.println("Close test");
	}
}