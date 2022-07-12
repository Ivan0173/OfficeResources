package com.company.officeresources2.app;

import java.time.LocalDateTime;

public final class DataComparator {
    private DataComparator() {}
    public static boolean isBetween(LocalDateTime dateStart1, LocalDateTime dateEnd1, LocalDateTime dateStart2, LocalDateTime dateEnd2) {
        return isBetween(dateStart1, dateStart2, dateEnd2) ||
                isBetween(dateEnd1, dateStart2, dateEnd2) ||
                isBetween(dateStart2, dateStart1, dateEnd1) ||
                isBetween(dateEnd2, dateStart1, dateEnd1);
    }
    public static boolean isBetween(LocalDateTime date, LocalDateTime dateStart, LocalDateTime dateEnd) {
        return !date.isBefore(dateStart) && !date.isAfter(dateEnd);
    }
}
