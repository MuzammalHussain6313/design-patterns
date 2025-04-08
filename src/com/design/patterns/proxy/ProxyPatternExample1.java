package com.design.patterns.proxy;
import java.util.ArrayList;
import java.util.List;

interface Internet {
    void connectTo(String host);
}

class RealInternet implements Internet {
    @Override
    public void connectTo(String host) {
        System.out.println("Successfully opened connection to " + host);
    }
}

class ProxyInternet implements Internet {

    private static final List<String> bannedSites;
    private final Internet internet = new RealInternet();

    static {
        bannedSites = new ArrayList<>();
        bannedSites.add("banned.com");
    }

    @Override
    public void connectTo(String host) {
        if (bannedSites.contains(host)) {
            System.out.println("Access Denied to " + host);
            return;
        }
        internet.connectTo(host);
    }
}

public class ProxyPatternExample1 {
    public static void main(String[] args) {

        Internet internet = new ProxyInternet();
        internet.connectTo("google.com");
        internet.connectTo("banned.com");

        System.out.println("==========================================");

        VideoDownloader videoDownloader = new ProxyVideoDownloader();
        videoDownloader.getVideo("geekific");
        videoDownloader.getVideo("geekific");
        videoDownloader.getVideo("likeNsub");
        videoDownloader.getVideo("likeNsub");
        videoDownloader.getVideo("geekific");

    }
}
