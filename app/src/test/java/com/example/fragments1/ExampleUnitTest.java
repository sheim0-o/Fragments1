package com.example.fragments1;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExampleUnitTest {

    public void TestEmail()
    {
        assertThat(Utility.isEmail("misha@mail.ru"), is(true));
    }

    public void TestNotEmail()
    {
        assertThat(Utility.isEmail("misha"), is(false));
    }

    public void TestNullEmail()
    {
        assertThat(Utility.isEmail(null), is(false));
    }

    public void TestEmptyEmail()
    {
        assertThat(Utility.isEmail(""), is(false));
    }

    public void TestDoubleMonkeyEmail()
    {
        assertThat(Utility.isEmail("@@"), is(false));
    }
}