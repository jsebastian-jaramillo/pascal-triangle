

/*
 * n = 2 -> M[3][5]
 * n = 3 -> M[4][7]
 * n = 4 -> M[5][9]
 *
 * start with
 *   0 1 2 3 4 5 6 7 8
 * 0 0 0 0 0 1 0 0 0 0
 * 1 0 0 0 0 0 0 0 0 0
 * 2 0 0 0 0 0 0 0 0 0
 * 3 0 0 0 0 0 0 0 0 0
 * 4 1 0 0 0 0 0 0 0 1
 *
 * end with
 *   0 1 2 3 4 5 6 7 8
 * 0 0 0 0 0 1 0 0 0 0
 * 1 0 0 0 1 0 1 0 0 0
 * 2 0 0 1 0 2 0 1 0 0
 * 3 0 1 0 3 0 3 0 1 0
 * 4 1 0 4 0 6 0 4 0 1
 * 
 */

/**
 *
 * @author jsebastian.jaramillo@udea.edu.co
 */
public class PascalTriangle {
    
    private final int [][] pascalTriangle;
    private int iIndex = 0;
    private int jIndex = 0;
    
    public PascalTriangle() {
        // default for n = 5
        iIndex = 11;
        jIndex = 21;
        pascalTriangle = new int[iIndex][jIndex];
        // initial settings
        initialSettings();
    }
    
    public PascalTriangle(int size) {
        
        iIndex = size+1;
        jIndex = (2*size) + 1;
        pascalTriangle = new int[iIndex][jIndex];
        // initial settings
        initialSettings();
    }
    
    private void initialSettings() {
        pascalTriangle[0][(jIndex-1)/2] = 1;
        pascalTriangle[iIndex-1][0] = 1;
        pascalTriangle[iIndex-1][jIndex-1] = 1;
    }
    
    private void pascalTriangleGenerator() {
        
        for (int i = 0; i < iIndex-1; i++) {
            for (int j = 0; j < jIndex-2; j++) {
                pascalTriangle[i+1][j+1] = pascalTriangle[i][j] + 
                        pascalTriangle[i][j+2];
            }
        }
        printResults();
    }
    
    private void printResults() {
        
        for (int i = 0; i < iIndex; i++) {
            for (int j = 0; j< jIndex; j++) {
                if (pascalTriangle[i][j] == 0)
                    System.out.print("  ");
                else
                    System.out.print(pascalTriangle[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
    
    public static void main(String[] args) {
        
        PascalTriangle pascalTriangle = new PascalTriangle(5);
        pascalTriangle.pascalTriangleGenerator();
    }
}
