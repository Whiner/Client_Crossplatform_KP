package com.donntu.kp.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramSender {
    private String host;
    private int port;

    public DatagramSender(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void send(String message) {
        try {
            byte[] data = message.getBytes();
            InetAddress address = InetAddress.getByName(host);
            DatagramPacket pack = new DatagramPacket(data, data.length, address, port);
            DatagramSocket ds = new DatagramSocket();
            ds.send(pack);
            ds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
