package com.softwarfair.assertions;

import org.hamcrest.Matchers;
import org.joda.time.DateTime;
import org.joda.time.ReadableInstant;
import org.softwarfair.assertions.Developer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.joda.time.DateTime.now;

public class DeveloperTestOldStyle {

    private Developer odersky;

    @BeforeMethod
    public void setUp() throws Exception {
        odersky = Developer.builder()
                .name("Martin Odersky")
                .birthday(DateTime.parse("1958-09-05"))
                .build();
    }

    @Test
    public void test_birthdate() throws Exception {
        assertThat(odersky.getBirthday(), Matchers.<ReadableInstant>lessThan(now()));
        assertThat(odersky.getBirthday(), Matchers.equalTo(DateTime.parse("1958-09-05")));
    }

    @Test
    public void test_name() throws Exception {
        assertThat(odersky.getName(), startsWith("Martin"));
        assertThat(odersky.getName(), endsWith("y"));
    }

    @Test
    public void test_age() throws Exception {
        assertThat(odersky.age(), greaterThan(50));
        assertThat(odersky.age(), greaterThan(55));
        assertThat(odersky.age(), lessThan(80));
        assertThat(odersky.age(), not(0));
        assertThat(odersky.age(), greaterThan(0));
    }
}
