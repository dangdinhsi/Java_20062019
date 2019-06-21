package controller;

import javax.servlet.http.HttpServlet;

public class sosanhpass extends HttpServlet {
    public boolean sosanh(String password,String password2){
        if(password2.compareTo(password)!=0){
            return true;
        }
        else {
            return false;
        }
    }
}
