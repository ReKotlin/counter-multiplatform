import UIKit
import app

typealias StoreSubscriber = Rekotlin_multiplatformStoreSubscriber
class ViewController: UIViewController, StoreSubscriber {
    let counterStore = CounterStoreKt.counterStore
    
    // Issue with library conversion. newState has Any? as a parameter rather than the state being subscribed
    func doNewState(state: Any?) {
        let state = state as? CounterState
        if state != nil {
            label.text = "\(state!.count)"
        }
    }
    
    @IBOutlet weak var label: UILabel!
    @IBOutlet weak var counterIncrementButton: UIImageView!
    @IBOutlet weak var counterDecrementButton: UIImageView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        counterStore.subscribe(subscriber: self)
        let incrementTapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(incrementTapped(tapGestureRecognizer:)))
        counterIncrementButton.isUserInteractionEnabled = true
        counterIncrementButton.addGestureRecognizer(incrementTapGestureRecognizer)
        
        let decrementTapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(decrementTapped(tapGestureRecognizer:)))
        counterDecrementButton.isUserInteractionEnabled = true
        counterDecrementButton.addGestureRecognizer(decrementTapGestureRecognizer)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    @objc func incrementTapped(tapGestureRecognizer: UITapGestureRecognizer) {
        counterStore.dispatch(action: Increment())
    }
    
    @objc func decrementTapped(tapGestureRecognizer: UITapGestureRecognizer) {
        counterStore.dispatch(action: Decrement())
    }
    
}
