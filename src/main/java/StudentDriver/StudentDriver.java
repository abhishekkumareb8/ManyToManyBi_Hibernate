package StudentDriver;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanybidto.Course;
import manytomanybidto.Student;

public class StudentDriver {

	public static void main(String[] args) {

		Student student = new Student();
		student.setId(1);
		student.setName("Abhishek");
		student.setPhone(8735);

		Student student1 = new Student();
		student1.setId(2);
		student1.setName("Kartik");
		student1.setPhone(865);

		Student student2 = new Student();
		student2.setId(3);
		student2.setName("Rishabh");
		student2.setPhone(1342);

		Course course = new Course();
		course.setId(101);
		course.setName("Java");

		Course course1 = new Course();
		course1.setId(102);
		course1.setName("Adv Java");

		Course course2 = new Course();
		course2.setId(103);
		course2.setName("HTML");

		List<Course> c = new ArrayList<Course>();
		c.add(course2);
		c.add(course);
		student.setCourses(c);

		List<Course> c1 = new ArrayList<Course>();
		c1.add(course2);
		c1.add(course1);
		student1.setCourses(c1);

		List<Course> c2 = new ArrayList<Course>();
		c2.add(course1);
		c2.add(course);
		c2.add(course2);
		student2.setCourses(c2);

		List<Student> s = new ArrayList<Student>();
		s.add(student);
		s.add(student2);
		course.setStudents(s);

		List<Student> s2 = new ArrayList<Student>();
		s2.add(student1);
		s2.add(student2);
		course1.setStudents(s2);

		List<Student> s3 = new ArrayList<Student>();
		s3.add(student1);
		s3.add(student2);
		s3.add(student);
		course2.setStudents(s3);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(course);
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(student);
		entityManager.persist(student1);
		entityManager.persist(student2);

		entityTransaction.commit();

	}

}
