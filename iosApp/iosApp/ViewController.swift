import UIKit
import app

class ViewController: UIViewController {
    @IBOutlet weak var previewView: UIView!
    override func viewDidLoad() {
        super.viewDidLoad()
        label.text = SampleIosKt.xPrintStuff()
        let cameraIos = CameraIos(calayer: view.layer, previewView: previewView)
        
        cameraIos.startRunning()
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    @IBOutlet weak var label: UILabel!
}
