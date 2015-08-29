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
//        String h = "hello world";
        Button button = (Button) activity.findViewById(R.id.button);
        EditText editText = (EditText) activity.findViewById(R.id.editText);
        editText.setText("Peter");
//        textView.setText("Hello, Peter!");
        button.performClick();
//        assertTrue("TextView contains incorrect text",
//                "hello_world".equals(textView.getText().toString()));
        assertThat(textView).isNotNull();
        final StringBuilder sb = new StringBuilder(textView.getText());
        String text = sb.toString();
        org.junit.Assert.assertThat(text, containsString("Hello, Peter !"));
//        assertThat(textView).containsText("Hello, Peter!");
//        assertThat(textView.getText(), containsString("Hello, Peter!"));


    }
//    @Test
//    public void testAssertThatBothContainsString() {
//        TextView textView = (TextView) activity.findViewById(R.id.textView);
//        final StringBuilder sb = new StringBuilder(textView.getText().length());
////        sb.append(charSequence);
//        String text = sb.toString();
////        String text = toString(textView.getText());
//        org.junit.Assert.assertThat(text, containsString("b"));
//    }
}
