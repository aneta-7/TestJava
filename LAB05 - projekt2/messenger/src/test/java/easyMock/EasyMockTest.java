package easyMock;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.mockdemo.app.Messenger;
import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class EasyMockTest {

	private Messenger messenger;
	private MessageService messageMock;

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";

	@Before
	public void setUp() {
		messageMock = createMock(MessageService.class);
		messenger = new Messenger(messageMock);
	}

	@Test
	public void connectTestReturn0() {

		expect(messageMock.checkConnection(VALID_SERVER)).andReturn(ConnectionStatus.SUCCESS).anyTimes();
		replay(messageMock);

		assertEquals(0, messenger.testConnection(VALID_SERVER));
		verify(messageMock);
	}

	@Test
	public void connectionTestReturn1() {
		expect(messageMock.checkConnection(INVALID_SERVER)).andReturn(ConnectionStatus.FAILURE).anyTimes();
		replay(messageMock);
		assertEquals(1, messenger.testConnection(INVALID_SERVER));
		verify(messageMock);
	}

	@Test
	public void connectionTestResturn2Exception_Empty() throws MalformedRecipientException {
		expect(messageMock.send("", "")).andThrow(new MalformedRecipientException());
		replay(messageMock);
		assertEquals(2, messenger.sendMessage("", ""));
		verify(messageMock);
	}

	@Test
	public void connectionTestResturn2Exception_null() throws MalformedRecipientException {
		expect(messageMock.send(null, null)).andThrow(new MalformedRecipientException());
		replay(messageMock);
		assertEquals(2, messenger.sendMessage(null, null));
		verify(messageMock);
	}

	@Test
	public void connectionTestResturn2Exception_SENT() throws MalformedRecipientException {
		expect(messageMock.send("VALID_SERVER", "VALID_MESSAGE")).andReturn(SendingStatus.SENT);
		replay(messageMock);
		assertEquals(0, messenger.sendMessage("VALID_SERVER", "VALID_MESSAGE"));
		verify(messageMock);
	}

	@Test
	public void connectionTestResturn2Exception_SENDING_ERROR() throws MalformedRecipientException {
		expect(messageMock.send(VALID_SERVER, INVALID_MESSAGE)).andThrow(new MalformedRecipientException());
		replay(messageMock);
		assertEquals(2, messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE));
		verify(messageMock);
	}
	
	@Test
	public void connectionTestResturn2Exception_MessageNull() throws MalformedRecipientException {
		expect(messageMock.send(VALID_SERVER, null)).andReturn(SendingStatus.SENDING_ERROR);
		replay(messageMock);
		assertEquals(1, messenger.sendMessage(VALID_SERVER, null));
		verify(messageMock);
	}
	
	@Test
	public void connectionTestResturn2Exception_ServerNull() throws MalformedRecipientException {
		expect(messageMock.send(null, VALID_MESSAGE)).andReturn(SendingStatus.SENDING_ERROR);
		replay(messageMock);
		assertEquals(1, messenger.sendMessage(null,  VALID_MESSAGE));
		verify(messageMock);
	}
}
