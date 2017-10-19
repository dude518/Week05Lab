/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppinglist;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 578291
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = (String)session.getAttribute("username");
        
        if(user == null || user.equals(""))
        {
            getServletContext().getRequestDispatcher("/WEB-INF/Register.jsp").forward(request, response);
            return;
        }
        String action = request.getParameter("action");
        if(action != null && action.equals("logout"))
        {
            session.removeAttribute("username");
            getServletContext().getRequestDispatcher("/WEB-INF/Register.jsp").forward(request, response);
            return;
        }
        request.setAttribute("username", user);
        
        getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        ArrayList<String> items = (ArrayList<String>)session.getAttribute("items");
        
        if(action.equals("add"))
        {
            String item = request.getParameter("additem");
            items.add(item);
            session.setAttribute("items", items);
            response.sendRedirect("shoppinglist");
            return;
        }
        else if(action.equals("delete"))
        {
            String item = request.getParameter("itemlist");
            
            items.remove(item);
            session.setAttribute("items", items);
            response.sendRedirect("shoppinglist");
            return;
        }
        else if(action.equals("register"))
        {
            String username = request.getParameter("username");
            items = new ArrayList<>();
            session.setAttribute("username", username);
            session.setAttribute("items", items);
            response.sendRedirect("shoppinglist");
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);
    }
}
