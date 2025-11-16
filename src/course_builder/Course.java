package course_builder;

import course_levels.ICourseLevel;
import courses.ICourse;

public class Course {
    private final String courseName;
    private final String courseLevel;
    private final String module;
    private final boolean quizzed;
    private final ICourse course;

    public Course(ICourse course,String courseName, String courseLevel, String module, boolean quizzed) {
        this.course = course;
        this.courseName = courseName;
        this.courseLevel = courseLevel;
        this.module = module;
        this.quizzed = quizzed;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseLevel() {
        return courseLevel;
    }

    public String getModule() {
        return module;
    }

    public boolean getQuizzed() {
        return quizzed;
    }

    public ICourse getCourse() {
        return course;
    }

    public String info() {
        return "Course{name: " + courseName +", level: " + courseLevel + ", module: " + module  + ", quizzed: " + quizzed + "}";
    }
}
