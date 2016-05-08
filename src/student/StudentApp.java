package student;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Display reminders of students having a birthday soon.
 * @author you
 */
public class StudentApp {

	/**
	 * Print the names (and birthdays) of students having a birtday in the
	 * specified month.
	 * @param students list of students
	 * @param month the month to use in selecting bithdays
	 */
	public void filterAndPrint( List<Student> students, Predicate<Student> filter, Consumer<Student> action, Comparator<Student> comparator) {
		students.stream().filter(filter).sorted(comparator).forEach(action);
		for(Student student : students ) {
			if (filter.test(student))
				action.accept(student);
		}
	}
	
	 
	
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		List<Student> 		students 	= Registrar.getInstance().getStudents();
		Predicate<Student> 	filter 		= (x) -> x.getBirthdate().getMonthValue() != LocalDate.now().getMonthValue();
		Consumer<Student>	action      = (x) -> System.out.println(x.getFirstname()+" will have birthday on "+x.getBirthdate());
		Comparator<Student> byName 		= (a, b) -> a.getFirstname().charAt(0) - b.getFirstname().charAt(0);
		Comparator<Student> byBirthday = (a, b) -> a.getBirthdate().getDayOfMonth() - b.getBirthdate().getDayOfMonth();
		
		StudentApp app = new StudentApp();
		app.filterAndPrint(students, filter, action, byBirthday );
	}
}
