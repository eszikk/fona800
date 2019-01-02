package com.test.serial

import com.fazecast.jSerialComm.SerialPort
import java.io.InputStreamReader
import java.io.BufferedReader


class Serial {
    val port = SerialPort.getCommPorts().last()

    fun open(){
        port.openPort()
    }

    fun close(){
        port.closePort()
    }

    fun atCommand(command: AtCommand) {
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0)
        val byteArray = command.commandSentence.toByteArray()
        port.outputStream.write(byteArray)
        port.outputStream.close()

        val inputStreamReader = BufferedReader(InputStreamReader(port.inputStream))
        var line = inputStreamReader.readLine()
        while (line != Answer.OK.name && line != Answer.ERROR.name) {
            println(line)
            line = inputStreamReader.readLine()
        }

        port.inputStream.close()
    }

}