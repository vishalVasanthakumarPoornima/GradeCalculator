import java.util.*;

public class NewClass {

    private static int validateGradeInput(Scanner scanner) {
        while (true) {
            try {
                int grade = Integer.parseInt(scanner.nextLine());
                if (grade >= 0 && grade <= 100) {
                    return grade;
                } else {
                    System.out.print("Invalid input. Please enter a grade between 0 and 100: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter an integer: ");
            }
        }
    }

    private static int findHighestNumber(ArrayList<Integer> numbers) {
        int max = numbers.get(0); // Assume the first element is the maximum
        for (int i = 1; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            if (currentNumber > max) {
                max = currentNumber;
            }
        }
        return numbers.indexOf(max);
    }

    private static int findLowestNumber(ArrayList<Integer> numbers) {
        int min = numbers.get(0); // Assume the first element is the minimum
        for (int i = 1; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            if (currentNumber < min) {
                min = currentNumber;
            }
        }
        return numbers.indexOf(min);
    }

    public static void main(String[] args) {
        ArrayList<Integer> grades = new ArrayList<Integer>(); // Create an ArrayList object
        ArrayList<String> names = new ArrayList<String>(); // Create an ArrayList object

        System.out.println("Welcome to Grade Calculator \nPlease enter the number of students you want to calculate the average of (MAX: 9) :");
        Scanner obj = new Scanner(System.in);
        //Welcome & introduction message
        int numberOfStudents = obj.nextInt();
        //Stores the number of students
        while (numberOfStudents < 1 || numberOfStudents > 9) {
            if (numberOfStudents < 1) {
                System.out.println("Number too small please enter a number larger than 0");
                numberOfStudents = obj.nextInt();
            } else {
                System.out.println("Number too big please enter a number less than 10");
                numberOfStudents = obj.nextInt();
            }
        }
        obj.nextLine();
        //Makes sure that the number of students is a positive integer that is less than 10;
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter the name of student: ");
            String name = obj.nextLine();
            names.add(name);

            System.out.println("Enter the grade of student: ");
            int grade = validateGradeInput(obj);
            grades.add(grade);
        }
        //Add the validated grades into the ArrayList grades
        //Makes sure that the number of students is a positive integer that is less than 10;
        boolean exit = true;
        while (exit) {
            System.out.println("\nChoose what you would like to do with student grade calculator \n1. Calculate Average \n2. Check Student Grade \n3. Exit");
            int userChoice = obj.nextInt();
            int sum = 0;
            switch (userChoice) {
                case 1: {
                    for (int i = 0; i < grades.size(); i++) {
                        sum += grades.get(i);
                    }
                    double avg = (double) sum / grades.size();
                    System.out.printf("The average is: %.2f", avg);
                    System.out.println("");
                    System.out.println("The student with the highest grade is: " + names.get(findHighestNumber(grades)));
                    System.out.println("The student with the lowest grade is: " + names.get(findLowestNumber(grades)));

                    break;
                }
                //case 1 will traverse through grades and add it to a sum
                //It will then calculate the average
                case 2: {
                    System.out.println("Enter the name of the Student");
                    boolean out = true;
                    while (out) {
                        String Name = obj.nextLine();
                        int gradeIndex = names.indexOf(Name);
                        if (gradeIndex < 0) {
                            System.out.println("Please enter a vaild Student");
                        } else {
                            System.out.println("The Grade is: "+grades.get(gradeIndex));
                            out = false;
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("Thank You for using Grade Calculator!!");
                    exit = false;
                    break;
                }
                //Case 3 quits the calculator if user enters 3
                default: {
                    System.out.println("Please choose a Vaild Option from the Menu");
                    break;
                }
                //the default case will prompt an error message if the user doesn't choose a valid option
            }

        }
        //This while loop will ensure that the user can perform multiple calculations without leaving the menu
    }
}

