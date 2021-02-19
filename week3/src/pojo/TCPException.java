package pojo;

public class TCPException extends Exception{
    public TCPException(Boolean b , Integer id , String msg){
        System.out.println("访问状态：" + b.toString() + " 错误：" + id.toString() + "原因：" + msg);
    }
}
