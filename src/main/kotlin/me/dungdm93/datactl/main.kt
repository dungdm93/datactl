@file:JvmName("Main")

package me.dungdm93.datactl

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DataCtlApplication

fun main(args: Array<String>) {
    runApplication<DataCtlApplication>(*args)
}
