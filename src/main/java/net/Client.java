package net;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.Data;
import net.HelloReply;
import net.HelloRequest;
import net.PSGrpc;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @program: orgtestNetWork
 * @description:
 * @author: SongZhen
 * @create: 2018-12-20 16:15
 */
@Data
public class Client {
    private ManagedChannel channel=null;
    private PSGrpc.PSFutureStub featureStub=null;

    public Client(String host,int port){
        channel=ManagedChannelBuilder.forAddress(host,port).usePlaintext(true).build();
        featureStub=PSGrpc.newFutureStub(channel);
    }

    public void sayHello() throws IOException,ExecutionException,InterruptedException {
        HelloRequest.Builder req=HelloRequest.newBuilder();
        req.setName(Inet4Address.getLocalHost().getHostName());
        Future<HelloReply> reply=featureStub.sayHello(req.build());
        while(!reply.isDone()){
            Thread.sleep(10);
        }
        System.out.println(reply.get().getMessage());
    }


}