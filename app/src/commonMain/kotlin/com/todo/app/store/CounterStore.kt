package com.todo.app.store

import com.todo.app.reducers.counterReducer
import com.todo.app.states.CounterState
import org.rekotlin.Store

val counterStore = Store(
    reducer = ::counterReducer,
    state = CounterState()
)