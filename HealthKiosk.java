
import java.util.Random;
import java.util.Scanner;

public class HealthKiosk {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("welcome  to Ashesi health Kiosk");
      
        System.out.print("Enter service code (P/L/T/C): ");
        char code = input.next().charAt(0);
        code = Character.toUpperCase(code);


        String service = "";
        switch (code) {
            case 'P':
                service = "Pharmacy";
                System.out.println("Go to: Pharmacy Desk");
                break;
             case 'L':
                service = "Lab";
                System.out.println("Go to: Lab Desk");
                break;
            case 'T':
                service = "Triage";
                System.out.println("Go to: Triage Desk");
                break;
          case 'C':
                service = "Counseling";
                System.out.println("Go to: Counseling Desk");
                break;
            default:
                System.out.println("Invalid service code");
                
        }

       


       // 2)
      
        double metricValue = 0;  // i declared these variables  to hold the results from each calculation for later use.
        double bmi = 0;   // same as thi bmi variable

        if (service.equals("Triage")) {
            System.out.println("Select health metric: 1=BMI, 2=Dosage, 3=Trig Helper");
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.print("Enter weight(kg): ");
                double weight = input.nextDouble();
                System.out.print("Enter height(m): ");
                double height = input.nextDouble();

                bmi = weight / Math.pow(height, 2);
                double roundedBMI = Math.round(bmi * 10) / 10.0;
                metricValue = Math.round(bmi); 

                System.out.print("BMI: " + roundedBMI + "  Category: ");
                if (roundedBMI < 18.5) {
                    System.out.println("Underweight");
                } 
                else if (roundedBMI <= 24.9) {
                    System.out.println("Normal");
                } else if (roundedBMI <= 29.9) {
                    System.out.println("Overweight");
                } 
                else {
                    System.out.println("Obese");
                }
                bmi = roundedBMI;
            }
            else if (choice == 2) {
                System.out.print("Enter required dosage (mg): ");
                double dosage = input.nextDouble();
                double tablets = Math.ceil(dosage / 250.0);
                metricValue = (int) tablets; 
                System.out.println("Tablets needed: " + (int) tablets);
            }
            else if (choice == 3) {
                System.out.print("Enter angle in degrees: ");
                double angle = input.nextDouble();
                double radians = Math.toRadians(angle);
                double sin = Math.round(Math.sin(radians) * 1000) / 1000.0;
                double cosine = Math.round(Math.cos(radians) * 1000) / 1000.0;
                System.out.println("sin = " + sin + "  cos = " + cosine);
                metricValue = Math.round(Math.sin(radians) * 100); 
            }
        }

        // Task 3 
     
        char randomChar = (char) ('A' + rand.nextInt(26));
        int d1 = rand.nextInt(7) + 3; 
        int d2 = rand.nextInt(7) + 3;
        int d3 = rand.nextInt(7) + 3;
        int d4 = rand.nextInt(7) + 3;

        String shortID = "" + randomChar + d1 + d2 + d3 + d4;
        System.out.println("Generated ID: " + shortID);

        if (shortID.length() != 5) {
            System.out.println("Invalid length");
        } 
        else if (!Character.isLetter(shortID.charAt(0))) {
            System.out.println("the First character should be a letter");
        }
         else if (!(Character.isDigit(shortID.charAt(1)) &&Character.isDigit(shortID.charAt(2)) &&Character.isDigit(shortID.charAt(3)) &&
                     Character.isDigit(shortID.charAt(4)))) {
            System.out.println("last 4 must be digits");
        } 
        else {
            System.out.println("the ID is valid");
        }

        // 4 - task ,
      
        System.out.print("Enter your first name: ");
        String firstName = input.next();
        char baseCode = Character.toUpperCase(firstName.charAt(0));
        char shifted = (char) ('A' + (baseCode - 'A' + 2) % 26);
        String lastTwo = shortID.substring(3, 5); 
        String display = shifted + lastTwo + "-" + (int) metricValue;
        System.out.println("Display Code: " + display);

      
        // Task 5.
      
        String summary = "";

        switch (code) {
            case 'P':
                summary = "PHARMACY | ID=" + shortID + " | Code=" + display;
                break;
            case 'L':
                summary = "LAB | ID=" + shortID + " | Code=" + display;
                break;
            case 'T':
                if (bmi > 0) {
                    summary = "TRIAGE | ID=" + shortID + " | BMI=" + bmi + " | Code=" + display;
                } 
                else {
                    summary = "TRIAGE | ID=" + shortID + " | Code=" + display;
                }
                break;
            case 'C':
                summary = "COUNSELING | ID=" + shortID + " | Code=" + display;
                break;
        }

        System.out.println(summary);

        input.close();
    }
}

