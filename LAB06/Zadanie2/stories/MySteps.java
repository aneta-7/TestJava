import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.steps.Steps;

import max.MaxImpl;
public class MySteps extends Steps{
	
	private List<Integer> list;
	MaxImpl impl = new MaxImpl();
	
	@Given("an array by $value")
	public void givenAnArray(@Named("value") List<Integer> value){
		list = value;
	}
	
	@Then("max should equal $value")
	public void thenMaxShouldEqual(@Named("value") Integer value){
		 if(impl.max(list) != value){
			 throw new RuntimeException("Error in test!");
		 }
	}
}