import java.util.Random;
import java.util.Scanner;
public class WithdrawMoney extends AtmMachine {
    private int sumMoney1;
    private Random random = new Random();

    public void outPutMoney(AtmMachine atmMachine, Balance balance, Sum sum, Scanner scanner) throws  AtmMachineException {
        int[] array = atmMachine.getAccount();
        System.out.println("Введите сумму для снятия в рублях. Минимальная банкнота 10 рублей");
        if (scanner.hasNextInt()) {
            sumMoney1 = scanner.nextInt();
        } else {
            System.out.println(" Вы ввели не цифру. Попробуйте еще раз");
            outPutMoney(atmMachine, balance, sum, scanner);
        }
        if (proverka(sumMoney1)) {
            if (balance.getBalanceCard() < sumMoney1) {
                throw new AtmMachineException("Нa балансе недостаточно средств");
            }else if (sum.getMaxSum(atmMachine)<sumMoney1){
                throw new AtmMachineException("В банкомате недостаточно средств");
            } else {
                minusSum( array, random);
                balance.setBalanceCard(balance.getBalanceCard() - sumMoney1);
                atmMachine.setAccount(array);
                 }
            } else {
            outPutMoney( atmMachine,  balance,sum,  scanner);
        }
        }


        public void minusSum( int [] array, Random random) { // метод для рандомного снятия денег
        for (int i = sumMoney1; i > 0;){
        int a = random.nextInt(0,3);
            switch (a) {
                case 0:
                    if (i < 50 && array[0] > 0){
                        array[0] = array[0] - 1;
                        i = i - 10;
                        break;
                    }
                     else if (array[0] > 0) {
                        array[0] = array[0] - 1;
                        i = i - 10;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (i < 100 && i > 49 && array[1] > 0){
                        array[1] = array[1] - 1;
                        i = i - 50;
                    }
                     else if (array[1] > 0 && i > 49) {
                        array[1] = array[1] - 1;
                        i = i - 50;
                       break;
                    } else {
                        break;
                    }
                case 2:
                    if (i < 200 && i > 99 && array[2] > 0){
                        array[2] = array[2] - 1;
                        i = i - 100;
                    }
                   else  if (array[2] > 0 && i > 99) {
                        array[2] = array[2] - 1;
                        i = i - 100;
                        break;
                    }else  {
                        break;
                    }
            }
        }
    }
        public boolean proverka(int sumMoney1) { // Проверка на ввод суммы которую хотим снять
        if (sumMoney1 > 0 && sumMoney1 % 10 == 0) {
            return true;
        } else {
            System.out.println(" Вы ввели недопустимое число");
            return false;

        }
    }
}



