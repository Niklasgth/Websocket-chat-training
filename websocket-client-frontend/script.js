const socket = new SockJS("http://localhost:8080/websocket")
const messageList =document.getElementById("messageList")
const sendText =document.getElementById("sendText")
const sendBtn =document.getElementById("sendBtn")

const stompClient = Stomp.over(socket);

stompClient.connect({},(frame) => {
    console.log ("connected")

    stompClient.subscribe("/topic/greetings", (greeting) => { 
        
        console.log("greeting", JSON.parse(greeting.body).content);

        let li =document.createElement("li");
        li.innerText =JSON.parse(greeting.body).content;
        messageList.appendChild(li);

})

stompClient.subscribe("/topic/chat", (chat) => {
    console.log("chat",JSON.parse(chat.body).chat);

       let li =document.createElement("li");
        li.innerText =JSON.parse(chat.body).chat;
        messageList.appendChild(li);
})

    sendHello("Niklas");
})


function sendHello(name){
    stompClient.send("/app/hello",{},JSON.stringify({"name": name}))
}

sendBtn.addEventListener("click",() => {
    stompClient.send("/app/chat", {}, JSON.stringify({"content": sendText.value,"user": name}))
})

// "user": name  i rad 38 kräver en användarlista av name som kopplas in. om du vill testa utan för kolla grundfunktionerna så ta bort det.