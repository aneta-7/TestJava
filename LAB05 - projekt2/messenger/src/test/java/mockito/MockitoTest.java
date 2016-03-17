package mockito;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.mockdemo.app.Messenger;
import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

import static org.mockito.Mockito.*;

public class MockitoTest {

	private Messenger messenger;
	@Mock
	private MessageService messageMock;

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		messenger = new Messenger(messageMock);
	}

	@Test
	public void mockitoTestSEND() throws MalformedRecipientException {
		when(messageMock.send(VALID_SERVER, VALID_MESSAGE)).thenReturn(SendingStatus.SENT);
		assertEquals(0, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
		verify(messageMock).send(VALID_SERVER, VALID_MESSAGE);
	}

	@Test
	public void mockitoTestSENDING_ERROR() throws MalformedRecipientException {
		when(messageMock.send(VALID_SERVER, INVALID_MESSAGE)).thenReturn(SendingStatus.SENDING_ERROR);
		assertEquals(1, messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE));
		verify(messageMock).send(VALID_SERVER, INVALID_MESSAGE);
	}

	@Test
	public void mockitoTestException() throws MalformedRecipientException {
		when(messageMock.send(VALID_SERVER, INVALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		assertEquals(2, messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE));
		verify(messageMock).send(VALID_SERVER, INVALID_MESSAGE);
	}

	@Test
	public void mockitoTestMessageNull() throws MalformedRecipientException {
		when(messageMock.send(VALID_SERVER, null)).thenThrow(new MalformedRecipientException());
		assertEquals(2, messenger.sendMessage(VALID_SERVER, null));
		verify(messageMock).send(VALID_SERVER, null);
	}

	@Test
	public void mockitoTestServerNull() throws MalformedRecipientException {
		when(messageMock.send(null, INVALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		assertEquals(2, messenger.sendMessage(null, INVALID_MESSAGE));
		verify(messageMock).send(null, INVALID_MESSAGE);
	}

	@Test
	public void mockitoConnectionSuccess() {
		when(messageMock.checkConnection(VALID_SERVER)).thenReturn(ConnectionStatus.SUCCESS);
		assertEquals(0, messenger.testConnection(VALID_SERVER));
		verify(messageMock).checkConnection(VALID_SERVER);
	}

	@Test
	public void mockitoConnectionFailure() {
		when(messageMock.checkConnection(INVALID_SERVER)).thenReturn(ConnectionStatus.FAILURE);
		assertEquals(1, messenger.testConnection(INVALID_SERVER));
		verify(messageMock).checkConnection(INVALID_SERVER);
	}

	@Test
	public void mockitoConnectionNull() {
		when(messageMock.checkConnection(null)).thenReturn(ConnectionStatus.FAILURE);
		assertEquals(1, messenger.testConnection(null));
		verify(messageMock).checkConnection(null);
	}

	@Test
	public void mockitoConnectionEmpty() {
		when(messageMock.checkConnection("")).thenReturn(ConnectionStatus.FAILURE);
		assertEquals(1, messenger.testConnection(""));
		verify(messageMock).checkConnection("");
	}
}
