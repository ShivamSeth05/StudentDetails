package detalilsStudent;

public class StudentGrade {
	public String calgrd(float per) {
		if(per>=70)return"A";
		else if(per>=60)return"B";
		else if(per>=50)return"C";
		else if(per>=35)return"D";
		else return "fail";
	}

}
