package controller;

import com.googlecode.objectify.ObjectifyService;
import entity.ClassRoom;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class ListClassRoom extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectifyService.register(ClassRoom.class);
        List<ClassRoom> list = ofy().load().type(ClassRoom.class).list();
        req.setAttribute("list",list);
        req.getRequestDispatcher("/classroom/list.jsp").forward(req,resp);
    }
}
