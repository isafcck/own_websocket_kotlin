package com.websocket.client.util

import java.util.logging.ConsoleHandler
import java.util.logging.Level
import java.util.logging.Logger

object LoggerUtil {

    private val logger: Logger = Logger.getLogger(LoggerUtil::class.java.name)

    init {
        val consoleHandler = ConsoleHandler()
        consoleHandler.level = Level.ALL
        logger.addHandler(consoleHandler)
        logger.level = Level.ALL
    }

    fun info(message: String) {
        logger.info(message)
    }

    fun warn(message: String) {
        logger.warning(message)
    }

    fun error(message: String) {
        logger.severe(message)
    }

    fun debug(message: String) {
        logger.fine(message)
    }
}

