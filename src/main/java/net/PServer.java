package net;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import lombok.Data;
import net.HelloReply;
import net.HelloRequest;
import net.PSGrpc;

import java.io.IOException;

/**
 * @program: orgtestNetWork
 * @description:
 * @author: SongZhen
 * @create: 2018-12-20 16:06
 */

@Data
public class PServer implements PSGrpc.PS {

    private Server server;

    public PServer(int port){
        this.server=ServerBuilder.forPort(8889).addService(PSGrpc.bindService(this)).build();
    }

    public void start()throws IOException,InterruptedException{
        this.server.start();

        this.server.awaitTermination();
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                PServer.this.stop();
            }
        });

    }

    public void stop(){
        if(this.server!=null){
            server.shutdown();
        }
    }

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> resp){
        System.out.println(req.getName());
        HelloReply.Builder reply=HelloReply.newBuilder();
        reply.setMessage("sss");
        resp.onNext(reply.build());
        resp.onCompleted();
    }

}