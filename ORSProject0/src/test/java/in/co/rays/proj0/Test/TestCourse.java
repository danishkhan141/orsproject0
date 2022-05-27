package in.co.rays.proj0.Test;

import java.sql.Timestamp;
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

import in.co.rays.proj0.dto.CourseDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;
import in.co.rays.proj0.service.CourseServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class TestCourse {
	
	@Autowired
	private CourseServiceInt model;

	@Ignore
	public void add() throws DuplicateRecordException{
		CourseDTO dto = new CourseDTO();
		dto.setDuration("2year");
		dto.setDescription("core subject");
		dto.setCourseName("M1");
		dto.setCreatedBy("admin");
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.add(dto);
	}
	
	@Ignore
	public void update() throws DuplicateRecordException{
		CourseDTO dto = new CourseDTO();
		dto.setId(1);
		dto.setDuration("4year");
		dto.setDescription("scientific Course");
		dto.setCourseName("bsc");
		dto.setCreatedBy("admin");
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.update(dto);
	}
	
	@Ignore
	
	public void delete(){
		
		model.delete(2);
	}
	
	@Ignore

	public void findbyname(){
		
		CourseDTO dto = model.findByCourseName("physocology");
		
		System.out.println(dto.getId());
		System.out.println(dto.getCourseName());
		System.out.println(dto.getDescription());
		System.out.println(dto.getDuration());
		System.out.println(dto.getModifiedDatetime());
		
	}
	
	@Ignore
	
	public void findbypk(){
		
CourseDTO dto = model.findById(1l);
		
		System.out.println(dto.getId());
		System.out.println(dto.getCourseName());
		System.out.println(dto.getDescription());
		System.out.println(dto.getDuration());
		System.out.println(dto.getModifiedDatetime());
		
		
	}
	
	@Test
	public void search(){
		CourseDTO dto = null;
		List list = model.search(dto, 0, 0);
		Iterator it = list.iterator();
		while(it.hasNext()){
			dto = (CourseDTO) it.next();
			
			System.out.println(dto.getId());
			System.out.println(dto.getCourseName());
			System.out.println(dto.getDescription());
			System.out.println(dto.getDuration());
			System.out.println(dto.getModifiedDatetime());
			
		}
	}
	
}
