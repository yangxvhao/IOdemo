package IOdemo.NIOdemo;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by yangxvhao on 17-9-11.
 */
@Slf4j
public class Client {
    private static String DEFAULT_HOST = "127.0.0.1";
    private static int DEFAULT_PORT = 12345;
    private static ClientHandle clientHandle;
    public static void start(){
        start(DEFAULT_HOST,DEFAULT_PORT);
    }
    public static synchronized void start(String ip,int port){
        if(clientHandle!=null)
            clientHandle.stop();
        clientHandle = new ClientHandle(ip,port);
        new Thread(clientHandle,"Server").start();
    }
    //向服务器发送消息
    public static boolean sendMsg(String msg) throws Exception{
        if(msg.equals("q")) return false;
        log.info("客户端发送消息：{}",msg);
        clientHandle.sendMsg(msg);
        return true;
    }
    public static void main(String[] args){
        start();
    }
}
