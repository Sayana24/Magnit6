package com.taraskina.magnit6;

import com.taraskina.magnit6.entity.Order;
import com.taraskina.magnit6.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Task2Servlet", value = "/Task2Servlet")
public class Task2Servlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        double maxSum=Double.parseDouble(req.getParameter("maxSum"));
        int quantity=Integer.parseInt(req.getParameter("quantity"));

        ProductService service = new ProductService();
        List<Order> orders = service.task2(maxSum,quantity);
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1> Номера заказов:  </h1><br><br>");

        for (Order order : orders){
            out.println("<p>" + order.getId() + "</p>");
        }
        out.println("</body></html>");
        out.close();
    }
}
