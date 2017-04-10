/**
 * Created by Alex on 23.03.2017.
 */



public class Dr2 {
    int[][] matrix;
    protected int n;
    protected int m;
    public static String size;
    static Dr2 mat_test; //= new dr2();


    public int getM() {
        return this.m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return this.n;
    }

    public void setN(int n) {
        this.n = n;
    }

    protected Dr2() {
        super();
        this.setM(3);
        this.setN(3);
        matrix = new int[getN()][getM()];
        fill(true);
        size = this.getN() + " x " + this.getM();
    }

    protected Dr2(int m, int n) {
        super();
        this.setM(m);
        this.setN(n);
        matrix = new int[getN()][getM()];
        fill(false);
        size = this.getN() + " x " + this.getM();
    }

    protected void fill(boolean def) {
        //метод заполенине матриц
        if (def == true) {
            setM(3);
            setN(3);
        }
        for (int i = 0; i < getM(); i++) {
            for (int j = 0; j < getN(); j++) {
                int randoms = 0 + (int) (Math.random() * 10);//рандом сделан что бы матрицы не были одинаковыми
                matrix[i][j] = i * j / m + n + randoms;
            }
        }
    }

    public Dr2 summ(Dr2 mats,boolean view) {
        //метод сумм

        //матрицу результата
        Dr2 res = new Dr2(getM(), getN());
        //по правилам складывать можно только матрицы равных размеров, проверяем это
        if (mats.getM() == getM() && mats.getN() == getN()) {
            for (int i = 0; i < getM(); i++) {
                for (int j = 0; j < getN(); j++) {
                    res.matrix[i][j] = mats.matrix[i][j] + this.matrix[i][j];
                }
            }
        }
        if (view) res.veiw();
        return res;
    }

    public Dr2 difference(Dr2 mats,boolean view) {
        //метод разности аналогичен методу сумм
        //матрицу результата
        Dr2 res = new Dr2(getM(), getN());
        //по правилам складывать можно только матрицы равных размеров, проверяем это
        if (mats.getM() == getM() && mats.getN() == getN()) {
            for (int i = 0; i < getM(); i++) {
                for (int j = 0; j < getN(); j++) {
                    res.matrix[i][j] = mats.matrix[i][j] - this.matrix[i][j];
                }
            }
        }
        if (view) res.veiw();
        return res;
    }

    private void veiw() {
        //метод отображение
        for (int i = 0; i < getM(); i++) {
            for (int j = 0; j < getN(); j++) {
                System.out.print(this.matrix[i][j]);
                System.out.print("  ");
            }
            System.out.println('\n');
        }
    }

    public static Dr2 single(int n) {
        //возврат единичной матрицы
        Dr2 res = new Dr2(n, n);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    res.matrix[i][j] = 1;
                else res.matrix[i][j] = 0;
            }
        }
        res.veiw();
        return res;
    }

    public void size() {
        //метод возврата размерностей матриц
        System.out.println(size);
    }

    public Dr2 multiplier(int k) {
        //произведение матрицы на число
        Dr2 res = new Dr2(getN(), getM());


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res.matrix[i][j] = this.matrix[i][j] * k;
            }
        }
        res.veiw();
        return res;
    }

    public int determinant(boolean veiw) {

        //на случай дальнейших вычеслений, заносим эту матриу во внешнию переменную
        //выведем для наглядности матрицу
        if (veiw == true) this.veiw();
        //для удобства посчитаем все в отдельные переменные, потом сложим
        int a = this.matrix[0][0] * this.matrix[1][1] * this.matrix[2][2];
        int b = this.matrix[0][1] * this.matrix[1][2] * this.matrix[2][0];
        int c = this.matrix[1][0] * this.matrix[2][1] * this.matrix[0][2];

        int d = this.matrix[0][2] * this.matrix[1][1] * this.matrix[2][0];
        int e = this.matrix[0][1] * this.matrix[1][0] * this.matrix[2][2];
        int f = this.matrix[0][0] * this.matrix[1][2] * this.matrix[2][1];

        return a + b + c - d - e - f;
    }

    protected int det_2(int[][] m) {
        //определитель матрицы 2х2
        return m[0][0] * m[1][1] - m[0][1] * m[1][0];
    }

    protected static int[][] minor(int[][] matrix, int rowNum, int colNum) {

        final int n = matrix.length - 1;
        final int m = matrix[0].length - 1;

        int[][] result = new int[n][m];

        for (int i = 0; i < matrix.length; i++) {
            boolean isRowDeleted = rowNum < i;
            int resultRowIndex = isRowDeleted ? i - 1 : i;

            for (int j = 0; j < matrix[i].length; j++) {
                boolean isColDeleted = colNum < j;
                int resultColIndex = isColDeleted ? j - 1 : j;

                if (rowNum != i && colNum != j)
                    result[resultRowIndex][resultColIndex] = matrix[i][j];
            }
        }
        return result;
    }

    public int rang(Dr2 l) {
        boolean flsg = false;
        int R;
        for (int i = 0; i < l.matrix.length; i++) {
            for (int j = 0; j < l.matrix[0].length; j++) {
                if (det_2(this.minor(l.matrix, i, j)) == 0)
                    flsg = true;
            }
        }
        if (flsg)
            R = 1;
        else
            R = 2;
        return R;
    }
}