package ru.romanow.merge

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class CalculationApplication

fun main(args: Array<String>) {
    SpringApplication.run(CalculationApplication::class.java, *args)
}