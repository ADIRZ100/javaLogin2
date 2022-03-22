package com.example.PROJECTLOGIN;

   
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



//This project insert new client( manager/parent) 
//check log in to the app
//insert new sub client 
//show the details about the sub client


@SpringBootApplication
@RestController
public class DemoApplication {
         private static String haveAcount;//Ask if you have acount true / false.

    public static String getHaveAcount() {
        return haveAcount;
    }

    public static void setHaveAcount(String haveAcount) {
       DemoApplication.haveAcount = haveAcount;
    }

    public static Scanner getClient() {
        return Client;
    }

    public static void setClient(Scanner Client) {
        DemoApplication.Client = Client;
    }
      private static boolean logSucsess ; //check if login sucsess.
      
      static Scanner typeSub = new Scanner(System.in);//scan the name of sub client in the functuon =seeDitaielsAboutSub_Client().
      static Scanner getNameuser = new Scanner(System.in);//get name user that you wont to update.
      static Scanner typeUp = new Scanner(System.in);//chose what you wont to update.
      
      
      
         //scanners from Sunb_Client.
    static Scanner firstName = new Scanner(System.in);//scan the first name
    static Scanner lastName = new Scanner(System.in);//scan the last name
    static Scanner phoneNuber = new Scanner(System.in);//scan the phoone number
    static Scanner gmailS = new Scanner(System.in);//scan gmail
    static Scanner carnumber = new Scanner(System.in);//scan car number
    static Scanner seniorityS = new Scanner(System.in);//scan seniority
    static Scanner check = new Scanner(System.in);//scan check about the actions
      
      
      
      
      //scaners mangr/ parent .
     static Scanner Client = new Scanner(System.in);//check acount
     static Scanner type_sub_Client = new Scanner(System.in);//this scanner check which of actions the manager/ parent wont to do.
      static Scanner user_Name = new Scanner(System.in);//setUser name
      static Scanner password_ = new Scanner(System.in);//set password
      static Scanner gmail_ = new Scanner(System.in);//set gmail
      static Scanner phone_Number_ = new Scanner(System.in);//set phone number
      static String yes = "yes";// this var check acount
      static String no = "no";// this var check acount
      
      static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.example_PROJECTLOGIN_jar_0.0.1-SNAPSHOTPU");
      static EntityManager emClientManager = emf.createEntityManager();
      static ClientManager getCheckUser = new ClientManager();//check user and return his id
      static ClientManager userLogin = new ClientManager();//insertClientUser();
      
      static EntityManagerFactory emfs= Persistence.createEntityManagerFactory("com.example_PROJECTLOGIN_jar_0.0.1-SNAPSHOTPU");
      static EntityManager emSUBclient = emfs.createEntityManager();
      static SUBClient userLoginNew_SUBclient = new SUBClient();//new sub user.
      static SUBClient getSubUser= new SUBClient();//get user from the DB.
      static SUBClient UpF= new SUBClient();//update first name.
      

      
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
                connection();
              
        
	}
@GetMapping
@CrossOrigin//gave as to send requst from html
public String hello(){
    return "adir sdvdsvsd";
}


public static void connection(){
        while(true){
        System.out.println("Do you have acount yes/no ?");
        setHaveAcount(Client.nextLine());
        if(getHaveAcount() == null ? yes == null : getHaveAcount().equals(yes)){// this condition check if have acount
           
            checkConnection();
            break;
        
        }
        if(getHaveAcount() == null ? no == null : getHaveAcount().equals(no)){// this condition check if have acount
            System.out.println("Set user name :___");//insert to the data user name.
            Login.setUserName(user_Name.nextLine());
            System.out.println("Set password : ___ ");//insert to the data password.
            Login.setPassword(password_.nextLine());
            System.out.println("Set gmail : ___ ");//insert to the data gmail.
            Login.setGmail(gmail_.nextLine());
            System.out.println("Set phone number : ___ ");//insert to the data phone number.
            Login.setPhoneNumber(phone_Number_.nextLine());
            insertClientUser();// insert diteils to the DB.
            break;
        }
        else{
                System.out.println("The sysntax is not correct...");
                System.out.println("");
                
        }
        
        }
 
        
        }
     
         //This functuon insert unfo about manager/parent user.
  public static void insertClientUser(){
  
  
        //initialization user LOGIN.
       
            userLogin.setUsername(Login.getUserName());//set username
            userLogin.setPasswordUser(Login.getPassword());//set password
            userLogin.setPhoneNumber(Login.getPhoneNumber());//set phonNuber
            userLogin.setGmail(Login.getGmail());//set gmail

        //get tunsuction.
        emClientManager.getTransaction().begin();
        try{
            emClientManager.persist(userLogin);
            emClientManager.getTransaction().commit();
            System.out.println("insert succsessful!!!");
        } catch(Exception e){
            e.printStackTrace();
        }      
        

       
    }
  // this fuction check the frequency of the trying to connection
 public static void userFaild(){
       try{
             //this var gave as 3 Attempts to try to login.
     Query query = emClientManager.createQuery("select u.userID from ClientManager u\n" +
                                "where u.username = ?1 and u.passwordUser = ?2");
      
     
        System.out.println("Login faield try agien...");
        System.out.println("Set user name :___");//insert to the data user name.
        Login.setUserName(user_Name.nextLine());
        userLogin.setUsername(Login.getUserName()); 
        System.out.println("Set password : ___ ");//insert to the data password.
        Login.setPassword(password_.nextLine());
        userLogin.setPasswordUser(Login.getPassword());
               
       query.setParameter(1, userLogin.getUsername());
       query.setParameter(2, userLogin.getPasswordUser());
   
        // check connection whit the qruey;
          getCheckUser = emClientManager.find(ClientManager.class, query.getSingleResult());
          //checking if the user is true.
            if(getCheckUser  != null){
                System.out.println("Login sucsess...");
                logSucsess = true;
                SubClient();
            }
         
           
            
       }
       catch(Exception e){
                    //login faild exit from the progrem.
         
                System.out.println("To much attempts triyng later bye....");
                System.exit(0);
            
                    
            }
 
            
   }  
    
  // this function check user
  public static void checkConnection(){
      
        
//       System.out.println(userLogin.getUsername());
//       System.out.println(userLogin.getPasswordUser());
       
       try{
           //using own qury to get users id by his username and password.
       Query query = emClientManager.createQuery("select u.userID from ClientManager u\n" +
                                "where u.username = ?1 and u.passwordUser = ?2");
      
      
      
    
        System.out.println("Set user name :___");//insert to the data user name.
        Login.setUserName(user_Name.nextLine());
        userLogin.setUsername(Login.getUserName()); 
        System.out.println("Set password : ___ ");//insert to the data password.
        Login.setPassword(password_.nextLine());
        userLogin.setPasswordUser(Login.getPassword());
        
       //Check white to parameters if hava a user. 
       query.setParameter(1, userLogin.getUsername());
       query.setParameter(2, userLogin.getPasswordUser());
       
            // check the parmeaters and return user id
            getCheckUser = emClientManager.find(ClientManager.class, query.getSingleResult());
            
       
           // System.out.println(getCheckUser.getUserID());
            if(getCheckUser.getUsername() != null){
                System.out.println("Login succsess...");
                logSucsess = true;
                SubClient();
                
            }
            
           
       }
       
        catch(Exception e){
        Query query = emClientManager.createQuery("select u.userID from ClientManager u\n" +
                                "where u.username = ?1 and u.passwordUser = ?2");
  
        userFaild();
       //Check white to parameters if have a user. 
       query.setParameter(1, userLogin.getUsername());
       query.setParameter(2, userLogin.getPasswordUser());
       
            // check the parmeaters and return user id
            getCheckUser = emClientManager.find(ClientManager.class, query.getSingleResult());
            //get the function if canot sucsss to connect
            
           
                
            }
        
          
       }
  
    //this functio gave to the user 3 option to chose to do.
    public static void SubClient(){
        System.out.println("");
        System.out.println("Wellcom to drive safe !!");
        System.out.println("-----------------------------");
        System.out.println("If you wont to SEE ditels abut your worker/chiled press -> 1");
        System.out.println("");
        System.out.println("If you wont to UPDATE ditels abut your worker/chiled press -> 2");
        System.out.println("");
        System.out.println("If you wont to INSERT new worker/chiled press -> 3");
        int type = type_sub_Client.nextInt();// scanner the type of Actions.
        switch(type){
            //this case show as detailes about the user you wont.
            case 1:{
                System.out.println("");
                seeDitaielsAboutSub_Client();
                break;
            }
            //this case updating user
            case 2:{
                
                checSubUser();
                UpadteUser();
                
                break;
            }
            // this case insert new user.
            case 3:{
                System.out.println("Insert details about user : ");
                System.out.println("");
                System.out.println("Set first Nmae: __");
                LoginSubClient.setFirst_Name(firstName.next());
                System.out.println("Set last Name: __");
                LoginSubClient.setLast_Name(lastName.next());
                System.out.println("Set phone Number: __");
                LoginSubClient.setPhone_Number(phoneNuber.next());
                System.out.println("Set gmail: __");
                LoginSubClient.setGmail_(gmailS.next());
                System.out.println("Set car Number: __");
                LoginSubClient.setCar_Number(carnumber.next());
                System.out.println("Set seniority: __");
                LoginSubClient.setSeniority_(seniorityS.nextInt());
                insertNewSubClient();
                
                
                break;
            }
                
        
        
        }
        
    
    }
             //This functuon insert unfo about manager/parent user.
  public static void insertNewSubClient(){
  
          
        //initialization user LOGIN.
       
            userLoginNew_SUBclient.setFirstName(LoginSubClient.getFirst_Name());//set first name
            userLoginNew_SUBclient.setLastName(LoginSubClient.getLast_Name());//set last name
            userLoginNew_SUBclient.setPhoneNumber(LoginSubClient.getPhone_Number());//set phonNuber
            userLoginNew_SUBclient.setGmail(LoginSubClient.getGmail_());//set gmail
            userLoginNew_SUBclient.setCarNumber(LoginSubClient.getCar_Number());//set car number
            userLoginNew_SUBclient.setSeniority(LoginSubClient.getSeniority_());//set seniortiy
            userLoginNew_SUBclient.setUserIDMamagerParent(getCheckUser.getUserID());//set seniortiy
            

        //get tunsuction.
        emSUBclient.getTransaction().begin();
        try{
            emSUBclient.persist(userLoginNew_SUBclient);
            emSUBclient.getTransaction().commit();
            System.out.println("insert succsessful!!!");
        } catch(Exception e){
            e.printStackTrace();
        }      
        
  }
      // this func gave to the client mangaer   the ditels about hise sub cleint hr chose\
  @GetMapping("subb")
  public static String seeDitaielsAboutSub_Client(){
    
                try{
         checSubUser();
         System.out.println("Chose which sub client the you wont to see detaiels set first name : ___");
        //this var gave as the name of sub client.
        String subClientType = typeSub.next();
        //qury from sub client
        Query a = emSUBclient.createNamedQuery("SUBClient.findByFirstName").setParameter("firstName", subClientType);

        System.out.println("First Name - >"+((SUBClient)a.getResultList().get(0)).getFirstName());
        System.out.println("Last Name - >"+((SUBClient)a.getResultList().get(0)).getLastName());
        System.out.println("Car Number - > "+((SUBClient)a.getResultList().get(0)).getCarNumber());
        System.out.println("Gmail - > "+((SUBClient)a.getResultList().get(0)).getGmail());
        System.out.println("Phone Number - > "+((SUBClient)a.getResultList().get(0)).getPhoneNumber());
        System.out.println("Seniority - > "+((SUBClient)a.getResultList().get(0)).getSeniority());
        System.out.println("--------------------------");
        System.out.println("Wont to see more user prees 1 else press any key: __");
        String checkUser = check.next();
        if(checkUser == "1"){
            seeDitaielsAboutSub_Client();
        }
        else{
          SubClient();  
        }

      }
      catch(Exception e){
          e.printStackTrace();
      }
             return null;
           
  }
      

  // this fuction return the nams of the sub client.
  @GetMapping("sub")
    public static void checSubUser( ){
        try {
                for (int i = 0; i < 100; i++) {
                // this qury check to as if have sub users to the client.   
                Query  getSubUsersFromClient = emSUBclient.createNamedQuery("SUBClient.findByUserIDMamagerParent").setParameter("userIDMamagerParent", getCheckUser.getUserID());
                String getUsers = ((SUBClient)getSubUsersFromClient.getResultList().get(i)).getFirstName();
                
                // this condition check if have more users.
                    System.out.println( "Your sub client - >"+getUsers);
             
            }

            
//              

            
        } catch (Exception e) {
            //if dont have more users  do that catch.
             System.out.println("ALL YOUR USERS !");
        }
           
  
    }
    //this functuon updat the user
    
    public static void UpadteUser(){
        try{
            System.out.println("----------------------------------------");
            System.out.println("Chose which user you wont to update : ");
            String getUser = getNameuser.next();
            //get from the DB the ditauls about the user.

            Query a = emSUBclient.createNamedQuery("SUBClient.findByFirstName").setParameter("firstName", getUser);
            System.out.println("First Name - >"+((SUBClient)a.getResultList().get(0)).getFirstName());
            System.out.println("Last Name - >"+((SUBClient)a.getResultList().get(0)).getLastName());
            System.out.println("Car Number - > "+((SUBClient)a.getResultList().get(0)).getCarNumber());
            System.out.println("Gmail - > "+((SUBClient)a.getResultList().get(0)).getGmail());
            System.out.println("Phone Number - > "+((SUBClient)a.getResultList().get(0)).getPhoneNumber());
            System.out.println("Seniority - > "+((SUBClient)a.getResultList().get(0)).getSeniority());
            int userID = ((SUBClient)a.getResultList().get(0)).getUserID();

           
            
            // this var stop the loop.
            int stopLoop = 0;
            //this loop get to the user to do more actions.
            while(stopLoop != 7){
                
                System.out.println("----------------------------------");
                System.out.println("Chose what you wont to change : ");
                System.out.println("First Name - > prees 1");
                System.out.println("Last Name - > prees 2 ");
                System.out.println("Car Number - > press3");
                System.out.println("Gmail - > press 4 ");
                System.out.println("Phone Number - > press 5 ");
                System.out.println("Seniority - > 6");
                System.out.println("To finish the update - > 7");
                //this var save as the typy we wont to upp.
                int type = typeUp.nextInt();
                stopLoop = type;
                 
                switch(type){
                    // this case up the first name.
                    case 1:{
                        try{


                            System.out.println("");  
                            //updte new name
                            System.out.println("Update first Name: __");
                            //scaning the name.
                            String upF = typeUp.next();
                            //stting the trunsaction.
                            emSUBclient.getTransaction().begin();
                            //find the user id and save him in var (subClient).
                            SUBClient update = emSUBclient.find(SUBClient.class, userID);
                            //her we do the updte we set the name.
                            update.setFirstName(upF);
                            //SjpaControler.edit(update);
                            emSUBclient.getTransaction().commit();
                            System.out.println("update  succsessful!!!");


            } 
                        catch(Exception e){
                e.printStackTrace();
            } 

                    break;
                    }
                    //this case up the last name.
                    case 2:{
                            try{


                                System.out.println("");  
                                //updte new name
                                System.out.println("Update Last Lame: __");
                                //scaning the name.
                                String upF = typeUp.next();
                                //stting the trunsaction.
                                emSUBclient.getTransaction().begin();
                                //find the user id and save him in var (subClient).
                                SUBClient update = emSUBclient.find(SUBClient.class, userID);
                                //her we do the updte we set the name.
                                update.setLastName(upF);
                                //SjpaControler.edit(update);
                                emSUBclient.getTransaction().commit();
                                System.out.println("update  succsessful!!!");


            } 
                        catch(Exception e){
                e.printStackTrace();
            } 

                    break;

                    }
                    //this case up the car number.
                    case 3:{
                            try{


                                System.out.println("");  
                                //updte new name
                                System.out.println("Update Car Number: __");
                                //scaning the name.
                                String upF = typeUp.next();
                                //stting the trunsaction.
                                emSUBclient.getTransaction().begin();
                                //find the user id and save him in var (subClient).
                                SUBClient update = emSUBclient.find(SUBClient.class, userID);
                                //her we do the updte we set the name.
                                update.setCarNumber(upF);
                                //SjpaControler.edit(update);
                                emSUBclient.getTransaction().commit();
                                System.out.println("update  succsessful!!!");


                            } 
                        catch(Exception e){

                              e.printStackTrace();
                        } 

                    break;
                    }
                    //this case up the gmail.
                    case 4:{
                                                try{


                                System.out.println("");  
                                //updte new name
                                System.out.println("Update Gmail __");
                                //scaning the name.
                                String upF = typeUp.next();
                                //stting the trunsaction.
                                emSUBclient.getTransaction().begin();
                                //find the user id and save him in var (subClient).
                                SUBClient update = emSUBclient.find(SUBClient.class, userID);
                                //her we do the updte we set the name.
                                update.setGmail(upF);
                                //SjpaControler.edit(update);
                                emSUBclient.getTransaction().commit();
                                System.out.println("update  succsessful!!!");


            } 
                        catch(Exception e){
                e.printStackTrace();
            } 

                    break;

                    }
                    //this case up phone number.
                    case 5:{
                                                try{


                                System.out.println("");  
                                //updte new name
                                System.out.println("Update Phone Number: __");
                                //scaning the name.
                                String upF = typeUp.next();
                                //stting the trunsaction.
                                emSUBclient.getTransaction().begin();
                                //find the user id and save him in var (subClient).
                                SUBClient update = emSUBclient.find(SUBClient.class, userID);
                                //her we do the updte we set the name.
                                update.setPhoneNumber(upF);
                                //SjpaControler.edit(update);
                                emSUBclient.getTransaction().commit();
                                System.out.println("update  succsessful!!!");


            } 
                        catch(Exception e){
                e.printStackTrace();
            } 

                    break;

                    }
                    //this case up senioroty.
                    case 6:{
                            try{


                                System.out.println("");  
                                //updte new name
                                System.out.println("Update Seniority: __");
                                //scaning the name.
                                int upF = typeUp.nextInt();
                                //stting the trunsaction.
                                emSUBclient.getTransaction().begin();
                                //find the user id and save him in var (subClient).
                                SUBClient update = emSUBclient.find(SUBClient.class, userID);
                                //her we do the updte we set the name.
                                update.setSeniority(upF);
                                //SjpaControler.edit(update);
                                emSUBclient.getTransaction().commit();
                                System.out.println("update  succsessful!!!");


            } 
                        catch(Exception e){
                e.printStackTrace();
            } 
                    //this case finish the loop.        
                  
                    break;

                    }
                    case 7:{
                        System.out.println("Finish to update");
                            break;
                            
                            
                    }
                    default:{
                        System.err.println("Sentax is eror !! ");
                    }

                }
            }
           
            }

             catch(Exception e){

            }
    }
}
