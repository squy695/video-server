import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 告诉Tomcat：如果收到HTTP请求的URL路径是 /Log 这样的，就调用 HelloServlet这个类来处理该请求

@WebServlet("/Reg")
public class RegLet extends HttpServlet{

    private static final long serialVersionUID = 9036889586892331384L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //response.getWriter().write("reg success");
        // 客户端的GET报文，数据是在请求中的，不是通过data传来的
        String username = request.getParameter("username");
        username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
        String password = request.getParameter("password");
        password = new String(password.getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(username + ":" + password);

        //新建服务对象
        Service service = new Service();

        //验证处理
        boolean reg = service.register(username, password);
        if( reg ){
            System.out.println("reg success");
            //request.getSession().setAttribute("username", username);
        }else{
            System.out.println("reg fail");
        }

        //返回信息到客户端
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if( reg ){
            out.println("true");
        }else{
            out.println("false");
        }
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO 自动生成的方法存根
        resp.getWriter().write("reg success");
    }

}