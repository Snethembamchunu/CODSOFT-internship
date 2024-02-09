package Codsoft_task2_Calculator;
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects you are taking: ");
        int TotalNoOfSubjects = scanner.nextInt();
        int[] subjectMarks= new int[TotalNoOfSubjects]; //intitailising an array to store the number of subjects taken
        int TotalMarks= 0;
 
        //enter the no. of subjects, and it will determine how many times you can enter value based on subjects u are taking.
        for(int s=0; s<TotalNoOfSubjects; s++){
            System.out.printf("Enter marks for subject : ", s +  1);
            subjectMarks[s]=scanner.nextInt();//s is position in the array. we use nextInt because our array only contains integers

            TotalMarks += subjectMarks[s];//it adds the marks in the position of the array
        }

        scanner.close();

        float AveragePercentage = (float)TotalMarks / TotalNoOfSubjects;
        char StudentGrade= calculaGrade(AveragePercentage); //we use char coz we are assigning grade based on average percentage. we are calling the calculateGrade method we made below
        
        System.out.println("Total Marks:" + TotalMarks);
        System.out.println("Average Percentage:" + AveragePercentage);
        System.out.println("Grade:" + StudentGrade );
    }

    //Declaring a method that will calculate grade based on average percentage
    private static char calculaGrade(float AveragePercentage){
        if (AveragePercentage >=  80) {
            return 'A';
        } else if (AveragePercentage >=  65) {
            return 'B';
        } else if (AveragePercentage >=  45) {
            return 'C';
        } else {
            return 'D';
        } 
    }
}
