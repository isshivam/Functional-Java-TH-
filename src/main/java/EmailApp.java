import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class EmailApp {
    final static Logger logger = LoggerFactory.getLogger(EmailApp.class);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //user info
        logger.info("Enter your first name");
        String first_name=sc.next();
        logger.info("Enter your last name");
        String last_name=sc.next();
        //creating object for  Email class
        Email email = new Email(first_name,last_name);
        int choice=-1;
        do{
            /*
             * enter 1-> to show all your details like your emails ,password ,mailbox capacity,alternate email and so on
             * enter 2-> If you want to change your password
             * enter 3 -> If you want to change mailbox capacity(either default capacity 500MB will be allocated)
             * enter 4 -> If you want to set an Alternate email for your mail
             * enter 5 -> If you want to close application
             */
            logger.info("\n*********\nEnter your choice\n1.Show Info\n2.Change Password\n3.Change mailbox capacity\n4.set Alternate mail\n5.Exit");
            choice =sc.nextInt();
            switch (choice){
                case 1:
                    logger.info( email.getUserInfo.get());
                    break;
                case 2:
                    logger.info( email.changePassword.get());
                    break;
                case 3:
                    logger.info(email.setMailCapacity.get());
                    break;
                case 4:
                    logger.info(email.altEmail.get());
                    break;
                case 5:
                    logger.info("Thank you for using application");
                    break;
                default:
                    logger.info("invalid choice!!\n Enter correct choice");

            }
        }while (choice!=5);
    }
}
