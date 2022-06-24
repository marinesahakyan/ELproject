package com.company;

public class Main {

    public static void main(String[] args) {

        String filename = "";
        if (args.length != 0)
            filename = args[0];

        IpAddressFilesReader ipAddressFilesReader = new IpAddressFilesReader();
        var result = ipAddressFilesReader.read(filename, new IpAddres());
        System.out.println("Unique IP addresses " + result);


    }
}
