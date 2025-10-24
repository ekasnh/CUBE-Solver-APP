// MainActivity.java (simplified for readability)

public class MainActivity extends AppCompatActivity {
    private CubeRecognizer cubeRecognizer;
    private CubeSolver cubeSolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cubeRecognizer = new CubeRecognizer(this);      // Handles camera/color recognition
        cubeSolver = new CubeSolver();                  // Talks to min2phase/reduction solvers

        // UI: select cube size, scan faces, preview/re-edit, solve
        setupUI();
    }

    private void onAllFacesCaptured(List<FaceColors> scannedFaces) {
        // Let user review & fix colors
        // ...

        // When ready, call solver:
        String cubeType = getSelectedCubeType(); // "2x2", "3x3", etc
        String cubeString = CubeStringFormatter.format(scannedFaces, cubeType);
        List<String> solutionMoves = cubeSolver.solve(cubeType, cubeString);

        showSolution(solutionMoves);
    }
}
