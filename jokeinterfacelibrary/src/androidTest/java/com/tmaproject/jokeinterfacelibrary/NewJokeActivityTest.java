package com.tmaproject.jokeinterfacelibrary;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by TarekLMA on 7/4/17.
 * tarekkma@gmail.com
 */

@RunWith(AndroidJUnit4.class)
public class NewJokeActivityTest {
  @Rule public ActivityTestRule<NewJokeActivity> activityTestRule =
      new ActivityTestRule<>(NewJokeActivity.class);



  @Test
  public void testGetJoke(){
    onView(withId(R.id.joke_text)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)));
  }


}