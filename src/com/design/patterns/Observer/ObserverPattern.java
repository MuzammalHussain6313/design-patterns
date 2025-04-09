package com.design.patterns.Observer;

import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Subscriber {
    void update(String channelName, String videoTitle);
}

// Concrete Observer
class User implements Subscriber {
    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String channelName, String videoTitle) {
        System.out.println("Hi " + userName + ", new video uploaded on " + channelName + ": " + videoTitle);
    }
}

// Subject (Observable)
class YouTubeChannel {
    private String channelName;
    private List<Subscriber> subscribers = new ArrayList<>();

    public YouTubeChannel(String channelName) {
        this.channelName = channelName;
    }

    // Add a new subscriber
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
        System.out.println("New subscriber added to channel: " + channelName);
    }

    // Remove a subscriber
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
        System.out.println("Subscriber removed from channel: " + channelName);
    }

    // Notify all subscribers
    private void notifySubscribers(String videoTitle) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(channelName, videoTitle);
        }
    }

    // Simulate video upload
    public void uploadVideo(String videoTitle) {
        System.out.println("\nUploading new video: " + videoTitle + " on channel " + channelName);
        notifySubscribers(videoTitle);
    }
}

// Client code
public class ObserverPattern {
    public static void main(String[] args) {
        // Create a channel
        YouTubeChannel channel = new YouTubeChannel("JavaTech");

        // Create subscribers
        Subscriber user1 = new User("Ali");
        Subscriber user2 = new User("Zara");
        Subscriber user3 = new User("Usman");

        // Users subscribe to the channel
        channel.subscribe(user1);
        channel.subscribe(user2);
        channel.subscribe(user3);

        // Upload a video
        channel.uploadVideo("Observer Pattern Explained");

        // One user unsubscribes
        channel.unsubscribe(user2);

        // Upload another video
        channel.uploadVideo("Java 21 New Features");
    }
}

