package com.websocket.client

import org.java-websocket.client.WebSocketClient
import org.java-websocket.handshake.ServerHandshake
import java.net.URI

class WebSocketClientExample(serverURI:URI):WebSocketClient(serverURI){
  
  override fun  onOpen(handshake: ServerHandshake?){
    println("opened connection")
    send("hello server")
    
  }
  override fun onMessage(message:String?){
    println(" message $message")
    
  }

  override fun onClose(reason:String?,code:Int,remote:Boolean?){
    println("connection closed with $reason with code $code")
    
  }
  override fun onError(ex:Exception?){
    println("error occured ${ex?.message}")
  }
  fun connectToServer(){
    connect()
  }
  
  fun closeConnection(){
    close()
    
    
  }
  
