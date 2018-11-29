package com.todo.app.reducers

import com.todo.app.actions.Decrement
import com.todo.app.actions.Increment
import com.todo.app.states.CounterState
import org.rekotlin.Action

fun counterReducer(action: Action, counterState: CounterState?): CounterState {
    val state = counterState ?: CounterState()
    return when (action) {
        is Increment -> state.copy(count = state.count + 1)
        is Decrement -> state.copy(count = (state.count - 1).coerceAtLeast(0))
        else -> state
    }
}