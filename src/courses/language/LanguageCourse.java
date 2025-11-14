package courses.language;

import course_levels.ICourseLevel;
import courses.ICourse;

public abstract class LanguageCourse implements ICourse {
    private ICourseLevel courseLevel;
    private boolean isStarted = false;

    public LanguageCourse(ICourseLevel courseLevel) {
        setCourseLevel(courseLevel);
    }

    @Override
    public String getCourseLevel() {
        return courseLevel.getLevelName();
    }

    @Override
    public void setCourseLevel(ICourseLevel courseLevel) {
        this.courseLevel = courseLevel;
    }


    @Override
    public void setAsStarted() {
        isStarted = true;
    }

    @Override
    public boolean isStarted() {
        return isStarted;
    }


}
