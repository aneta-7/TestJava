package mockito;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.mockdemo.app.Messenger;
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
	public void mockitoTestOK() throws MalformedRecipientException{
		when(messageMock.send(VALID_SERVER, VALID_MESSAGE)).thenReturn(SendingStatus.SENT);
		assertEquals(0, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
		verify(messageMock).send(VALID_SERVER, VALID_MESSAGE);
	}
	
	@Test
	public void mockitoTest_InvalidMessage() throws MalformedRecipientException{
		when(messageMock.send(VALID_SERVER, INVALID_MESSAGE)).thenReturn(SendingStatus.SENDING_ERROR);
		assertEquals(1, messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE));
		verify(messageMock).send(VALID_SERVER, INVALID_MESSAGE);
	}
	
	
	
}
