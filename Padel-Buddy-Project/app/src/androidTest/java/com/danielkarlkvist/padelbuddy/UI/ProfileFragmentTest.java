package com.danielkarlkvist.padelbuddy.UI;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.danielkarlkvist.padelbuddy.MainActivity;
import com.danielkarlkvist.padelbuddy.Model.PadelBuddy;
import com.danielkarlkvist.padelbuddy.Model.PlayerFactory;
import com.danielkarlkvist.padelbuddy.R;
import com.danielkarlkvist.padelbuddy.Services.TestFactory;

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

    /**
     * Provides functional testing of a MainActivity
     */

    @Rule
    public ActivityTestRule<LoginActivity> activityRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);


    /**
     * Initializes the fragment to test and allows to read and manipulate all id's in the given fragment
     *
     * @throws Exception any error
     */

    @Before
    public void setUp() throws Exception {
        padelBuddy = new PadelBuddy(PlayerFactory.createPlayer("r", "r", "s", "a", 1, 2));
        profile = new ProfileFragment(padelBuddy.getUser());
        onView(withId(R.id.test_daniel_button)).perform(click());
        activityRule.finishActivity();
    }

    public void initializeFragmentToTest() {
        mainActivityActivityTestRule.getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, profile, "Profile").commit();
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
        initializeFragmentToTest();
        try {
            assertNotNull(onView(withId(R.id.profile_fragment)));
        } catch (Exception e) {
            System.out.println("Error message + " + e.getStackTrace().toString() + " Profile Fragment does not exist");
        }
    }

    @Test
    public void isProfileInEditMode_IsInEditMode_ReturnsTrue() throws Exception {
        initializeFragmentToTest();
        assertNotNull(onView(withId(R.id.edit_profile_button)));

        onView(withId(R.id.edit_profile_button)).check(matches(isClickable()));
        onView(withId(R.id.edit_profile_button)).perform(click());

        onView(withId(R.id.profile_firstname_edit)).check(matches(isDisplayed()));
        onView(withId(R.id.profile_lastname_edit)).check(matches(isDisplayed()));
        onView(withId(R.id.profile_bio_edit)).check(matches(isDisplayed()));
    }

    @Test
    public void firstnameValidator_ValidInput_ReturnsTrue() throws Exception {
        initializeFragmentToTest();
        String newFirstnameToBeSet = "Robin";
        onView(withId(R.id.edit_profile_button)).perform(click());
        onView(withId(R.id.profile_firstname_edit)).perform(clearText());
        onView(withId(R.id.profile_firstname_edit)).perform(typeText(newFirstnameToBeSet));
        onView(withId(R.id.edit_profile_button)).perform(click());

        onView(withId(R.id.profile_name)).check(matches(withText(newFirstnameToBeSet + " " + padelBuddy.getUser().getLastName())));
    }

    @Test
    public void firstnameValidator_SwedishLetters_ReturnsTrue() throws Exception {
        initializeFragmentToTest();
        String newFirstnameToBeSet = "åäö";
        onView(withId(R.id.edit_profile_button)).perform(click());
        onView(withId(R.id.profile_firstname_edit)).perform(clearText());
        onView(withId(R.id.profile_firstname_edit)).perform(replaceText(newFirstnameToBeSet));
        onView(withId(R.id.edit_profile_button)).perform(click());

        onView(withId(R.id.profile_name)).check(matches(withText(newFirstnameToBeSet + " " + padelBuddy.getUser().getLastName())));
    }

    @Test
    public void firstnameValidator_SpecialCharacterUsed_ReturnsFalse() throws Exception {
        initializeFragmentToTest();
        String newFirstnameToBeSet = "*?!";
        onView(withId(R.id.edit_profile_button)).perform(click());
        onView(withId(R.id.profile_firstname_edit)).perform(clearText());
        onView(withId(R.id.profile_firstname_edit)).perform(typeText(newFirstnameToBeSet));
        onView(withId(R.id.edit_profile_button)).perform(click());

        assertNotEquals(newFirstnameToBeSet, padelBuddy.getUser().getFirstName());
    }

    @Test
    public void firstnameValidator_EmptyString_ReturnsFalse() throws Exception {
        initializeFragmentToTest();
        String newFirstnameToBeSet = "";
        onView(withId(R.id.edit_profile_button)).perform(click());
        onView(withId(R.id.profile_firstname_edit)).perform(clearText());
        onView(withId(R.id.profile_firstname_edit)).perform(typeText(newFirstnameToBeSet));
        onView(withId(R.id.edit_profile_button)).perform(click());

        assertNotEquals(newFirstnameToBeSet, padelBuddy.getUser().getFirstName());
    }

    @Test
    public void firstnameValidator_NullFirstname_ReturnsFalse() throws Exception {
        initializeFragmentToTest();
        onView(withId(R.id.edit_profile_button)).perform(click());
        onView(withId(R.id.profile_firstname_edit)).perform(clearText());
        onView(withId(R.id.edit_profile_button)).perform(click());

        assertNotEquals(null, padelBuddy.getUser().getFirstName());
    }

    @Test
    public void bioValidator_ValidInput_ReturnsTrue() throws Exception {
        initializeFragmentToTest();
        String newBioToBeSet = "lorem ipsum Dolores sit amet";
        onView(withId(R.id.edit_profile_button)).perform(click());
        onView(withId(R.id.profile_bio_edit)).perform(clearText());
        onView(withId(R.id.profile_bio_edit)).perform(typeText(newBioToBeSet));
        onView(withId(R.id.edit_profile_button)).perform(click());

        assertEquals(newBioToBeSet, padelBuddy.getUser().getBiography());
    }

    @Test
    public void bioValidator_EmptyBio_ReturnsTrue() throws Exception {
        initializeFragmentToTest();
        String newBioToBeSet = "";
        onView(withId(R.id.edit_profile_button)).perform(click());
        onView(withId(R.id.profile_bio_edit)).perform(clearText());
        onView(withId(R.id.profile_bio_edit)).perform(typeText(newBioToBeSet));
        onView(withId(R.id.edit_profile_button)).perform(click());

        assertEquals(newBioToBeSet, padelBuddy.getUser().getBiography());
    }

    @Test
    public void bioValidator_NullBio_ReturnsFalse() throws Exception {
        initializeFragmentToTest();
        onView(withId(R.id.edit_profile_button)).perform(click());
        onView(withId(R.id.profile_bio_edit)).perform(clearText());
        onView(withId(R.id.edit_profile_button)).perform(click());

        assertNotEquals(null, padelBuddy.getUser().getBiography());
    }
}