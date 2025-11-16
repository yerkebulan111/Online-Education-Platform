package factory;

import course_levels.ICourseLevel;
import courses.ICourse;
import courses.programming.*;

public class ProgrammingCourseFactory implements ICourseFactory{
    @Override
    public ICourse createCourse(String type, ICourseLevel courseLevel) {
        switch (type.toLowerCase()) {
            case "java":
                return new JavaCourse(courseLevel);
            case "python":
                return new PythonCourse(courseLevel);
            default:
                throw new IllegalArgumentException("Unknown language course: " + type);
        }
    }
}
