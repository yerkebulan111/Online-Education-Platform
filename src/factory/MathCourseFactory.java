package factory;

import course_levels.ICourseLevel;
import courses.ICourse;
import courses.math.*;

public class MathCourseFactory implements ICourseFactory{
    @Override
    public ICourse createCourse(String type, ICourseLevel courseLevel) {
        switch (type.toLowerCase()) {
            case "algebra":
                return new AlgebraCourse(courseLevel);
            case "geometry":
                return new GeometryCourse(courseLevel);
            default:
                throw new IllegalArgumentException("Unknown language course: " + type);
        }
    }
}
