import java.util.List;
import java.util.ArrayList;

public class Course {

  /* Here are my exceptions, because I really don't like having 2 files just for two exceptions... */
  /* I'm sorry if this ain't "proper code", but in d) the aufgabenzettel does the same :^} */
  public static class CourseFullException extends Exception
  {
    public CourseFullException(int maxStudents)
    {
      super("Course is already full! There can only participate "+ maxStudents + " Students. The student was not added.");
    }
  }
  public static class StudentAlreadyEnrolledException extends Exception
  {
    public StudentAlreadyEnrolledException(String studentName)
    {
      super("The Student \"" + studentName + "\" already participates in this course. He has not been added again.");
    }
  }


  /* Actual Course-Code */

  private List<String> students = new ArrayList<>();
  private static final int MAX_STUDENTS = 2;

  public void addStudent(String student) throws CourseFullException, StudentAlreadyEnrolledException {
    if (students.size() >= MAX_STUDENTS) {
      throw new CourseFullException(students.size());
    }
    if (students.contains(student)) {
      throw new StudentAlreadyEnrolledException(student);
    }
    students.add(student);
  }

  public static void main(String[] args) {
    Course course = new Course();
    List<String> students = new ArrayList<>();
    students.add("Donald Duck");
    students.add("Donald Duck");
    students.add("Uncle Scrooge");
    students.add("Gyro Gearloose");

    for (String student : students) {
      try
      {
        course.addStudent(student);
        System.out.println("Successfully added " + student);
      }
      catch (CourseFullException ex)
      {
        System.out.println(ex.getMessage());
      }
      catch (StudentAlreadyEnrolledException ex)
      {
        System.out.println(ex.getMessage());
      }
    }
  }
}
