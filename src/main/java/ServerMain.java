import net.PServer;

import java.io.IOException;

/**
 * @program: orgtestNetWork
 * @description:
 * @author: SongZhen
 * @create: 2018-12-20 16:33
 */
public class ServerMain {
    public static void main(String[] args)throws IOException {
        PServer pServer=new PServer(8999);
        pServer.start();
    }
}