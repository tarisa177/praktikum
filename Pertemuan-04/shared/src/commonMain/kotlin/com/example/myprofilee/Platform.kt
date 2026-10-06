package com.example.myprofilee

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform