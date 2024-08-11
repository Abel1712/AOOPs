public class Login {
    public static void main(String[] args) {
        Single s = Single.getInstance();
        StringBuilder name = new StringBuilder("Abel James");
        StringBuilder mail = new StringBuilder("Abel1234@gmail.com");
        StringBuilder password = new StringBuilder("WhatTheHell->> U_U OwO UwU");
      
        s.enterDeatils(name, mail, password);
        s.getDetails();
    }
}

class Single {
    private static Single s ;
        private  StringBuilder name;
        private  StringBuilder mail;
        private  StringBuilder password;
        
       
  private  Single(){
        
    }
   
   public static Single getInstance(){
    if(s == null){
       s = new Single();
    }
       return s;
   }

   public  void print(){
       System.out.println("hi  iiiiiiii am u ");
   }
   public  void enterDeatils(StringBuilder name,StringBuilder mail,StringBuilder password){
   this.name = name;
   this.password = password;
   this.mail = mail;
   }
   public void getDetails(){
    System.out.println("name = " + name);
    System.out.println("password = "+ password);
    System.err.println("mailid = " + mail);
   }
       

}
