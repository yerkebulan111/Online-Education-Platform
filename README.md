# Online Education Platform

A Java-based Learning Management System (LMS) that demonstrates various design patterns and object-oriented programming principles.

## Features

- User registration and authentication
- Course enrollment with multiple levels (Beginner, Intermediate, Advanced)
- Course customization with decorators (Certification, Mentor Support, Gamification)
- Course modules and quizzes
- Progress tracking
- Course recommendations using strategy pattern
- Notification system
- Admin and Teacher roles

## Design Patterns Implemented

- **Builder Pattern**: UserBuilder for creating user objects
- **Factory Pattern**: CourseFactory for creating different types of courses (Math, Programming, Language)
- **Decorator Pattern**: CourseDecorator for adding features like Certification, Mentor Support, and Gamification
- **Facade Pattern**: StudentPortalFacade for simplifying student operations
- **Observer Pattern**: NotificationService for notifying users
- **Strategy Pattern**: RecommendationService for different recommendation algorithms
- **Adapter Pattern**: ProgressAdapter for displaying user progress

## Project Structure

```
src/
├── adapter/
│   └── ProgressAdapter.java
├── builder/
│   └── UserBuilder.java
├── course_builder/
│   ├── Course.java
│   ├── CourseBuilder.java
│   └── CourseModule*.java
├── course_levels/
│   ├── ICourseLevel.java
│   └── Level*.java
├── courses/
│   ├── ICourse.java
│   ├── math/
│   ├── programming/
│   └── language/
├── decorator/
│   ├── CertificateDecorator.java
│   ├── CourseDecorator.java
│   ├── GamificationDecorator.java
│   └── MentorSupportDecorator.java
├── facade/
│   └── StudentPortalFacade.java
├── factory/
│   ├── ICourseFactory.java
│   ├── MathCourseFactory.java
│   ├── ProgrammingCourseFactory.java
│   └── LanguageCourseFactory.java
├── observer/
│   └── NotificationService.java
├── strategy/
│   ├── RecommendationContext.java
│   ├── RecommendationService.java
│   ├── RecommendByActivity.java
│   └── RecommendByHistory.java
├── user/
│   ├── Admin.java
│   ├── IUser.java
│   ├── Teacher.java
│   ├── User.java
│   └── UserManager.java
├── Application.java
└── Main.java
```

## How to Run

1. Compile the project:
   ```bash
   javac -d . src/**/*.java src/*.java
   ```

2. Run the application:
   ```bash
   java Main
   ```

## Default Credentials

- **Admin**: username: `admin`, password: `admin`
- **Teacher**: username: `teacher`, password: `teacher`

## Usage

1. **Registration**: Create a new student account
2. **Login**: Use credentials to access the platform
3. **Enroll in Courses**: Choose from Algebra, Geometry, Java, Python, English, or Spanish
4. **Select Course Level**: Beginner, Intermediate, or Advanced
5. **Customize Course**: Add Certification, Mentor Support, or Gamification
6. **Choose Module**: Select from available course modules
7. **Get Recommendations**: Use strategy pattern to get course recommendations by history or activity
8. **Complete Courses**: Start courses, take tests, and complete them

## Course Types

- **Math Courses**: Algebra, Geometry
- **Programming Courses**: Java, Python
- **Language Courses**: English, Spanish

## User Roles

- **Student**: Can enroll in courses, view progress, and get recommendations
- **Teacher**: Can view students and grade assignments
- **Admin**: Can view all users and remove users

## Requirements

- Java JDK 8 or higher

