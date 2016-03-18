package simpleTest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.mockdemo.app.Messenger;
import com.example.mockdemo.messenger.MessageServiceMock;

public class MessageAppTest {

	Messenger messenger;
	MessageServiceMock mockService; 

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";

	@Before
	public void setUp() throws Exception{
		mockService = new MessageServiceMock();
		messenger = new Messenger(mockService);
	}
	
	@Test 
	public void testConnectTrue(){
		mockService.setConnection(true);
		assertEquals(0, messenger.testConnection(VALID_SERVER));;
	}
	
	@Test
	public void testConnectionFalse(){
		mockService.setConnection(false);
		assertEquals(1, messenger.testConnection(VALID_SERVER));
	}
	
	@Test 
	public void testConnectInvalidServerTrue(){
		mockService.setConnection(true);
		assertEquals(1, messenger.testConnection(INVALID_SERVER));;
	}
	
	@Test
	public void testConnectionInvalidServerFalse(){
		mockService.setConnection(false);
		assertEquals(1, messenger.testConnection(INVALID_SERVER));
	}
	
	
	@Test 
	public void testConnectNull(){
		mockService.setConnection(true);
		assertEquals(1, messenger.testConnection(null));;
	}
	
	@Test 
	public void testConnectEmpty(){
		mockService.setConnection(true);
		assertEquals(1, messenger.testConnection(""));;
	}
	
	@Test
	public void testSendingMessageTrue() {
		mockService.setMessageStatus(true);
		assertEquals(0, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void testSendingMessageFalse() {
		assertEquals(1, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void testSendingMessageInvalidServer() {
		assertEquals(1, messenger.sendMessage(INVALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void testSendingMessageInvalidMessage() {
		assertEquals(2, messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE));
	}
	
	@Test
	public void testSendingMessageInvalid() {
		assertEquals(2, messenger.sendMessage(INVALID_SERVER, INVALID_MESSAGE));
	}
	
	@Test
	public void testSendingNull() {
		assertEquals(2, messenger.sendMessage(null, null));
	}
	
	@Test
	public void testSendingNullServer() {
		mockService.setMessageStatus(true);
		assertEquals(2, messenger.sendMessage(null, VALID_MESSAGE));
	}
	
	@Test
	public void testSendingNullServer2() {
		assertEquals(2, messenger.sendMessage(null, INVALID_MESSAGE));
	}
	
	@Test
	public void testSendingNullMessage() {
		assertEquals(2, messenger.sendMessage(VALID_SERVER, null));
	}
	
	@Test
	public void testSendingNullMessage2() {
		assertEquals(2, messenger.sendMessage(INVALID_SERVER, null));
	}
	
	@Test
	public void testSendingEmpty() {
		assertEquals(2, messenger.sendMessage("", ""));
	}
	
	@After
	public void tearDown(){
		mockService = null;
		messenger = null;
	}
	
}
