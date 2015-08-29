package hopefully.com.testi;

import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.matchers.JUnitMatchers.containsString;

/**
 * Created by Dell on 8/28/2015.
 */


@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)

@RunWith(RobolectricGradleTestRunner.class)

public class MianActivityTest {
    private MainActivity activity;


    @Test
    public void shouldProduceGreetingWhenButtonPressed() {
        activity = Robolectric.setupActivity(MainActivity.class);

        TextView textView = (TextView) activity.findViewById(R.id.textView);
        Button button = (Button) activity.findViewById(R.id.button);
        EditText editText = (EditText) activity.findViewById(R.id.editText);

        editText.setText("dhamini");

        button.performClick();

        assertThat(textView).isNotNull();

    }

    @Test
    public void testAssertThatContainsString() {
        activity = Robolectric.setupActivity(MainActivity.class);
        TextView textView = (TextView) activity.findViewById(R.id.textView);
        Button button = (Button) activity.findViewById(R.id.button);
        EditText editText = (EditText) activity.findViewById(R.id.editText);

        editText.setText("Peter");
        button.performClick();

        final StringBuilder sb = new StringBuilder(textView.getText());
        String text = sb.toString();
        org.junit.Assert.assertThat(text, containsString("Hello, Peter !"));
    }

    @Test
    public void testAssertThatNotContainsString() {
        activity = Robolectric.setupActivity(MainActivity.class);
        TextView textView = (TextView) activity.findViewById(R.id.textView);
        Button button = (Button) activity.findViewById(R.id.button);
        EditText editText = (EditText) activity.findViewById(R.id.editText);

        editText.setText("Peter");
        button.performClick();

        final StringBuilder sb = new StringBuilder(textView.getText());
        String text = sb.toString();
//        org.junit.Assert.assertThat(text, containsString("Hello, Peter !"));
//        org.junit.Assert.assertThat(text, not(startsWith("Hello")));
        org.junit.Assert.assertThat(text, not(containsString("dhamini")));
    }
}