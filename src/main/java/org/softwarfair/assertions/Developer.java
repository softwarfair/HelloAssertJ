package org.softwarfair.assertions;

import lombok.Data;
import lombok.experimental.Builder;
import org.joda.time.DateTime;
import org.joda.time.Years;

@Builder
@Data
public class Developer {
    private final String name;
    private final DateTime birthday;

    public int age() {
        return Years.yearsBetween(birthday, DateTime.now()).getYears();
    }
}
