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
import in.co.rays.proj0.dto.UserDTO;
import in.co.rays.proj0.exception.DuplicateRecordException;
import in.co.rays.proj0.service.UserServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
public class TestUser {

	@Autowired
	private UserServiceInt model;

	@Ignore
	public void add() throws DuplicateRecordException, ParseException, Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		UserDTO dto = new UserDTO();
		dto.setFirstName("Divya");
		dto.setLastName("Kumari");
		dto.setGender("Female");
		dto.setDob(sdf.parse("14/03/1997"));
		dto.setLogin("divya.kumari297@gmail.com");
		dto.setMobileNo("6260224254");
		dto.setCreatedBy("student");
		dto.setRoleId(1);
		dto.setPassword("Jio@2020");
		dto.setModifiedBy("student");
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.add(dto);
	}

	@Ignore
	public void update() throws ParseException, Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		UserDTO dto = model.findByLogin("nikhil22@gmail.com");
		dto.setFirstName("shreya");
		dto.setLastName("mehta");
		dto.setGender("female");
		dto.setDob(sdf.parse("17/06/2001"));
		dto.setLogin("shreya2000@gmail.com");
		dto.setMobileNo("987662434");
		dto.setCreatedBy("admin");
		dto.setRoleId(1);
		dto.setModifiedBy("admin");
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.update(dto);

	}

	@Test
	public void findbypk() {

		UserDTO dto = model.findById(1000);
		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getGender());
		System.out.println(dto.getMobileNo());
		System.out.println(dto.getCreatedBy());
		System.out.println(dto.getCreatedDatetime());
		System.out.println(dto.getRoleId());

	}

	@Ignore

	public void findbylogin() {
		UserDTO dto = model.findByLogin("umesh.prajapati297@gmail.com");
		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getGender());
		System.out.println(dto.getMobileNo());
		System.out.println(dto.getCreatedBy());
		System.out.println(dto.getCreatedDatetime());
		System.out.println(dto.getRoleId());

	}

	@Ignore
	public void delete() {
		model.delete(2);
	}

	@Ignore
	public void search() {

		UserDTO dto = new UserDTO();
		List list = model.search(dto, 0, 0);
		Iterator it = list.iterator();
		while (it.hasNext()) {

			dto = (UserDTO) it.next();

			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getGender());
			System.out.println(dto.getMobileNo());
			System.out.println(dto.getCreatedBy());
			System.out.println(dto.getCreatedDatetime());
			System.out.println(dto.getRoleId());

		}

	}

	@Ignore
	public void testregisteruser() {
		UserDTO dto = new UserDTO();

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

			dto.setFirstName("surya");
			dto.setLastName("yadav");
			dto.setLogin("umesh.prajapati297gmail.com");
			dto.setPassword("Surya@123");
			// bean.setConfirmpassword("1234");
			dto.setDob(sdf.parse("16/07/2002"));
			dto.setGender("male");
			dto.setRoleId(2);

			model.registerUser(dto);

			System.out.println("successful register");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * @Test public void testchangepass() throws DuplicateRecordException{
	 * 
	 * UserDTO dto = model.findbylogin("danishkhan.khan080@gmail.com");
	 * model.changepassword(1l, "danish@123" , "danish@2323");
	 * System.out.println("password changed Successfully"); }
	 */

}
