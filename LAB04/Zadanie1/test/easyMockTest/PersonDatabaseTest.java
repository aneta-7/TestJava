package easyMockTest;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import easyMock.Person;
import easyMock.PersonDatabaseService;
import easyMock.PersonException;
import easyMock.PersonMockServiceImpl;

public class PersonDatabaseTest {

	
	private PersonMockServiceImpl serv;
	private PersonDatabaseService mockService;
	
	@Before
	public void setUp() throws Exception {
		mockService = EasyMock.createMock(PersonDatabaseService.class);
		serv = new PersonMockServiceImpl();
		serv.setService(mockService);
	}

	@After
	public void tearDown() throws Exception {
		mockService = null;
		serv = null;
	}

	@Test
	public void AddPersonTestCorrect() throws SQLException, PersonException {
		Person person = new Person(1,"Jan","Kowalski",2000);
		EasyMock.expect(mockService.AddPerson(person)).andReturn(1);
		EasyMock.replay(mockService);
		boolean result = serv.AddPerson(person);
		assertTrue(result);
		EasyMock.verify(mockService);
	}
	
	@Test(expected=PersonException.class)
	public void AddPersonTestBad() throws SQLException, PersonException{
		Person person = new Person();
		EasyMock.expect(mockService.AddPerson(person)).andThrow(new SQLException());
		EasyMock.replay(mockService);
		boolean result = serv.AddPerson(person);
		assertTrue(result);
		EasyMock.verify(mockService);
	}

	@Test
	public void ReadPersonTestCorrect()throws SQLException, PersonException{
		int id = 2;
		EasyMock.expect(mockService.read(id)).andReturn(new Person(2, "nowy", "nowy", 3000));
		EasyMock.replay(mockService);
		boolean result = serv.Read(id);
		assertTrue(result);
		EasyMock.verify(mockService);	
	}
	
	@Test(expected=PersonException.class)
	public void ReadPersonTestBad() throws SQLException, PersonException{
		int id =1;
		EasyMock.expect(mockService.read(id)).andThrow(new SQLException());
		EasyMock.replay(mockService);
		boolean result = serv.Read(id);
		assertTrue(result);
		EasyMock.verify(mockService);
	}
	
	@Test 
	public void UpdatePersonTestCorrect()throws SQLException, PersonException{	
		int id = 2;
		EasyMock.expect(mockService.update(id)).andReturn(2);
		EasyMock.replay(mockService);
		boolean result = serv.Update(id);
		assertTrue(result);
		EasyMock.verify(mockService);
	}
	
	@Test(expected=PersonException.class)
	public void UpdatePersonTestBad() throws SQLException, PersonException{
		int id = 1;
		EasyMock.expect(mockService.update(id)).andThrow(new SQLException());
		EasyMock.replay(mockService);
		boolean result = serv.Update(id);
		assertTrue(result);
		EasyMock.verify(mockService);
	}

	@Test
	public void RemovePersonTestCorrcet()throws SQLException, PersonException{
		int id = 2;
		EasyMock.expect(mockService.remove(id)).andReturn(2);
		EasyMock.replay(mockService);
		boolean result = serv.Remove(id);
		assertTrue(result);
		EasyMock.verify(mockService);
	}

	@Test(expected=PersonException.class)
	public void RemovePersonTestBad() throws SQLException, PersonException{
		int id =1;
		EasyMock.expect(mockService.remove(id)).andThrow(new SQLException());
		EasyMock.replay(mockService);
		boolean result = serv.Remove(id);
		assertTrue(result);
		EasyMock.verify(mockService);
	}
}