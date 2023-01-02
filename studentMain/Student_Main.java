package studentMain;
import detalilsStudent.*;

import java.util.InputMismatchException;
import java.util.Scanner;




@SuppressWarnings("serial")
public class Student_Main extends Exception {
	public Student_Main(String msg){
		super(msg);
	}
	public static void main(String[] args)  {

		String rollno="",sname="",branch="",grade="";
		int sm1,sm2,sm3,sm4,sm5,sm6,totm=0;
		float sper;
		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter the no of Student");
			int n =Integer.parseInt(sc.nextLine());//3
			String sob[] = new String[n];
			for(int i=0;i<n;i++) {

				System.out.println("Enter "+(i+1)+" Student Roll Number:");
				rollno=sc.nextLine();

				if(rollno.length()!=10) {
					throw new Student_Main("Invalid Roll Number....");
				}
				System.out.println("Enter Name:");
				sname=sc.nextLine();
				System.out.println("Enter Branch:");
				branch=sc.nextLine();
				StdentBarnch sb = new StdentBarnch();
				if(!sb.verifybracnh(branch)) {
					throw new Student_Main("Invalid Branch....!!");
				}
				Integer[] marksob = new Integer[6];


				for (int j = 0; j < marksob.length; j++) {
					System.out.println("Enter Marks["+(j+1)+"] Student marks:");
					marksob[j]=Integer.parseInt(sc.nextLine());
				}

				for (int j = 0; j < marksob.length; j++) {
					if(!(marksob[j]>0&&marksob[j]<=100)) {
						throw new Student_Main("Invalid Students...marks..");
					}
					totm+=marksob[j];
				}


				Student_per sp = new Student_per();
				sper=sp.calPer(totm);//400
				StudentGrade sg = new StudentGrade();
				grade=sg.calgrd(sper);

				sob[i]=sname+" \t| "+ rollno+" \t| "+branch+" \t\t| "+totm+" \t\t| "+sper+" \t\t| "+grade;
				totm=0;
				sper=0;

			}//end of loop
			System.out.println("\nStudents destils are : \n");
			System.out.println("________________________________________");
			System.out.println("Name \t| RollNo \t| Branch \t| TotalAmont\t| Percent \t| grade;");
		for (String k: sob) {
			System.out.println(k);

		}
		}//end of try
		catch (Student_Main|NumberFormatException|InputMismatchException e) {
			if(e.getMessage().equals("")) {
				e.printStackTrace();
			}
			System.out.println("Exception - "+e.getMessage());
		}

		
	}

}
