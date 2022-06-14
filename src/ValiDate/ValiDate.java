package ValiDate;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ValiDate {
    Scanner input = new Scanner(System.in);


    public int importInt(String a) {
        try {
            System.out.println("Enter " + a);
            int b = Integer.parseInt(input.nextLine());
            return b;
        } catch (Exception e) {
            System.out.println("Enter wrong, please try again by number");
            return importInt(a);
        }
    }

    public double importDouble(String a) {
            try {
                System.out.println("Enter " + a);
                double b = Double.parseDouble(input.nextLine());
                return b;
            }
            catch (Exception e){
                System.out.println("Enter wrong, please try again. ex: 5.05");
                return importDouble(a);

            }
        }


    public String importString(String a) {
                System.out.println("Enter " + a);
                String b = input.nextLine();
                if (b.equals("")){
                    System.out.println(a + "is not been entered, please try again.");
                    return importString(a);
                } else {
                    return b;
                }
    }

    public int choice1(String a) {
            try {
                System.out.println("Enter " + a + " from 1 to 9");
                int b = Integer.parseInt(input.nextLine());
                if (b>0 || b<10) {
                    return b;
                } else {
                    return choice1(a);
                }
            }
            catch (Exception e){
                System.out.println("Enter wrong, please try again.");
                return importInt(a);
            }
    }

    public int choice2(String a) {
        try {
            System.out.println("Enter " + a + " from 1 to 2");
            int b = Integer.parseInt(input.nextLine());
            if (b>0 || b<3) {
                return b;
            } else {
                return choice2(a);
            }
        }
        catch (Exception e){
            System.out.println("Enter wrong, please try again.");
            return importInt(a);
        }
    }

}