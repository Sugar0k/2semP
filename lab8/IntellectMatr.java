package lab8;

public class IntellectMatr{
    private double[][] matr;
    public IntellectMatr(double[][] matr){
        this.matr = matr;
    }
    public double[][] getMatr(){
        return matr;
    }
    public double[] getVector(){
        if ((matr == null) || (matr[0] == null)) return null;
        double[] vector = new double[matr.length];
        for (int i = 0; i < matr.length; i++) {
            double sum = 0;
            for (int j = 0; j < matr[0].length; j++) {
                if (matr[i][j] > 0) sum += matr[i][j];
            }
            vector[i] = sum;
        }
        return vector;
    }
    public boolean decNumber(double a){
        if ((matr == null) || (matr[0] == null)) return false;
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++) {
                if (matr[i][j] > 0) matr[i][j] -= a;
            }
        }
        return true;
    }
    public boolean delNegativCol(){
        if ((matr == null) || (matr[0] == null)) return false;
        int i = negativCol();
        while (i != -1) {
            delCol(i);
            i = negativCol();
        }
        return true;
    }
    public int negativCol(){
        if ((matr == null) || (matr[0] == null)) return -1;
        for (int i = 0; i < matr[0].length; i++) {
            for (int j = 0; j < matr.length; j++) {
                if (matr[j][i] < 0) return i;
            }
        }
        return -1;
    }

    public boolean delCol(int n){
        if (matr == null) return false;
        if (matr[0] == null) return false;
        if ((n < 0) || (n > matr[0].length-1)) return false;
        if (matr[0].length-1 == 0) {matr = null; return true;}
        double[][] X = new double [matr.length][matr[0].length-1];
        for (int i = 0; i < matr.length; i++){
            int k = 0;
            for (int j = 0; j < matr[0].length; j++)
                if (j != n) {X[i][k] = matr[i][j]; k++;}
        }
        matr = X;
        return true;
    }
    public boolean delRow (int n){
        if (matr == null) return false;
        if (matr[0] == null) return false;
        if ((n < 0) || (n > matr.length-1)) return false;
        if (matr.length-1 == 0) {matr = null; return true;}
        double[][] X = new double[matr.length-1][matr[0].length];
        int k = 0;
        for (int i = 0; i < matr.length; i++)
            if(i != n) {X[k] = matr[ i ]; k++;}
        matr = X;
        return true;
    }
    public void putMatr(){
        if ((matr == null) || (matr[0] == null)) return;
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[0].length; j++)
                System.out.printf ("% 7.2f",matr[ i ][ j ]);
            System.out.println();
        }
    }

    public static void main(String[] args){
        double[][] temp = {{-1,-2,3,0},
                           {1,2,3,-1},
                           {1,2,-3,2},
                           {1,2,3,3},
                           {1,2,3,4},
        };
        IntellectMatr matrix = new IntellectMatr(temp);
        matrix.putMatr();
        System.out.println(matrix.negativCol());
        matrix.delNegativCol();
        matrix.putMatr();
    }
}