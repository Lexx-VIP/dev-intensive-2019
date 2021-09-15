package ru.skillbranch.devintensive.extensions


fun String.truncate(symbols:Int = 16) = this.trimEnd().let {
    if (it.length > symbols) "${this.substring(0, symbols).trimEnd()}..." else it
}

fun String.stripHtml() =
    this
        .replace(Regex("(<.*?>)|(&\\w*?;)"), "")
        .replace(Regex(" {2,}")," ")
