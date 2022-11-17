package org.student;

import org.department.Department;

public class Student extends Department{
public void studentName() {
System.out.println("Student Name: Bhavadharani S");
}
public void studentDept() {
System.out.println("Student Dept: CT");
}
public void studentId() {
System.out.println("Student Id: 17BCT108");
}
public static void main(String[] args) {
	Student st = new Student();
	st.collegeName();
	st.collegeCode();
	st.collegeRank();
	st.departmentName();
	st.studentName();
	st.studentDept();
	st.studentId();
}
}
//Methods   :studentName(),studentDept(),studentId()
//
//Description:
//create above 3 class and call all your class methods into the Student using multilevel inheritance.