package in.co.rays.proj0.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import in.co.rays.proj0.dto.FacultyDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;
import in.co.rays.proj0.service.FacultyServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
public class TestFaculty {
	
	@Autowired
	private FacultyServiceInt model ;
	
	@Ignore
	public void add() throws ParseException, DuplicateRecordException, Exception{
		FacultyDTO dto = new FacultyDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//dto.setSubjectid(1);
		dto.setCollegeId(1L);
		//dto.setCourseid(1);
		dto.setSubjectId(1l);
		dto.setLoginId("hemesh23@gmail.com");
		dto.setFirstName("hemesh");
		dto.setLastName("shrikant");
		dto.setDoj(sdf.parse("22/07/1995"));
		dto.setCreatedBy("admin");
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		
		model.add(dto);
	}
	
	
	@Test
	public void update() throws ParseException, Exception{
		FacultyDTO dto = new FacultyDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dto.setId(1);
		dto.setCollegeId(1l);
		dto.setSubjectId(1l);
		//dto.setCourseid(1l);
		dto.setLoginId("lokesh23@gmail.com");
		dto.setFirstName("lokesh");
		dto.setLastName("dixit");
		dto.setDoj(sdf.parse("10/06/2000"));
		dto.setCreatedBy("admin");
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		model.update(dto);
	}
	
	@Ignore
	public void findbyemail(){
		FacultyDTO dto = model.findByLoginId("lokesh23@gmail.com");
		System.out.println(dto.getCollegeName());
		//System.out.println(dto.getCoursename());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getCreatedBy());
	}
	
@Ignore
	public void findbypk(){
		FacultyDTO dto = model.findById(1);
		System.out.println(dto.getCollegeName());
		//System.out.println(dto.getCoursename());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getCreatedBy());
	}

@Ignore
public void search(){
	FacultyDTO dto = null;
	List list = model.search(dto, 0, 0);
	Iterator it = list.iterator();
	while(it.hasNext()){
		dto = (FacultyDTO) it.next();
		System.out.println(dto.getCollegeName());
		//System.out.println(dto.getCoursename());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getCreatedBy());
		
	}
	
	
}
	
}
