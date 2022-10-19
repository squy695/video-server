// 返回数据库内存放的视频
// VideoLet用于相应以下需求：
// 客户端请求视频搜索结果、
// 客户端选择了分区，请求满足分区的视频、
// 客户端下查看自己或别人的用户视频上传记录、
// 。。。。
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.service.Service;

@WebServlet("/Vid")
public class VideoLet extends HttpServlet{

    private static final long serialVersionUID = 9036889586892331384L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // request是客户端的GET报文，数据是在请求中的，不是通过data传来的
        String name = request.getParameter("name");
        name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
        String area = request.getParameter("password");
        area = new String(area.getBytes("ISO-8859-1"),"UTF-8");
        String up=request.getParameter("up");
        up=new String(up.getBytes("ISO-8859-1"),"UTF-8");

        System.out.println(name + ":" + area+":"+up);

        //新建服务对象，提供业务逻辑服务
        Service service = new Service();

        // 给我符合条件的视频
        List<VideoBean> v = service.getVideo(name, area,up);
        if( v.size()>0 ){
            System.out.println("get video success");
            //request.getSession().setAttribute("username", username);
        }else{
            System.out.println("get video fail");
        }

        //返回信息到客户端
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if( v.size()>=0 ){
            out.println("true");
            // TODO 这怎么传呢？
            out.println(v);
        }else{
            out.println("false");
        }
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO 自动生成的方法存根
        resp.getWriter().write("");
    }

}
