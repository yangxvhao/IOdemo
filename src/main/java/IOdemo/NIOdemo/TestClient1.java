package IOdemo.NIOdemo;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by yangxvhao on 17-9-11.
 */
public class TestClient1 {
    public static void main(String[] args) {
        Client.start();
        Random random = new Random(System.currentTimeMillis());
        /**
         * client.start与client.sendMsg之间应间隔一段创建连接的时间，
         * client.start是异步创建连接，服务端可能还未完成连接的建立。
         * 不然会抛java.nio.channels.NotYetConnectedException
         * 试图在尚未连接的套接字通道上调用I/O操作时，抛出此未经检查的异常”。
         * 也就是连接还未建立好就开始传输数据了
         */
//        Thread.sleep(100);
//        Client.sendMsg(String.valueOf("sdd"));
//        for(int i = 0;i < 50;i++) {
//            new Thread(() -> {
//                while (true) {
                try {
                    while (true)Client.sendMsg(new Scanner(System.in).nextLine());
//                    while (true)Client.sendMsg("test");
                } catch (Exception e) {
                    e.printStackTrace();
                }

//                }
//            }).start();
//            Thread.sleep(3000);
//        }
    }
}
