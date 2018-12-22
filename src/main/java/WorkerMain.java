import javafx.concurrent.Worker;
import net.Client;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @program: orgtestNetWork
 * @description:
 * @author: SongZhen
 * @create: 2018-12-20 16:33
 */
public class WorkerMain {
    public static void main(String[] args)throws IOException,ExecutionException,InterruptedException {
        Client client=new Client("172.17.89.50",8999);
        client.sayHello();
    }
}