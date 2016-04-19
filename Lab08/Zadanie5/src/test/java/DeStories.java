import java.util.Locale;

public class DeStories extends LocalizedStories {
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
        return new DeSteps();
    }
}
