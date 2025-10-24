public class CubeSolver {
    public List<String> solve(String cubeType, String cubeString) {
        switch (cubeType) {
            case "2x2": return Min2PhaseSolver.solve2x2(cubeString);
            case "3x3": return Min2PhaseSolver.solve3x3(cubeString);
            case "4x4": return ReductionSolver.solve4x4(cubeString);
            case "5x5": return ReductionSolver.solve5x5(cubeString);
            default: throw new IllegalArgumentException("Unsupported cube type!");
        }
    }
}
