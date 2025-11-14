package courses;

import course_levels.ICourseLevel;

public interface ICourse {
    String getName();
    void deliverContent();
    String info();

    void setCourseLevel(ICourseLevel courseLevel);
    String getCourseLevel();
    //    void makeProgress();
//    double getProgress();
    void setAsStarted();
    boolean isStarted();

    void test();
    boolean isTestCompleted();
}
