package adapter;

import user.IUser;

public class ProgressAdapter {
    private final IUser user;

    public ProgressAdapter(IUser currentUser) {
        this.user = currentUser;
    }

    public double getProgress() {
        double progress = 0;
        if ((user.getActiveCourses().size() + user.getCompletedCourses().size()) == 0){
            progress = 0.0;
            return progress;
        }
        progress = (double) user.getCompletedCourses().size() / (user.getActiveCourses().size() + user.getCompletedCourses().size()) * 100;
        return progress;
    }

    public String getProgressMessage() {
        return "You have completed " + getProgress() + "% of courses that you have ever enrolled";
    }
}
