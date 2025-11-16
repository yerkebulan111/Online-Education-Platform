package factory;

import course_levels.ICourseLevel;
import courses.ICourse;

public interface ICourseFactory {
    ICourse createCourse(String type, ICourseLevel courseLevel);
}
