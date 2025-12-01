package com.example.android.testing.espresso.BasicSample;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ChangeTextBehaviorTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    // 1) Validate correct initial text in MainActivity
    @Test
    public void validateInitialText_inMainActivity() {
        onView(withId(R.id.textToBeChanged))
                .check(matches(withText("Hello world!")));
    }

    // 2) same activity, input "123"
    @Test
    public void changeText_sameActivity_withNumber123() {
        onView(withId(R.id.editTextUserInput))
                .perform(typeText("123"), closeSoftKeyboard());
        onView(withId(R.id.changeTextBt)).perform(click());
        onView(withId(R.id.textToBeChanged))
                .check(matches(withText("123")));
    }

    // 3) new activity, input "123"
    @Test
    public void changeText_newActivity_withNumber123() {
        onView(withId(R.id.editTextUserInput))
                .perform(typeText("123"), closeSoftKeyboard());
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        onView(withId(R.id.show_text_view))
                .check(matches(withText("123")));
    }

    // 4) same activity, empty string
    @Test
    public void changeText_sameActivity_withEmptyString() {
        onView(withId(R.id.changeTextBt)).perform(click());
        onView(withId(R.id.textToBeChanged))
                .check(matches(withText("")));
    }

    // 5) new activity, empty string
    @Test
    public void changeText_newActivity_withEmptyString() {
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        onView(withId(R.id.show_text_view))
                .check(matches(withText("")));
    }

    // 6) same activity, input "abcdef"
    @Test
    public void changeText_sameActivity_withAbcdef() {
        onView(withId(R.id.editTextUserInput))
                .perform(typeText("abcdef"), closeSoftKeyboard());
        onView(withId(R.id.changeTextBt)).perform(click());
        onView(withId(R.id.textToBeChanged))
                .check(matches(withText("abcdef")));
    }

    // 7) new activity, input "abcdef"
    @Test
    public void changeText_newActivity_withAbcdef() {
        onView(withId(R.id.editTextUserInput))
                .perform(typeText("abcdef"), closeSoftKeyboard());
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        onView(withId(R.id.show_text_view))
                .check(matches(withText("abcdef")));
    }
}