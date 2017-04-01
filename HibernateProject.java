import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.hibernate.proj.entity.Address;
import com.hibernate.proj.entity.Course;
import com.hibernate.proj.entity.HibernateUtil;
import com.hibernate.proj.entity.SCMapping;
import com.hibernate.proj.entity.Student;
import com.hibernate.proj.entity.User;

public class HibernateProject {

	public static void main(String[] args) throws IOException {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		session.beginTransaction();
	
		String string;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int choice;
		int stuId;
		System.out.println("1. Enter Data");
		System.out.println("2. View Data");
		System.out.println("Enter a choice from the above: ");
		choice = Integer.parseInt(br.readLine());
		String ch = "Y";
		int cId;
		
		switch(choice){
		case 1: Student st = new Student();
				System.out.println("Enter First Name: ");
				string = br.readLine();
				st.setFirstName(string);
				System.out.println("Enter Last Name: ");
				string = br.readLine();
				st.setLastName(string);
				System.out.println("Enter Date of Birth(MM/DD/YYYY): ");
				string = br.readLine();
				st.setDob(string);
				System.out.println("Enter Gender: ");
				string = br.readLine();
				st.setGender(string);
				
				session.save(st);
				stuId = st.getStudentId();
				
				Address add = new Address();
				System.out.println("Enter Address: ");
				string = br.readLine();
				add.setAddress(string);
				System.out.println("Enter Country: ");
				string = br.readLine();
				add.setCountry(string);
				System.out.println("Enter Zipcode: ");
				string = br.readLine();
				add.setZip(string);
				add.setStudent(st);
				
				session.save(add);
				
				Criteria criteria = session.createCriteria(Course.class);
				List<Course> c = criteria.list();
				
				System.out.println("Following courses are available: ");
				for(Course course : c){
					System.out.println(course.getCourseId() + " " + course.getCourseName());
				}
				
				
				while(ch.equals("Y")){
					System.out.println("Enter Course Id: ");
					cId = Integer.parseInt(br.readLine());
					Course cc = new Course();
					cc = (Course) session.get(Course.class, cId);
					SCMapping mapp = new SCMapping();
					mapp.setStudentMap(st);
					mapp.setCourseMap(cc);
					session.save(mapp);
					System.out.println("Do you want to enter more courses(Y/N):");
					ch = br.readLine();
				}
				System.out.println("Your student Id is: " + stuId);
				break;
				
		case 2: System.out.println("Enter Student Id: ");
				cId = Integer.parseInt(br.readLine());
				Query query = session.createQuery("select A from Student as A inner join A.addressList");
				List<Student> stu = query.list();
				for(Student stud : stu){
					if(stud.getStudentId().equals(cId)){
						System.out.println("Student Name: " + stud.getFirstName() + " " + stud.getLastName());
						System.out.println("Date of Birth: " + stud.getDob());
						System.out.println("Gender: " + stud.getGender());
						System.out.println("Address: " + stud.getAddressList().get(0).getAddress());
						System.out.println("Country: " + stud.getAddressList().get(0).getCountry());
						System.out.println("Zipcode: " + stud.getAddressList().get(0).getZip());
					}
				}
				query = session.createQuery("select A from Student as A inner join A.studentMapList");
				List<Student> stuMap = query.list();
				int i=0;
				for(Student stuM : stuMap){
					
					if(stuM.getStudentId().equals(cId)){
						
						System.out.println("Registration Id: " + stuM.getStudentMapList().get(i).getRegId());
						System.out.println("Course Id: " + stuM.getStudentMapList().get(i).getCourseMap().getCourseId());
						System.out.println("Course Name: " + stuM.getStudentMapList().get(i).getCourseMap().getCourseName());
						System.out.println("Course Semester: " + stuM.getStudentMapList().get(i).getCourseMap().getSemester());
						System.out.println("Course Location: " + stuM.getStudentMapList().get(i).getCourseMap().getLocation());
						i++;
					}
				}
			
				break;
		}
		
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Exit");
	}

}
