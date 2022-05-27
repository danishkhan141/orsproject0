package in.co.rays.proj0.Test;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import freemarker.core.ParseException;
import in.co.rays.proj0.dto.StudentDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;
import in.co.rays.proj0.service.StudentServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class TestStudent {
	
	@Autowired
	private StudentServiceInt model;
	
	@Ignore
	public void add() throws DuplicateRecordException{
		
		StudentDTO dto = new StudentDTO();
		dto.setCollegeId(1);
		dto.setEmail("kelash344@gmail.com");
		dto.setFirstName("kelash");
		dto.setLastName("khemot");
		dto.setMobileNo("9869695493");
		model.add(dto);
	}
	@Ignore
	public void update() throws ParseException, Exception{
		StudentDTO dto =model.findById(1l);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dto.setCollegeId(2);
		dto.setFirstName("mayank");
		dto.setLastName("silawat");
		dto.setMobileNo("8959594932");
		dto.setEmail("mayank455@gmail.com");
		dto.setDob(sdf.parse("23/04/1998"));
		dto.setCreatedBy("admin");
		model.update(dto);
	}
	
	
	@Ignore
	public void delete(){
		
		model.delete(1);
		
	}
	
	
	
	@Ignore
	public void findbyemail(){
		
		StudentDTO dto  = model.findByEmail("mayank455@gmail.com");
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getCollegeName());
		
	}

	
	@Test
	public void search(){
		StudentDTO dto = new StudentDTO();
		List list = model.search(dto, 0, 0);
		Iterator it = list.iterator();
		while(it.hasNext()){
			dto = (StudentDTO) it.next();
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getCollegeName());
	
		}
		}
}

