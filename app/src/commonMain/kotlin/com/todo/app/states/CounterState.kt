package com.todo.app.states

import org.rekotlin.StateType

data class CounterState(
    val count: Int = 0
) : StateType