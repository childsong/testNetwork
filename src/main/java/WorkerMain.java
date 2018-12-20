import javafx.concurrent.Worker;
import net.Client;

import java.io.IOException;

/**
 * @program: orgtestNetWork
 * @description:
 * @author: SongZhen
 * @create: 2018-12-20 16:33
 */
public class WorkerMain {
    public static void main(String[] args)throws IOException {
        Client client=new Client("172.20.10.3",8999);
        client.sayHello();
    }
}