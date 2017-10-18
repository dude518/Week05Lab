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
        if(action.equals("logout"))
        {
            session.removeAttribute(user);
            getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);
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
        
        if(items == null || items.isEmpty())
        {
            items = new ArrayList<>();
        }
        
        if(action.equals("additem"))
        {
            String item = request.getParameter("additem");
            items.add(item);
            session.setAttribute("items", items);
        }
        else if(action.equals("removeitem"))
        {
            String item = request.getParameter("remove");
            items.remove(item);
            session.setAttribute("items", items);
        }
        else if(action.equals("logout"))
        {
            
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);
    }
}
