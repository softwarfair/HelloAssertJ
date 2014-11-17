package org.softwarfair.assertions;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.Data;
import lombok.Getter;

@Getter
public class Project {

    private final String name;

    /**
     * Map Key: true means is committer, false means is just committer (cannot accept pull request).
     *
     * NOTE: This bad design is just for the sake of the example
     */
    private final Multimap<Boolean, Developer> contributors;

    public Project(String name) {
        this.name = name;
        this.contributors = ArrayListMultimap.create();
    }

    public void approvePullRequest(Developer approver, String url) {
        if (!contributors.containsValue(approver)) {
            throw new IllegalArgumentException("Should be on the project to accept pull request");
        } else if (contributors.containsEntry(Boolean.FALSE, approver)) {
            throw new IllegalArgumentException("Should be committer to approve a pull request");
        } else {
            System.out.println(String.format("The pull request in %s will be approved", url));
        }
    }
}
