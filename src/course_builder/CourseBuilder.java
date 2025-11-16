package course_builder;

import course_levels.ICourseLevel;
import courses.ICourse;

public class CourseBuilder {
    private String courseName;
    private String courseLevel;
    private CourseModule module;
    private boolean quizzed;
    private ICourse course;

    public CourseBuilder setCourse(ICourse course) {
        this.course = course;
        courseName = course.getName();
        courseLevel = course.getCourseLevel();
        return this;
    }

    public CourseBuilder setCourseModule(CourseModule module) {
        this.module = module;
        return this;
    }

    public CourseBuilder isQuizzed(boolean quizzed) {
        this.quizzed = quizzed;
        return this;
    }

    public Course build(){
        return new Course(course, courseName, courseLevel, module.getName(), quizzed);
    }
}
