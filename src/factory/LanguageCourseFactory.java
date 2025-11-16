package factory;

import course_levels.ICourseLevel;
import courses.ICourse;
import courses.language.*;

public class LanguageCourseFactory implements ICourseFactory{
    @Override
    public ICourse createCourse(String type, ICourseLevel courseLevel) {
        switch (type.toLowerCase()) {
            case "english":
                return new EnglishCourse(courseLevel);
            case "spanish":
                return new SpanishCourse(courseLevel);
            default:
                throw new IllegalArgumentException("Unknown language course: " + type);
        }
    }
}
