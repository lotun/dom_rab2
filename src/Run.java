/**
 * Created by Alex on 27.03.2017.
 */


public class Run {
    public static void main(String args[]) {
        Dr2 mat1 = new Dr2();
        Dr2 mat2 = new Dr2(5, 5);
        Dr2 mat3 = new Dr2(3, 3);

        //сумма матриц
        System.out.println("------------сумма матриц----------------");
        mat3.summ(mat1,true);
        System.out.println("-------------разность матриц---------------------");
        //разность матриц
        mat3.difference(mat1,true);
        System.out.println("--------------возврат единичной матрицы-------------");
        //возврат единичной матрицы
        Dr2.single(5);
        System.out.println("------------метод печати элементов матриц----------");
        //метод печати элементов матриц
        mat3.veiw();
        System.out.println("-----------метод возврата размерностей матриц-----------");
        //метод возврата размерностей матриц
        mat3.size();
        System.out.println("------------произведение матрицы на число ----------");
        //метод возврата размерностей матриц
        mat3.multiplier(3);
        System.out.println("---------------------------------------------");
        //умножение: результат матрица (не очень понятно задание, что на что умножать)
        //вычисление определителя
        System.out.println("----------вычисление определителя---------");
        System.out.println(mat3.determinant(true));
        System.out.println("-----------ранг матрицы------------------");
        //ранг матрицы
        System.out.println(mat3.rang(mat3));

    }
}
