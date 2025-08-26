package com.websockets.websockets;

public class ChatMessage {
    
public String content;

//för JSON trafiken behövs tom konstruktor
public ChatMessage() {}

public ChatMessage(String content) {
    this.content = content;
}

public String getContent() {
    return content;
}

public void setContent(String content) {
    this.content = content;
}


}
