package com.Team7.Skyinvasion.data

object LevelInfo {

    var hasPlayedTutorial = false

    var level = 0

    fun resetLevel() {
        level = 1
    }

    fun increment() {
        level++
    }
}