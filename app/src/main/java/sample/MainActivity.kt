package sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.todo.app.actions.Decrement
import com.todo.app.actions.Increment
import com.todo.app.states.CounterState
import com.todo.app.store.counterStore
import kotlinx.android.synthetic.main.activity_main.*
import org.rekotlin.StoreSubscriber

class MainActivity : AppCompatActivity(), StoreSubscriber<CounterState> {

    override fun newState(state: CounterState) {
        counterView.text = state.count.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterIncrement.setOnClickListener {
            counterStore.dispatch(Increment())
        }
        counterDecrement.setOnClickListener {
            counterStore.dispatch(Decrement())
        }
    }

    override fun onStart() {
        super.onStart()
        counterStore.subscribe(this)
    }

    override fun onStop() {
        super.onStop()
        counterStore.unsubscribe(this)
    }
}