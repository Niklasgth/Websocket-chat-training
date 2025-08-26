package com.websockets.websockets;

public class HelloMessage {
    private String name;

    /*denna är för jackson, tom konstruktor behövs för den ska fungera */
public HelloMessage() {} 

public HelloMessage(String name){
    this.name =name;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

}
 