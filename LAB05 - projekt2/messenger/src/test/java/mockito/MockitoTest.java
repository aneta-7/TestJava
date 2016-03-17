package mockito;

import static org.easymock.EasyMock.createMock;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.mockdemo.app.Messenger;
import com.example.mockdemo.messenger.MessageService;

public class MockitoTest {

	private Messenger messenger;
	private MessageService messageMock;

	@Before
	public void setUp() {
		messageMock = createMock(MessageService.class);
		messenger = new Messenger(messageMock);
	}

}
