package com.taraskina.magnit6;

import com.taraskina.magnit6.entity.OrderProduct;
import com.taraskina.magnit6.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet(name = "Task1Servlet", value = "/Task1Servlet")
public class Task1Servlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        double sum = 0;
        int number=Integer.parseInt(req.getParameter("number"));
        ProductService service = new ProductService();
        List<OrderProduct> orderProducts = service.getAllByNumber(number);
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1> Номер заказа:  " + number + " </h1><br><br>");

        for (OrderProduct orderProduct : orderProducts){
            String name =orderProduct.getProduct().getName();
            int amount = orderProduct.getAmount();
            double price = orderProduct.getProduct().getPrice();
            sum += amount*price;
            out.println("<p>" + name + "    " + amount + "    " + price + "    " + Math.round(amount*price*100)/100.0 + "</p>");
        }
        out.println("<p> Итого: " + Math.round(sum*100.0)/100.0 +"</p>");
        out.println("<p> Дата: " + orderProducts.get(0).getOrder().getDate() +"</p>");
        out.println("</body></html>");
        out.close();
    }

}
