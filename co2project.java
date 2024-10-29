import java.util.*;
public class co2project {
   
        public static void main(String[] args) {
            EnrollmentSystem enrollmentSystem = new EnrollmentSystem();
    
            // Adding Students
            enrollmentSystem.addStudent("S1", "Alice");
            enrollmentSystem.addStudent("S2", "Bob");
    
            // Adding Courses
            enrollmentSystem.addCourse("C1", "Math");
            enrollmentSystem.addCourse("C2", "Science");
    
            // Enrolling Students in Courses
            enrollmentSystem.enrollStudentInCourse("S1", "C1");
            enrollmentSystem.enrollStudentInCourse("S2", "C1");
            enrollmentSystem.enrollStudentInCourse("S1", "C2");
    
            // Displaying enrolled courses for a student
            System.out.println("Courses enrolled by Alice: " + enrollmentSystem.getStudentCourses("S1"));
            // Displaying enrolled students for a course
            System.out.println("Students enrolled in Math: " + enrollmentSystem.getCourseStudents("C1"));
        
    }
    
}

// Student Class
class Student {
    private String id;
    private String name;
    private Set<String> enrolledCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.enrolledCourses = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollCourse(String courseId) {
        enrolledCourses.add(courseId);
    }
}

// Course Class
class Course {
    private String courseId;
    private String courseName;
    private Set<String> enrolledStudents;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.enrolledStudents = new HashSet<>();
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Set<String> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent(String studentId) {
        enrolledStudents.add(studentId);
    }
}

// Enrollment System Class
class EnrollmentSystem {
    private Map<String, Student> students;
    private Map<String, Course> courses;

    public EnrollmentSystem() {
        students = new HashMap<>();
        courses = new HashMap<>();
    }

    public void addStudent(String id, String name) {
        students.put(id, new Student(id, name));
    }

    public void addCourse(String courseId, String courseName) {
        courses.put(courseId, new Course(courseId, courseName));
    }

    public void enrollStudentInCourse(String studentId, String courseId) {
        Student student = students.get(studentId);
        Course course = courses.get(courseId);
        
        if (student != null && course != null) {
            student.enrollCourse(courseId);
            course.enrollStudent(studentId);
        } else {
            System.out.println("Invalid student or course ID.");
        }
    }

    public Set<String> getStudentCourses(String studentId) {
        Student student = students.get(studentId);
        return (student != null) ? student.getEnrolledCourses() : null;
    }

    public Set<String> getCourseStudents(String courseId) {
        Course course = courses.get(courseId);
        return (course != null) ? course.getEnrolledStudents() : null;
    }
}


