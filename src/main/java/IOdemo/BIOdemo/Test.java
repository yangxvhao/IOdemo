package IOdemo.BIOdemo;

import java.io.IOException;
import java.util.Random;

/**
 * 测试
 * Created by yangxvhao on 17-9-11.
 */
public class Test {

    public static void main(String[] args) {

        /**
         * 先运行服务器
         */
        new Thread(() -> {
            try {
//                ServerNormal.start();
                ServerBetter.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        /**
         * 避免客户端先于服务器
         */
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * 运行客户端
         * 超过线程池数量的请求，将阻塞
         */
        for(int i = 0;i < 50;i++)
        new Thread(() -> {
            Random random = new Random(System.currentTimeMillis());
            while (true) {
                Client.send(String.valueOf(random.nextInt()));

            }
        }).start();
    }
}
