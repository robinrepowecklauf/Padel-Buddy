package com.danielkarlkvist.padelbuddy.Controller;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.danielkarlkvist.padelbuddy.MainActivity;
import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.Model.Player;
import com.danielkarlkvist.padelbuddy.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * The ProfileFragmentControllerTest class defines Android instrumented unit test
 *
 * @author Robin Repo Wecklauf
 * @version 1.0
 * @since 2019-10-08
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ProfileFragmentControllerTest {

    private ProfileFragmentController profile;
    private PadelBuddy padelBuddy;
    private Player user;

    /**
     * Provides functional testing of a MainActivity
     */

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    /**
     * Initializes the fragment to test and allows to read and manipulate all id's in the given fragment
     *
     * @throws Exception any error
     */

    @Before
    public void setUp() throws Exception {
        profile = new ProfileFragmentController();
        padelBuddy = PadelBuddy.getInstance();
        user = padelBuddy.getPlayer();
        activityRule.getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, profile, "Profile").commit();
    }

    /**
     * Decides what to do after the tests is done
     *
     * @throws Exception any error
     */

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void doesProfileExist_Exists_ReturnsTrue() throws Exception {
        assertNotNull(onView(withId(R.id.profile_fragment)));
    }

    @Test
    public void isProfileInEditMode_IsInEditMode_ReturnsTrue() throws Exception {
        assertNotNull(onView(withId(R.id.edit_profile_button)));

        onView(withId(R.id.edit_profile_button)).check(matches(isClickable()));
        onView(withId(R.id.edit_profile_button)).perform(click());

        onView(withId(R.id.profile_firstname_edit)).check(matches(isDisplayed()));
        onView(withId(R.id.profile_lastname_edit)).check(matches(isDisplayed()));
        onView(withId(R.id.profile_bio_edit)).check(matches(isDisplayed()));
    }

    @Test
    public void firstnameValidator_CorrectFirstname_ReturnsTrue() throws Exception {
        onView(withId(R.id.edit_profile_button)).perform(click());
        onView(withId(R.id.profile_firstname_edit)).perform(replaceText("Robin"));
        onView(withId(R.id.edit_profile_button)).perform(click());

        onView(withId(R.id.profile_name)).check(matches(withText("Robin " + user.getLastname())));
    }

    @Test
    public void firstnameValidator_SwedishLetters_ReturnsTrue() throws Exception {
        onView(withId(R.id.edit_profile_button)).perform(click());
        onView(withId(R.id.profile_firstname_edit)).perform(replaceText("åäö"));
        onView(withId(R.id.edit_profile_button)).perform(click());

        onView(withId(R.id.profile_name)).check(matches(withText("åäö " + user.getLastname())));
    }

    @Test
    public void firstnameValidator_() throws Exception {
        onView(withId(R.id.edit_profile_button)).perform(click());
        onView(withId(R.id.profile_firstname_edit)).perform(replaceText("åäö"));
        onView(withId(R.id.edit_profile_button)).perform(click());

        onView(withId(R.id.profile_name)).check(matches(withText("åäö " + user.getLastname())));
    }
}