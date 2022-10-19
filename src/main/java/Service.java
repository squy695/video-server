// Service类 为所有的Servlet提供帮助
// 比如某个Servlet需要查询数据库的时候，是通过Service提供的接口得到数据的
// Servlet本身不访问数据库
// 用以辅助的函数都写在Service里面
import java.util.List;

public class Service {

    /*普通0 vip1 管理员2
        密码错误 -1
        */
    public int login(String name,String password){
        /*这里应该连接数据库进行检验*/
        return 0;
    }

    /*注册成功 true
    账号已存在 false
    */
    public boolean register(String name,String password){
        return true;
    }

    /*返回视频列表*/
    public List<VideoBean> getVideo(String name, String area, String up){
        List<VideoBean> l=null;
        return l;
    }

    /*返回评论列表*/
    public List<CommentBean> getComment(String videoId){
        List<CommentBean> l=null;
        return l;
    }

    /*返回评论列表*/
    public boolean setReport(String videoId,String commentId,String userId){
        return true;
    }

    public boolean setPersonalInfo(String[] infos){
        return true;
    }

}

