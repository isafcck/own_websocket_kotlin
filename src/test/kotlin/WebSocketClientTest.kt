package com.websocket.client

import com.websocket.client.util.LoggerUtil
import org.java-websocket.WebSocket
import org.java-websocket.client.WebSocketClient
import org.java-websocket.handshake.ServerHandshake
import org.java-websocket.server.WebSocketServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.net.URI
import java.util.concurrent.CountDownLatch

class WebSocketClientTest {

    private lateinit var mockServer: WebSocketServer
    private lateinit var webSocketClient: WebSocketClientExanple

    @Before
    fun setup() {
        mockServer = object : WebSocketServer(8887) {
            override fun onOpen(conn: WebSocket?, handshake: ServerHandshake?) {
                println("Mock server opened connection")
                conn?.send("Hello from server")
            }

            override fun onMessage(conn: WebSocket?, message: String?) {
                println("Mock server received message: $message")
            }

            override fun onClose(conn: WebSocket?, code: Int, reason: String?, remote: Boolean) {
                println("Mock server closed connection")
            }

            override fun onError(conn: WebSocket?, ex: Exception?) {
                println("Mock server error: ${ex?.message}")
            }
        }

        mockServer.start()

        val serverURI = URI("ws://localhost:8887")
        webSocketClient = WebSocketClientExanple(serverURI)

        Thread.sleep(1000)
    }

    @After
    fun tearDown() {
        webSocketClient.closeConnection()
        mockServer.stop()
    }

    @Test
    fun testWebSocketConnection() {
        val latch = CountDownLatch(1)

        webSocketClient.addOnOpenListener {
            LoggerUtil.info("Connection established.")
            webSocketClient.send("Hello, server!")
        }

        webSocketClient.addOnMessageListener { message ->
            LoggerUtil.info("Received message: $message")
            latch.countDown()
        }

        webSocketClient.connectToServer()

        latch.await()
    }

    @Test
    fun testErrorHandling() {
        val latch = CountDownLatch(1)

        webSocketClient.addOnErrorListener { ex ->
            LoggerUtil.error("Error occurred: ${ex?.message}")
            latch.countDown()
        }

        webSocketClient.connectToServer()

        mockServer.stop()

        latch.await()
    }

    @Test
    fun testCloseConnection() {
        val latch = CountDownLatch(1)

        webSocketClient.addOnCloseListener {
            LoggerUtil.info("Connection closed.")
            latch.countDown()
        }

        webSocketClient.connectToServer()

        webSocketClient.closeConnection()
        latch.await()
    }
}

