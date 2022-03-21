import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

public class Email {
   final static Logger logger = LoggerFactory.getLogger(Email.class);
   public Scanner sc = new Scanner(System.in);
   private String first_name;
   private String last_name;
   private String department;
   private String email;
   private String password;
   private int mailCapacity=500;
   private String alternateEmail;
   public Email(String first_name,String last_name){
      this.first_name=first_name;
      this.last_name=last_name;
      logger.info("\nNew Employee: "+this.first_name+" "+this.last_name);
      this.department=setDepartment.get();
      this.password=generatePassword.apply(8);
      this.email=this.generateEmail.get();
   }
   //generating email
   Supplier<String> generateEmail = ()->this.first_name.toLowerCase()+"."+
           this.last_name.toLowerCase()+"@"+this.department.toLowerCase()+".knoldus.com";

   //asking for department
   Supplier<String> setDepartment =()-> {
      logger.info("Department codes \n1 for sales \n2 for Development \n3 " +
              "for Accounting \n0 for none");
      boolean flag = false;
      do {
         logger.info("Enter Department Code");
         int choice = sc.nextInt();
         switch (choice) {
            case 1:
               return "sales";
            case 2:
               return "Development";
            case 3:
               return "Accounting";
            case 4:
               return "None";
            default:
               logger.info("Invalid choice please choose it again");
         }
      } while (!flag);
      return null;
   };

   //generate password
   Function<Integer,String>generatePassword =(length)-> {
      Random random = new Random();
      String capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      String small_chars = "abcdefghijklmnopqrstuvwxyz";
      String numbers = "0123456789";
      String symbols = "!@#$%&*?";
      String values = capital_chars + small_chars + numbers + symbols;
      StringBuilder password = new StringBuilder();
      for (int i = 0; i < length; i++) {
         password.append(values.charAt(random.nextInt(values.length())));
      }
      return password.toString();
   };
   //change your password
   Supplier<String>changePassword=()->{
      boolean flag=false;
      do{
         logger.info("Do you want to change your password! (Y/N)");
         char choice =sc.next().charAt(0);
         if(choice=='Y'||choice=='y'){
            flag=true;
            logger.info("Enter current Password:");
            String temp =sc.next();
            if(temp.equals(this.password)){
               logger.info("\nEnter new Password:");
               String type_password=sc.next();
               logger.info("\nEnter the password again");
               String retype_password=sc.next();
               if(retype_password.equals(type_password)){
                  this.password=retype_password;
                  return "Password changed successfully!";
               }
               else{
                  return "Password didn't match";
               }
            }else{
               return "Incorrect password";
            }
         }else if (choice=='N'||choice=='n'){
            flag=true;
            return "your password didn't changed";
         }
         else{
            return "Enter valid choice";
         }
      }while(!flag);
   };

   //change Mail  capacity
   Supplier<String>setMailCapacity=()->{
      logger.info("Current capacity= "+this.mailCapacity+"mb");
      logger.info("Enter new mailbox capacity: ");
      this.mailCapacity= sc.nextInt();
      return "mailbox capacity is successfully changed";
   };
   //set alternate mail
   Supplier<String> altEmail=()->{logger.info("Enter new alternate mail:");
      this.alternateEmail=sc.next();
      return  "Alternate email is set";
   };

   // display user information method
   Supplier<String> getUserInfo=()-> "\nUser: "+this.first_name+" "+this.last_name+
           "\nDepartment: "+this.department+"\nEmail: "+this.email+"\npassword: "+this.password+
           "\nMailbox capacity: "+this.mailCapacity+"mb"+"\nAlternate mail: "+alternateEmail;
}


