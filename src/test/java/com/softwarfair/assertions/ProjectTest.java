package com.softwarfair.assertions;

import org.softwarfair.assertions.Developer;
import org.softwarfair.assertions.Project;
import org.testng.annotations.Test;

import static org.assertj.guava.api.Assertions.assertThat;
import static org.assertj.guava.api.Assertions.entry;

public class ProjectTest {
    @Test
    public void contribute() throws Exception {
        Project scala = new Project("Scala");
        Developer one = Developer.builder().name("First").build();
        Developer two = Developer.builder().name("Second").build();
        scala.getContributors().put(Boolean.FALSE, one);
        scala.getContributors().put(Boolean.FALSE, two);

        Developer odersky = Developer.builder().name("Martin Ordersky").build();
        scala.getContributors().put(Boolean.TRUE, odersky);

        assertThat(scala.getContributors())
                .containsValues(one, two, odersky)
                .containsKeys(Boolean.FALSE, Boolean.TRUE)
                .contains(entry(Boolean.TRUE, odersky))
                .hasSize(3);
    }
}
