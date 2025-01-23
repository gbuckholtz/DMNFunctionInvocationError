package ca.queensu.rules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ca.queensu.beans.sror.tCourse;

public class GRORContinuousCourseFilter {

    public static List<tCourse> filterCourses(List<tCourse> courses, double currentYear) {
        // Sort the courses by academicYearTaught in descending order (most recent
        // first)
        Collections.sort(courses, new Comparator<tCourse>() {
            @Override
            public int compare(tCourse c1, tCourse c2) {
                return Double.compare(c2.getAcademicYearTaught(), c1.getAcademicYearTaught());
            }
        });

        List<tCourse> filteredCourses = new ArrayList<>();
        double expectedYear = currentYear - 1; // Start from the year before currentYear

        for (tCourse course : courses) {
            double academicYearTaught = course.getAcademicYearTaught();

            if (academicYearTaught == expectedYear) {
                // Add the course to the filtered list
                filteredCourses.add(course);
                expectedYear--; // Move to the previous year
            } else if (academicYearTaught < expectedYear) {
                // If there's a gap, stop processing further courses
                break;
            }
            // If the course is taught in a later year, skip it and continue
        }

        return filteredCourses;

    }
}