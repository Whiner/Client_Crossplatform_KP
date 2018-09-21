package com.donntu.kp.client;

import com.donntu.kp.client.logger.Log;

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
            try {
                ds.connect(address, port);
            } catch (Error e) {
                Log.getInstance().log("Ошибка соединения с сервером. " + e.getMessage());
            }
            ds.send(pack);
            Log.getInstance().log("Пакет (" + message + ") отправлен по адресу " + address.toString());
            ds.close();
        } catch (IOException e) {
            Log.getInstance().log("Ошибка отправки пакета по адресу " + host + "/" + port);
        }
    }

}
