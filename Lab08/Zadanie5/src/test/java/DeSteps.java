import java.util.List;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;


public class DeSteps extends Steps {

	Stack myStack;

	@BeforeScenario
	public void up() {
		myStack = new Stack();
	}

	@AfterScenario
	public void tearDown(){
		myStack = null;
	}
	int element;

	// empty true
	@Given("the stack is empty")
	public void givenTheEmptyStack() {
		myStack = new Stack();
	}

	@Then("IsEmpty schould be true")
	public void thenIsEmptyShouldBeTrue() {
		try{
		if (myStack.IsEmpty() == true) {
			throw new RuntimeException("Error in IsEmpty method. It's ok");
		}
		}catch(Exception e){}
	}

	// empty false
	@Given("the stack by $list")
	public void givenTheStackBylist(@Named("list") List<Integer> list) {
		myStack = new Stack(list);
	}

	@Then("IsEmpty should be false")
	public void thenIsEmptyShouldBeFalse() {
		if (myStack.IsEmpty() != false) {
			throw new RuntimeException("Error in IsEmpty method. It's ok");
		}
	}
	
	// pop
		@Given("the nonEmpty stack by $list")
		public void givenTheNonemptyStackBylist(@Named("list") List<Integer> list) {
			myStack = new Stack(list);
		}

		@When("MyPop occurs")
		public void whenMyPopOccurs() {
			myStack.MyPop();
		}

		@Then("the top of stack should be $elem")
		public void thenTheTopOfStackShouldBeelem(@Named("elem") int elem) {
			if (myStack.MyTop() != elem) {
				throw new RuntimeException("Error in MyTop method. It's ok");
			}
		}

		// push
		@Given("an element by $elem")
		public void givenAnElementByelem(@Named("elem") int elem) {
			element = elem;
		}

		@When("an element is added to the stack")
		public void whenAnElementIsAddedToTheStack() {
			myStack.MyPush(element);
		}

		@Then("the stack should have $elem")
		public void thenTheStackShouldHaveelem(@Named("elem") int elem) {
			if (myStack.MyTop() != elem) {
				throw new RuntimeException("Error in MyPush method. It's ok");
			}
		}

		// top empty
		@Given("a new element by $elem")
		public void givenANewElementByelem(@Named("elem") int elem) {
			element = elem;
		}

		@When("the stack is empty")
		public void whenTheStackIsEmpty() {
		}

		@Then("MyTop should throw an exception")
		public void thenMyTopShouldThrowAnExcetion() {
			try {
				myStack.MyTop();
				throw new RuntimeException("Error in MyTop method. It's ok");
			} catch (NullPointerException e) {
			}
		}	
}