import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public class RunJBehaveJUnitStoriesTest  extends JUnitStories {

	public RunJBehaveJUnitStoriesTest(){
		super();
	}
	
	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration()
		// where to find the stories
				.useStoryLoader(new LoadFromClasspath())
				// CONSOLE and TXT reporting
				.useStoryReporterBuilder(
						new StoryReporterBuilder().withDefaultFormats()
								.withFormats(Format.CONSOLE, Format.TXT));
	}

	// Here we specify the steps classes
	@Override
	public InjectableStepsFactory stepsFactory() {
		// varargs, can have more that one steps classes
		return new InstanceStepsFactory(configuration(), new MySteps());
	}
	
		@Override
	protected List<String> storyPaths() {
		return Arrays.asList("ConnectionBAD.story","ConnectionOK.story", "SendMessageBAD.story", "SendMessageOK.story", "IncorrectDate.story");
	}

}
