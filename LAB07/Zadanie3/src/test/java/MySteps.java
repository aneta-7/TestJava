import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;

import com.example.mockdemo.app.Messenger;
import com.example.mockdemo.messenger.MessageServiceMock;

import static org.junit.Assert.*;

public class MySteps extends Steps {

	Messenger ms;
	MessageServiceMock msm;
	Integer result;
	String server, message;

	@BeforeStory
	public void setUp() {
		msm = new MessageServiceMock();
		ms = new Messenger(msm);
		result = null;
		server = null;
		message = null;
	}
	
	@Given("address server $server")
	public void givenAddressServerserver(String server) {
		this.server = server;
	}

	@Given("bad connection")
	public void givenBadConnection() {
		msm.setConnection(false);
	}

	@Given("ok connection")
	public void givenOkConnection() {
		msm.setConnection(true);
	}
	

	@Given("message $message")
	public void givenMessagemessage(String message) {
		this.message = message;
	}
	
	@When("messenger sends message")
	public void whenMessengerSendsMessage() {
		result = ms.sendMessage(server, message);
	}

	@When("message can't sent")
	public void whenMessageCantSent() {
		msm.setMessageStatus(false);
	}

	@When("message sent")
	public void whenMessageSent() {
		msm.setMessageStatus(true);
	}
	
	@When("address connection is tested")
	public void whenAddressConnectionIsTested() {
		result = ms.testConnection(server);
	}

	@Then("result should equal $result")
	public void thenResultShouldEqualresult(Integer result) {
		assertEquals(result, this.result);
	}
}