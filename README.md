# Cube Solver Android App

<div align="center">

![Cube Solver Logo](https://img.shields.io/badge/Cube-Solver-2196F3?style=for-the-badge&logo=android&logoColor=white)

**A comprehensive Android application for solving Rubik's Cubes of multiple sizes using camera scanning or manual input**

[![Android](https://img.shields.io/badge/Android-7.0+-3DDC84?style=flat&logo=android&logoColor=white)](https://developer.android.com)
[![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=java&logoColor=white)](https://www.java.com)
[![Material Design](https://img.shields.io/badge/Material%20Design-3-757575?style=flat&logo=material-design&logoColor=white)](https://m3.material.io)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

</div>

---

## 📱 Features

### 🎲 Multiple Cube Sizes
- **2x2 (Pocket Cube)** - Perfect for beginners
- **3x3 (Classic Rubik's Cube)** - The iconic puzzle
- **4x4 (Rubik's Revenge)** - Advanced complexity
- **5x5 (Professor's Cube)** - Expert level challenge

### 📸 Dual Input Methods
- **Camera Scanning**: Capture cube faces using your device camera with real-time grid overlay guidance
- **Manual Input**: Interactive color picker with intuitive grid interface for manual color assignment

### 🧩 Smart Solving Algorithms
- **2x2**: Ortega method implementation
- **3x3**: CFOP/Layer-by-layer method (Kociemba algorithm ready)
- **4x4/5x5**: Reduction method with parity handling

### 📊 Solution Display
- Step-by-step instructions with move notation
- Visual progress tracking
- Detailed descriptions for each move
- Previous/Next navigation through solution steps
- Color-coded completed vs. pending steps

### 🎨 Modern UI/UX
- Material Design 3 components
- Smooth animations and transitions
- Intuitive navigation flow
- Card-based layouts
- Responsive design

---

## 🚀 Getting Started

### Prerequisites

- **Android Studio**: Arctic Fox (2020.3.1) or later
- **Android SDK**: API Level 24 (Android 7.0) or higher
- **Gradle**: 7.0 or later
- **JDK**: Java 8 or higher

### Installation

#### Option 1: Import Existing Project

1. **Clone or download** this repository
2. **Open Android Studio**
3. Select **File → Open**
4. Navigate to the project directory and click **OK**
5. Wait for Gradle sync to complete
6. Click **Run** (Shift + F10) to build and deploy

#### Option 2: Manual Setup

1. **Create a new Android project** in Android Studio
2. **Copy all files** from the downloaded source:
   - Java files → `app/src/main/java/com/cubesolver/app/`
   - Layout files → `app/src/main/res/layout/`
   - Resource files → `app/src/main/res/values/` and `app/src/main/res/drawable/`
   - `AndroidManifest.xml` → `app/src/main/`
   - `build.gradle` files → project root and `app/`
3. **Sync Gradle** files
4. **Build** the project

### Building APK

#### Debug Build
```bash
./gradlew assembleDebug
```
**Output**: `app/build/outputs/apk/debug/app-debug.apk`

#### Release Build
```bash
./gradlew assembleRelease
```
**Output**: `app/build/outputs/apk/release/app-release.apk`

#### Signing Release APK
1. Generate keystore:
```bash
keytool -genkey -v -keystore my-release-key.jks -keyalg RSA -keysize 2048 -validity 10000 -alias my-alias
```

2. Add to `app/build.gradle`:
```gradle
android {
    signingConfigs {
        release {
            storeFile file("my-release-key.jks")
            storePassword "your-password"
            keyAlias "my-alias"
            keyPassword "your-password"
        }
    }
    buildTypes {
        release {
            signingConfig signingConfigs.release
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}
```

3. Build:
```bash
./gradlew assembleRelease
```

---

## 📖 Usage Guide

### Step 1: Launch the App
Open **Cube Solver** on your Android device.

### Step 2: Select Cube Size
Choose from **2x2**, **3x3**, **4x4**, or **5x5** based on your physical cube.

### Step 3: Choose Input Method

#### Option A: Camera Scanning
1. Select **"Camera Scan"**
2. Grant camera permissions when prompted
3. Align each cube face within the yellow grid overlay
4. Tap **"Capture Face"** for each of the 6 faces:
   - Front
   - Right
   - Back
   - Left
   - Top
   - Bottom
5. Review and correct any misidentified colors
6. Tap **"Generate Solution"**

#### Option B: Manual Input
1. Select **"Manual Input"**
2. Choose a color from the color picker
3. Tap grid squares to assign colors
4. Navigate through all 6 faces using **Next/Previous**
5. Tap **"Generate Solution"** when complete

### Step 4: Follow the Solution
1. View **total move count** at the top
2. Read the **current step** with move notation and description
3. Execute the move on your physical cube
4. Tap **"Next"** to proceed to the next step
5. Use **"Previous"** to review earlier steps
6. Tap **"Reset"** to start over from step 1

---

## 🏗️ Project Structure

```
CubeSolver/
├── app/
│   ├── build.gradle                    # App-level build configuration
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml     # App manifest with permissions
│           ├── java/com/cubesolver/app/
│           │   ├── MainActivity.java                    # Entry point
│           │   ├── CubeSizeSelectionActivity.java       # Size selection screen
│           │   ├── CameraScanActivity.java              # Camera scanning
│           │   ├── ManualInputActivity.java             # Manual input
│           │   ├── SolutionActivity.java                # Solution display
│           │   ├── CubeFace.java                        # Face data model
│           │   ├── CubeSolver.java                      # Solving algorithms
│           │   ├── CubeColorDetector.java               # Color detection
│           │   ├── SolutionStep.java                    # Step data model
│           │   └── SolutionAdapter.java                 # RecyclerView adapter
│           └── res/
│               ├── layout/
│               │   ├── activity_main.xml                # Main screen
│               │   ├── activity_cube_size_selection.xml # Size selection
│               │   ├── activity_camera_scan.xml         # Camera UI
│               │   ├── activity_manual_input.xml        # Manual input UI
│               │   ├── activity_solution.xml            # Solution UI
│               │   └── item_solution_step.xml           # Step item
│               ├── values/
│               │   ├── colors.xml                       # Color palette
│               │   ├── strings.xml                      # Text resources
│               │   └── themes.xml                       # App themes
│               └── drawable/
│                   ├── ic_cube.xml                      # Cube icon
│                   └── grid_overlay.xml                 # Camera grid
├── build.gradle                        # Root build configuration
├── settings.gradle                     # Project settings
├── gradle.properties                   # Gradle properties
└── README.md                          # This file
```

---

## 🔧 Technical Details

### Architecture

- **Pattern**: Activity-based with clear separation of concerns
- **Data Models**: Parcelable for efficient data passing between activities
- **UI Components**: Material Design 3 with CardView, RecyclerView
- **Camera**: CameraX for modern camera functionality
- **Threading**: Background solving with UI updates on main thread

### Dependencies

```gradle
dependencies {
    // AndroidX Core
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.11.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    
    // CameraX
    implementation "androidx.camera:camera-camera2:1.3.1"
    implementation "androidx.camera:camera-lifecycle:1.3.1"
    implementation "androidx.camera:camera-view:1.3.1"
    
    // OpenCV (for production)
    implementation 'org.opencv:opencv:4.8.0'
    
    // Utilities
    implementation 'com.google.code.gson:gson:2.10.1'
}
```

### Permissions

```xml
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.INTERNET" />
<uses-feature android:name="android.hardware.camera" android:required="true" />
```

### Minimum Requirements

- **Min SDK**: API 24 (Android 7.0 Nougat)
- **Target SDK**: API 34 (Android 14)
- **Screen**: Portrait orientation
- **Hardware**: Camera (for scanning feature)

---

## 🧮 Solving Algorithms

### Current Implementation (Mock)

#### 2x2 Pocket Cube
- Ortega method basics
- Orient first layer → Position corners → Solve top layer

#### 3x3 Classic Cube
- Layer-by-layer approach
- Cross → F2L → OLL → PLL (CFOP method structure)

#### 4x4 Rubik's Revenge
- Reduction method
- Solve centers → Pair edges → Reduce to 3x3 → Fix parity

#### 5x5 Professor's Cube
- Extended reduction method
- Solve centers → Pair edges → Reduce to 3x3 → Handle parity

### Production Recommendations

For optimal solving, integrate these proven algorithms:

#### For 3x3 Cubes:
- **[min2phase](https://github.com/cs0x7f/min2phase)**: Fast two-phase algorithm
- **[Kociemba's Algorithm](https://kociemba.org)**: Optimal solving in ≤20 moves

#### For 2x2 Cubes:
- Use 3x3 solver with corner-only configuration

#### For 4x4/5x5 Cubes:
- Implement full reduction method with parity detection
- Use 3x3 solver for final stage

---

## 🎨 Color Detection

### Current Implementation
- RGB to HSV color space conversion
- Hue-based color classification
- Saturation and value thresholds

### Color Mappings
```java
White:  Sat < 0.2, Val > 0.7
Red:    Hue 345-15°, Sat > 0.5
Blue:   Hue 200-250°, Sat > 0.4
Orange: Hue 15-40°, Sat > 0.5
Green:  Hue 80-150°, Sat > 0.4
Yellow: Hue 45-75°, Sat > 0.5
```

### Production Enhancement
Integrate **OpenCV** for:
- Advanced color segmentation
- Lighting compensation
- Automatic calibration
- Corner detection
- Sticker boundary recognition

---

## 🚀 Roadmap

### Version 1.0 (Current)
- ✅ Multiple cube size support (2x2, 3x3, 4x4, 5x5)
- ✅ Camera scanning with grid overlay
- ✅ Manual color input
- ✅ Step-by-step solution display
- ✅ Material Design 3 UI

### Version 1.1 (Planned)
- 🔲 Integrate min2phase library for optimal 3x3 solving
- 🔲 OpenCV color detection
- 🔲 Manual color correction after scan
- 🔲 Save and load cube configurations

### Version 2.0 (Future)
- 🔲 3D cube visualization with OpenGL
- 🔲 Animated move demonstrations
- 🔲 Solving timer and statistics
- 🔲 Pattern library
- 🔲 Tutorial mode for beginners
- 🔲 Multiple solving methods (CFOP, Roux, ZZ)
- 🔲 Bluetooth cube integration
- 🔲 Multiplayer solving challenges

### Version 3.0 (Long-term)
- 🔲 AR mode with overlay instructions
- 🔲 Voice-guided solving
- 🔲 AI-powered optimal solutions
- 🔲 Support for exotic puzzles (Pyraminx, Megaminx, Square-1)
- 🔲 Cloud save and sync
- 🔲 Community solve sharing

---

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

### Areas for Contribution
1. **Algorithm Integration**: Implement real solving algorithms (min2phase, Kociemba)
2. **Color Detection**: Enhance OpenCV integration
3. **3D Visualization**: Add OpenGL cube rendering
4. **UI/UX**: Improve user interface and experience
5. **Testing**: Write unit and integration tests
6. **Documentation**: Improve code documentation and tutorials
7. **Localization**: Translate to multiple languages

### How to Contribute
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Code Style
- Follow Java naming conventions
- Use meaningful variable and method names
- Add comments for complex logic
- Keep methods small and focused
- Follow Material Design guidelines for UI

---

## 🐛 Troubleshooting

### Camera Not Working
- **Issue**: Camera preview not showing
- **Solution**: Check camera permissions in Settings → Apps → Cube Solver → Permissions

### Colors Not Detected Properly
- **Issue**: Wrong colors identified during scanning
- **Solution**: Ensure good lighting, avoid shadows, hold cube steady

### App Crashes on Start
- **Issue**: App force closes immediately
- **Solution**: Check Android version compatibility (min API 24)

### Gradle Sync Failed
- **Issue**: Gradle build errors
- **Solution**: Update Android Studio, invalidate caches (File → Invalidate Caches)

### APK Not Installing
- **Issue**: Installation blocked
- **Solution**: Enable "Install from Unknown Sources" in device settings

---

## 📚 Learning Resources

### Rubik's Cube Algorithms
- [Speedsolving.com Wiki](https://www.speedsolving.com/wiki/)
- [CubeSkills](https://www.cubeskills.com/)
- [Ruwix](https://ruwix.com/)

### Android Development
- [Android Developer Docs](https://developer.android.com/)
- [Material Design Guidelines](https://m3.material.io/)
- [CameraX Documentation](https://developer.android.com/training/camerax)

### Solving Algorithms
- [Kociemba's Algorithm](https://kociemba.org/cube.htm)
- [min2phase GitHub](https://github.com/cs0x7f/min2phase)
- [Two-Phase Algorithm Explained](https://www.speedsolving.com/wiki/index.php/Kociemba's_Algorithm)

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

```
MIT License

Copyright (c) 2025 Cube Solver

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

---

## 👥 Authors & Acknowledgments

### Development Team
- **Lead Developer**: [Your Name]
- **UI/UX Design**: [Designer Name]
- **Algorithm Research**: [Researcher Name]

### Acknowledgments
- Herbert Kociemba for the two-phase algorithm
- Chen Shuang for the min2phase implementation
- The speedcubing community for solving methods
- Google for Material Design guidelines
- OpenCV team for computer vision tools

### Third-Party Libraries
- [AndroidX](https://developer.android.com/jetpack/androidx) - Android Jetpack components
- [Material Components](https://github.com/material-components/material-components-android) - Material Design
- [CameraX](https://developer.android.com/training/camerax) - Camera functionality
- [OpenCV](https://opencv.org/) - Computer vision (optional)
- [Gson](https://github.com/google/gson) - JSON serialization

---

## 📞 Support

### Get Help
- **Issues**: [GitHub Issues](https://github.com/yourusername/cubesolver/issues)
- **Discussions**: [GitHub Discussions](https://github.com/yourusername/cubesolver/discussions)
- **Email**: support@cubesolver.app

### FAQ

**Q: Does the app work offline?**  
A: Yes, all solving happens locally on your device.

**Q: Which cube brands work best for scanning?**  
A: Standard color schemes work best. Stickerless cubes with vibrant colors are ideal.

**Q: Can I use this to learn solving methods?**  
A: Yes! The step-by-step instructions help you learn solving techniques.

**Q: Is my cube data stored or shared?**  
A: No, all data stays on your device. We don't collect or share any information.

**Q: Can I contribute to the project?**  
A: Absolutely! See the Contributing section above.

---

## 🌟 Star History

If you find this project useful, please consider giving it a ⭐ on GitHub!

---

<div align="center">

**Made with ❤️ for the cubing community**

[Report Bug](https://github.com/yourusername/cubesolver/issues) · [Request Feature](https://github.com/yourusername/cubesolver/issues) · [Documentation](https://github.com/yourusername/cubesolver/wiki)

</div>
