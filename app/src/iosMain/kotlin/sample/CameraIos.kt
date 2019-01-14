package sample

import platform.AVFoundation.*
import platform.QuartzCore.CALayer
import platform.UIKit.UIView


class CameraIos(calayer: CALayer, previewView: UIView) {
    var captureSession: AVCaptureSession? = null
    var videoPreviewLayer: AVCaptureVideoPreviewLayer? = null

    init {
        val captureDevice = AVCaptureDevice.defaultDeviceWithMediaType(AVMediaTypeVideo)
        var input: AVCaptureDeviceInput? = null
        try {
            if (captureDevice != null) {
                input = AVCaptureDeviceInput(captureDevice, null)

            }
        } catch (error: Exception) {
            println(error.message)
        }
        captureSession = AVCaptureSession()
        if (captureSession != null) {
            captureSession?.addInput(input = input!!)
            videoPreviewLayer = AVCaptureVideoPreviewLayer(session = captureSession!!)
            videoPreviewLayer?.videoGravity = AVLayerVideoGravityResizeAspectFill
            videoPreviewLayer?.frame = calayer.bounds
            previewView.layer.addSublayer(videoPreviewLayer!!)
        }
    }

    fun startRunning(){
        captureSession?.startRunning()
    }

    fun getVideoPreviewLayer(): AVCaptureVideoPreviewLayer {
        return videoPreviewLayer!!
    }
}
