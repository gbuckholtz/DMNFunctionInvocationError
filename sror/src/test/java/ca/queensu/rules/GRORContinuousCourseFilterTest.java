package ca.queensu.rules;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import ca.queensu.beans.sror.tCourse;

public class GRORContinuousCourseFilterTest {

    @Test
    public void testFilterCourses_noCourses() {
        List<tCourse> courses = new ArrayList<>();
        List<tCourse> filteredCourses = GRORContinuousCourseFilter.filterCourses(courses, 2023.0);
        assertEquals(0, filteredCourses.size());
    }

    @Test
    public void testFilterCourses_singleCourseMatching() {
        List<tCourse> courses = new ArrayList<>();
        tCourse course1 = new tCourse();
        course1.setAcademicYearTaught(2022.0);
        courses.add(course1);

        List<tCourse> filteredCourses = GRORContinuousCourseFilter.filterCourses(courses, 2023.0);
        assertEquals(1, filteredCourses.size());
        assertEquals(course1, filteredCourses.get(0));
    }

    @Test
    public void testFilterCourses_singleCourseNotMatching() {
        List<tCourse> courses = new ArrayList<>();
        tCourse course1 = new tCourse();
        course1.setAcademicYearTaught(2021.0); // Ensure this is set correctly
        courses.add(course1);

        List<tCourse> filteredCourses = GRORContinuousCourseFilter.filterCourses(courses, 2023.0);
        assertEquals(0, filteredCourses.size());
    }

    @Test
    public void testFilterCourses_multipleCoursesContinuous() {
        List<tCourse> courses = new ArrayList<>();
        tCourse course1 = new tCourse();
        course1.setAcademicYearTaught(2022.0);
        tCourse course2 = new tCourse();
        course2.setAcademicYearTaught(2021.0);
        courses.add(course1);
        courses.add(course2);

        List<tCourse> filteredCourses = GRORContinuousCourseFilter.filterCourses(courses, 2023.0);
        assertEquals(2, filteredCourses.size());
        assertEquals(course1, filteredCourses.get(0));
        assertEquals(course2, filteredCourses.get(1));
    }

    @Test
    public void testFilterCourses_multipleCoursesWithGap() {
        List<tCourse> courses = new ArrayList<>();
        tCourse course1 = new tCourse();
        course1.setAcademicYearTaught(2022.0);
        tCourse course2 = new tCourse();
        course2.setAcademicYearTaught(2020.0);
        courses.add(course1);
        courses.add(course2);

        List<tCourse> filteredCourses = GRORContinuousCourseFilter.filterCourses(courses, 2023.0);
        assertEquals(1, filteredCourses.size());
        assertEquals(course1, filteredCourses.get(0));
    }

    @Test
    public void testFilterCourses_coursesInFuture() {
        List<tCourse> courses = new ArrayList<>();
        tCourse course1 = new tCourse();
        course1.setAcademicYearTaught(2024.0);
        tCourse course2 = new tCourse();
        course2.setAcademicYearTaught(2025.0);
        courses.add(course1);
        courses.add(course2);

        List<tCourse> filteredCourses = GRORContinuousCourseFilter.filterCourses(courses, 2023.0);
        assertEquals(0, filteredCourses.size());
    }
}