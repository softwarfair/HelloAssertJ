package com.softwarfair.assertions;

import org.joda.time.DateTime;
import org.softwarfair.assertions.Developer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.jodatime.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

public class DeveloperTest {

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
        assertThat(odersky.getBirthday())
                .isBefore(DateTime.now())
                .isEqualTo("1958-09-05");
    }

    @Test
    public void test_name() throws Exception {
        assertThat(odersky.getName())
                .startsWith("Martin")
                .endsWith("y");
    }

    @Test
    public void test_age() throws Exception {
        assertThat(odersky.age())
                .isGreaterThan(50)
                .isBetween(55, 80)
                .isNotZero()
                .isPositive();
    }
}
