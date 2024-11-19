package com.websocket.client
import java.net.URI

fun main(){
  val serverURI =URI("ws://example.com.socket")
  
  val websocketClient= WebSocketExample(serverURI)

  println("connecting to server")
 websocketClient.connectToServer()
 
  println("waiting for messages")
  Thread.sleep(1000)
  
  websocketClient.closeConnection()
  Thread.sleep(2000)
  
}
