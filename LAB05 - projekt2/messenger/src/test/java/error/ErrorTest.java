package error;

import static org.easymock.EasyMock.createMock;

import org.junit.Before;

import com.example.mockdemo.app.Messenger;
import com.example.mockdemo.messenger.MessageService;

public class ErrorTest {

	private Messenger messenger;
	private MessageService messageMock;

	@Before
	public void setUp() {
		messageMock = createMock(MessageService.class);
		messenger = new Messenger(messageMock);
	}

}
