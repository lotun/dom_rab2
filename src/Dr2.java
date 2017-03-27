/**
 * Created by Alex on 23.03.2017.
 */


public class Dr2 {
    int[][] matrix;
    private int n;
    private int m;
    public static String size;


    public static void main (String args []) {
       Dr2 mat1 = new Dr2();
       Dr2 mat2 = new Dr2(5,5);
       Dr2 mat3 = new Dr2(3,3);

        //сумма матриц
        mat3.summ(mat1);
        //разность матриц
        mat3.difference();
        //возврат единичной матрицы
        Dr2.single(5);
        System.out.println("---------------------------------------------");
        //метод печати элементов матриц
        mat3.veiw();
        System.out.println("---------------------------------------------");
        //метод возврата размерностей матриц
        mat3.size();
        System.out.println("---------------------------------------------");
        //метод возврата размерностей матриц
        mat3.multiplier(3);
        System.out.println("---------------------------------------------");
        //умножение: результат матрица (не очень понятно задание, что на что умножать)
        //вычисление определителя
        System.out.println("----------вычисление определителя---------");
        System.out.println(Dr2.determinant(true));
        System.out.println("---------------------------------------------");
        //ранг матрицы
        System.out.println(mat3.rang(mat3));

    }
    public int getM(){
        return this.m;
    }
    public  void setM(int m){
        this.m = m;
    }
    public int getN(){
        return this.n;
    }
    public  void setN(int n){
        this.n = n;
    }
    private Dr2(){
        super();
        this.setM(3);
        this.setN(3);
        matrix = new int[getN()][getM()];
        fill(true);
        size = this.getN() + " x " + this.getM();
    }
    private Dr2(int m,int n){
        super();
        this.setM(m);
        this.setN(n);
        matrix = new int[getN()][getM()];
        fill(false);
        size = this.getN() + " x " + this.getM();
    }
    private void fill(boolean def){
        //метод заполенине матриц
        if (def==true){
            setM(3);
            setN(3);
        }
        for (int i=0;i<getM();i++){
            for(int j=0;j<getN();j++){
                int randoms = 0 + (int) (Math.random() * 10);//рандом сделан что бы матрицы не были одинаковыми
                matrix[i][j]=i*j/m+n+randoms;
            }
        }
    }
    public Dr2 summ(Dr2 mats){
        //метод сумм
        //создаем матрицу по умолчанию 3х3
        //Dr2 mats = new Dr2();
        //матрицу результата
        Dr2 res = new Dr2(getM(),getN());
        //по правилам складывать можно только матрицы равных размеров, проверяем это
        if (mats.getM()==getM() && mats.getN()==getN()) {
            for (int i = 0; i < getM(); i++) {
                for (int j = 0; j < getN(); j++) {
                    res.matrix[i][j] = mats.matrix[i][j]+this.matrix[i][j];
                }
            }
        }
        return res;
    }
    public Dr2 difference(){
        //метод разности аналогичен методу сумм
        //создаем матрицу по умолчанию 3х3
        Dr2 mats = new Dr2();
        //матрицу результата
        Dr2 res = new Dr2(getM(),getN());
        //по правилам складывать можно только матрицы равных размеров, проверяем это
        if (mats.getM()==getM() && mats.getN()==getN()) {
            for (int i = 0; i < getM(); i++) {
                for (int j = 0; j < getN(); j++) {
                    res.matrix[i][j] = mats.matrix[i][j]-this.matrix[i][j];
                }
            }
        }
        return res;
    }

    public void veiw(){
        //метод отображение
        for (int i = 0; i < getM(); i++) {
            for (int j = 0; j < getN(); j++) {
                System.out.print(this.matrix[i][j]);
                System.out.print("  ");
            }
            System.out.println('\n');
        }
    }
    public static Dr2 single(int n){
        //возврат единичной матрицы
        Dr2 res = new Dr2(n,n);


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i==j)
                        res.matrix[i][j] = 1;
                    else res.matrix[i][j] = 0;
                }
            }
        res.veiw();
        return res;
    }
    public void size(){
        //метод возврата размерностей матриц
        System.out.println(size);
    }
    public Dr2 multiplier(int k){
        //произведение матрицы на число
        Dr2 res = new Dr2(getN(),getM());


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                    res.matrix[i][j] = this.matrix[i][j]*k;
            }
        }
        res.veiw();
        return res;
    }
    public static int determinant(boolean veiw){
        //создаем матрицу по умолчанию 3х3
        Dr2 mats = new Dr2();
        //на случай дальнейших вычеслений, заносим эту матриу во внешнию переменную
        //выведем для наглядности матрицу
        if (veiw==true) mats.veiw();
        //для удобства посчитаем все в отдельные переменные, потом сложим
        int a = mats.matrix[0][0]*mats.matrix[1][1]*mats.matrix[2][2];
        int b = mats.matrix[0][1]*mats.matrix[1][2]*mats.matrix[2][0];
        int c = mats.matrix[1][0]*mats.matrix[2][1]*mats.matrix[0][2];

        int d = mats.matrix[0][2]*mats.matrix[1][1]*mats.matrix[2][0];
        int e = mats.matrix[0][1]*mats.matrix[1][0]*mats.matrix[2][2];
        int f = mats.matrix[0][0]*mats.matrix[1][2]*mats.matrix[2][1];

        return a+b+c-d-e-f;
    }
    private int det_2(int[][] m){
        //определитель матрицы 2х2
        return m[0][0]*m[1][1]-m[0][1]*m[1][0];
    }

    private static int[][] minor ( int[][] matrix, int rowNum, int colNum ) {

        final int n = matrix.length - 1;
        final int m = matrix[0].length - 1;

        int[][] result = new int[ n ][ m ];

        for ( int i = 0; i < matrix.length; i++ ) {
            boolean isRowDeleted = rowNum < i;
            int resultRowIndex = isRowDeleted ? i - 1 : i;

            for ( int j = 0; j < matrix[i].length; j++ ) {
                boolean isColDeleted = colNum < j;
                int resultColIndex = isColDeleted ? j - 1 : j;

                if (rowNum != i && colNum != j)
                    result[resultRowIndex][resultColIndex] = matrix[i][j];
            }
        }
        return result;
    }
    public int rang(Dr2 l){
        boolean flsg=false;
        int R;
        for (int i = 0; i < l.matrix.length; i++) {
            for (int j = 0; j < l.matrix[0].length; j++) {
                if(det_2(this.minor(l.matrix,i,j))==0)
                    flsg=true;
            }
        }
        if (flsg)
            R=1;
        else
            R=2;
        return R;
    }
}
