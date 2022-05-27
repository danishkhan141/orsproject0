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
import in.co.rays.proj0.dto.TimeTableDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;
import in.co.rays.proj0.service.TimeTableServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
public class TestTimeTable {

	
	@Autowired
	private TimeTableServiceInt model;
	
	@Ignore
	public void add() throws DuplicateRecordException, ParseException, Exception{
		
		TimeTableDTO dto = new TimeTableDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dto.setCourseId(1l);
		dto.setSubjectId(1l);
		dto.setExamDate(sdf.parse("12/06/2021"));
		dto.setSemester("4th");
		dto.setCreatedBy("admin");
		model.add(dto);
	}
	
	@Ignore
	public void update() throws ParseException, DuplicateRecordException, Exception{
		TimeTableDTO dto =model.findById(1l);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dto.setCourseId(1l);
		dto.setSubjectId(1l);
		dto.setExamDate(sdf.parse("15/06/2021"));
		dto.setSemester("6th");
		dto.setCreatedBy("admin");
		model.update(dto);
	}
	
	@Ignore
	public void delete(){
		
		model.delete(1);
		
	}
	
	
	@Test
	public void search(){
		TimeTableDTO dto = new TimeTableDTO();
		List list = model.search(dto, 0, 0);
		Iterator it = list.iterator();
		while(it.hasNext()){
			dto = (TimeTableDTO) it.next();
			System.out.println(dto.getCourseName());
			System.out.println(dto.getSubjectName());
			System.out.println(dto.getSemester());
	
		}
		}
	
	
	
	
}
