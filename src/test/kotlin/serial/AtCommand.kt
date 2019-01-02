package com.test.serial

interface Term {
    fun term(): String
}

enum class Prefix : Term {
    AT {
        override fun term(): String = "AT"
    }
}

interface MidleTerm : Term

enum class PostFix : Term {
    NOTHING {
        override fun term(): String = ""
    },
    ASK {
        override fun term(): String = "?"
    },
    SET {
        override fun term(): String = "="
    }
}

enum class Answer {
    OK,
    DOWNLOAD,
    ERROR
}

enum class Gnss : MidleTerm {
    PWR {
        override fun term(): String = "+CGNSPWR"
    },
    INF {
        override fun term(): String = "+CGNSINF"
    },
}


class AtCommand {
    val commandSentence: String

    constructor() {
        commandSentence = Prefix.AT.term() + "\n"
    }

    constructor(midleTerm: MidleTerm, postFix: PostFix = PostFix.NOTHING, value: String = "") {
        commandSentence = Prefix.AT.term() + midleTerm.term() + postFix.term() + value + "\n"
    }
}