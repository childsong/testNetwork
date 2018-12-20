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

/**
 * @program: orgtestNetWork
 * @description:
 * @author: SongZhen
 * @create: 2018-12-20 16:15
 */
@Data
public class Client {
    private ManagedChannel channel=null;
    private PSGrpc.PSBlockingStub blockingStub=null;

    public Client(String host,int port){
        channel=ManagedChannelBuilder.forAddress(host,port).build();
        blockingStub=PSGrpc.newBlockingStub(channel);
    }

    public void sayHello() throws IOException {
        HelloRequest.Builder req=HelloRequest.newBuilder();
        req.setName(Inet4Address.getLocalHost().getHostName());
        HelloReply reply=blockingStub.sayHello(req.build());
    }


}