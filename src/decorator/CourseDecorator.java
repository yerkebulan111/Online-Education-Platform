package decorator;

import course_levels.ICourseLevel;
import courses.ICourse;

public abstract class CourseDecorator implements ICourse {
    private final ICourse wrapped;

    public CourseDecorator(ICourse wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void deliverContent() {
        wrapped.deliverContent();
    }


    @Override
    public String info() {
        return wrapped.info();
    }

    @Override
    public String getName() {
        return wrapped.getName();
    }

    @Override
    public void setCourseLevel(ICourseLevel courseLevel) {
        wrapped.setCourseLevel(courseLevel);
    }

    @Override
    public String getCourseLevel() {
        return wrapped.getCourseLevel();
    }

    @Override
    public void setAsStarted() {
        wrapped.setAsStarted();
    }

    @Override
    public boolean isStarted() {
        return wrapped.isStarted();
    }

    @Override
    public void test() {
        wrapped.test();
    }

    @Override
    public boolean isTestCompleted() {
        return wrapped.isTestCompleted();
    }
}
