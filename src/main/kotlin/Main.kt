package com.test

import com.test.serial.AtCommand
import com.test.serial.Gnss
import com.test.serial.PostFix
import com.test.serial.Serial

fun main(args: Array<String>) {
    val serial= Serial()
    serial.open()
    serial.atCommand(AtCommand(Gnss.PWR,PostFix.ASK))
    serial.atCommand(AtCommand(Gnss.INF))
    serial.close()
}