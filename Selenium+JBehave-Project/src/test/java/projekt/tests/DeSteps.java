package projekt.tests;

import java.util.Locale;

public class DeSteps extends LocalizedStories {
	
	private Pages pages;
	
	@Override
    protected Locale locale() {
        return new Locale("de");
    }

    @Override
    protected String storyPattern() {
        return "**/*.geschichte";
    }

    @Override
    protected Object localizedSteps() {
        return new EmailSteps(pages);
    }
}
