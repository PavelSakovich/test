import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Replenish extends AtmMachine{
    private int SumReplenish;

    public int getSumReplenish() { // возвращаем сумму которую добавим на карту.
        return SumReplenish;
    }
     public void replenish (AtmMachine atmMachine, Balance balance) {
         int[] array = atmMachine.getAccount();
         Scanner scanner = new Scanner(System.in);
         System.out.println("Введите номинал купюры который хотите внести. Доступные кюпюры \"10\" , \"50\", \"100\". ");
         if (scanner.hasNextInt()) {
             int firstBanknot = scanner.nextInt();
             System.out.println("Введите количество вносимых кюпюр");
             int secondBanknot = scanner.nextInt();
             SumReplenish = firstBanknot * secondBanknot;
             switch (firstBanknot) {
                 case 10:
                     array[0] = array[0] + secondBanknot;
                     break;// добавляем к списку купюры 10 р.
                 case 50:
                     array[1] = array[1] + secondBanknot;
                     break;// добавляем к списку купюры 50 р.
                 case 100:
                     array[2] = array[2] + secondBanknot;
                     break;// добавляем к списку купюры 100 р.
                 default:
                     System.out.println("Такой купюры нет, попробуйте еще раз");
                     replenish(atmMachine, balance);
                     break;
             }
         } else {
             System.out.println("Вы ввели не число");
             replenish( atmMachine, balance);
         }
         atmMachine.setAccount(array);
     }
}
