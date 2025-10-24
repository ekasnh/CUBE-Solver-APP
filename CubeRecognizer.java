public class CubeRecognizer {
    // Use org.opencv.android.JavaCameraView + color segmentation
    public FaceColors scanFace(Bitmap faceImage) {
        // Divide grid, average colors in each square
        // Classify colors (HSV, clustering, calibrate for lighting/cube type)
        // Return FaceColors object
        ...
    }
    // Repeat for all 6 faces
}
