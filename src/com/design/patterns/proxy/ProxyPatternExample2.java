package com.design.patterns.proxy;

import java.util.HashMap;
import java.util.Map;

record Video(String videoName) {
}

interface VideoDownloader {
    Video getVideo(String videoName);
}

class RealVideoDownloader implements VideoDownloader {
    @Override
    public Video getVideo(String videoName) {
        System.out.println("Connecting to https://www.youtube.com/");
        System.out.println("Downloading Video");
        System.out.println("Retrieving Video Metadata");
        return new Video(videoName);
    }
}

class ProxyVideoDownloader implements VideoDownloader {
    private final Map<String, Video> videoCache = new HashMap<>();
    private final VideoDownloader downloader = new RealVideoDownloader();
    @Override
    public Video getVideo(String videoName) {
        if (!videoCache.containsKey(videoName)) {
            videoCache.put(videoName, downloader.getVideo(videoName));
        }
        System.out.println("Retrieving video from cache...");
        System.out.println("-----------------------");
        return videoCache.get(videoName);
    }
}

public class ProxyPatternExample2 {
    public static void main(String[] args) {
        VideoDownloader videoDownloader = new ProxyVideoDownloader();
        videoDownloader.getVideo("geekific");
        videoDownloader.getVideo("geekific");
        videoDownloader.getVideo("likeNsub");
        videoDownloader.getVideo("likeNsub");
        videoDownloader.getVideo("geekific");
    }
}
