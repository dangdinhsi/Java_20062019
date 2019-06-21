package controller;

import entity.ClassRoom;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class CreateClassRoom extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/classroom/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        sosanhpass hehe = new sosanhpass();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");

        String description = req.getParameter("description");
        String email = req.getParameter("email");
        ClassRoom classRoom= new ClassRoom(name,password,password2,description,email);
        HashMap<String,String> errors = classRoom.validate();
        if(errors.size()==0){
            ofy().save().entity(classRoom).now();
            resp.sendRedirect("/classroom/list");
        }else {
            req.setAttribute("room",classRoom);
            req.setAttribute("errors",errors);
            req.getRequestDispatcher("/classroom/form.jsp").forward(req,resp);
        }
    }
}
