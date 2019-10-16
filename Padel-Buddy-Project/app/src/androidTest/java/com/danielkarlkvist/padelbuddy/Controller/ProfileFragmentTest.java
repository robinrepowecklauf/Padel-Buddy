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
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * The ProfileFragmentTest class defines Android instrumented unit test
 *
 * @author Robin Repo Wecklauf
 * @version 1.0
 * @since 2019-10-08
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ProfileFragmentTest {

    private ProfileFragment profile;
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
        padelBuddy = new PadelBuddy();
        user = padelBuddy.getPlayer();
        profile = new ProfileFragment(user);
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
        try{
            assertNotNull(onView(withId(R.id.profile_fragment)));
        } catch (Exception e) {
            System.out.println("Error message + " + e.getMessage() + " Profile Fragment does not exist");
        }
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
    public void firstnameValidator_ValidInput_ReturnsTrue() throws Exception {
        String newFirstnameToBeSet = "Robin";
        onView(withId(R.id.edit_profile_button)).perform(click());
        onView(withId(R.id.profile_firstname_edit)).perform(clearText());
        onView(withId(R.id.profile_firstname_edit)).perform(typeText(newFirstnameToBeSet));
        onView(withId(R.id.edit_profile_button)).perform(click());

        onView(withId(R.id.profile_name)).check(matches(withText(newFirstnameToBeSet + " " + user.getLastname())));
    }

    @Test
    public void firstnameValidator_SwedishLetters_ReturnsTrue() throws Exception {
        String newFirstnameToBeSet = "åäö";
        onView(withId(R.id.edit_profile_button)).perform(click());
        onView(withId(R.id.profile_firstname_edit)).perform(clearText());
        onView(withId(R.id.profile_firstname_edit)).perform(replaceText(newFirstnameToBeSet));
        onView(withId(R.id.edit_profile_button)).perform(click());

        onView(withId(R.id.profile_name)).check(matches(withText(newFirstnameToBeSet + " " + user.getLastname())));
    }

    @Test
    public void firstnameValidator_SpecialCharacterUsed_ReturnsFalse() throws Exception {
        String newFirstnameToBeSet = "*?!";
        onView(withId(R.id.edit_profile_button)).perform(click());
        onView(withId(R.id.profile_firstname_edit)).perform(clearText());
        onView(withId(R.id.profile_firstname_edit)).perform(typeText(newFirstnameToBeSet));
        onView(withId(R.id.edit_profile_button)).perform(click());

        assertNotEquals(newFirstnameToBeSet, user.getFirstname());
    }

    @Test
    public void firstnameValidator_EmptyString_ReturnsFalse() throws Exception {
        String newFirstnameToBeSet = "";
        onView(withId(R.id.edit_profile_button)).perform(click());
        onView(withId(R.id.profile_firstname_edit)).perform(clearText());
        onView(withId(R.id.profile_firstname_edit)).perform(typeText(newFirstnameToBeSet));
        onView(withId(R.id.edit_profile_button)).perform(click());

        assertNotEquals(newFirstnameToBeSet, user.getFirstname());
    }

    @Test
    public void firstnameValidator_NullFirstname_ReturnsFalse() throws Exception {
        onView(withId(R.id.edit_profile_button)).perform(click());
        onView(withId(R.id.profile_firstname_edit)).perform(clearText());
        onView(withId(R.id.edit_profile_button)).perform(click());

        assertNotEquals(null, user.getFirstname());
    }

    @Test
    public void bioValidator_ValidInput_ReturnsTrue() throws Exception {
        String newBioToBeSet = "lorem ipsum dolores sit amet";
        onView(withId(R.id.edit_profile_button)).perform(click());
        onView(withId(R.id.profile_bio_edit)).perform(clearText());
        onView(withId(R.id.profile_bio_edit)).perform(typeText(newBioToBeSet));
        onView(withId(R.id.edit_profile_button)).perform(click());

        assertEquals(newBioToBeSet, user.getBio());
    }

    @Test
    public void bioValidator_EmptyBio_ReturnsTrue() throws Exception {
        String newBioToBeSet = "";
        onView(withId(R.id.edit_profile_button)).perform(click());
        onView(withId(R.id.profile_bio_edit)).perform(clearText());
        onView(withId(R.id.profile_bio_edit)).perform(typeText(newBioToBeSet));
        onView(withId(R.id.edit_profile_button)).perform(click());

        assertEquals(newBioToBeSet, user.getBio());
    }

    @Test
    public void bioValidator_NullBio_ReturnsFalse() throws Exception {
        onView(withId(R.id.edit_profile_button)).perform(click());
        onView(withId(R.id.profile_bio_edit)).perform(clearText());
        onView(withId(R.id.edit_profile_button)).perform(click());

        assertNotEquals(null, user.getBio());
    }
}