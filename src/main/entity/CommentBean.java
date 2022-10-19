// entity包存放的是一些对象的定义
// 比如User对象，Comment对象，等等

// 举例：
// 用户在登录，所以服务端需要查询数据库
// 按下登录按钮的用户 发送了一个HTTP请求报文(GET或POST类型，由客户端定义)
// 部署在服务器上的Tomcat监听到报文（别骂，我在询问老师有没有更好的方法）
// 假设此报文是POST，其中指定了URL路径是/Log，带的数据是username="张三" password是”123“
// Tomcat就会调用LogLet的doPost来处理之，doPost中有调用Service访问数据库
// Service从数据库User表读取数据，返回List<UserBean>给doPost
// 剩下的就不说了
// 下面是一个Bean类型的示例，最好的写法应该是private和get/set，但我很懒

public class CommentBean {
    public String videoId;
    public String userId;
    public String time;
    public String body;
    public int liked;
    public int disLiked;
}
