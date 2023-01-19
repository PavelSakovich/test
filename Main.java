import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws AtmMachineException{
        Scanner scanner = new Scanner(System.in);
        AtmMachine atmMachine = new AtmMachine();
        WithdrawMoney withdrawMoney = new WithdrawMoney();
        Replenish replenish = new Replenish();
        Balance balance = new Balance();
        Sum sum = new Sum();
        Exit exit = new Exit();
        while (exit.isValue() == true){
            MainMenu();
            int i = scanner.nextInt();
            switch (i){
                case 1:
                    withdrawMoney.outPutMoney( atmMachine,  balance,  sum, scanner);
                    System.out.println("Отет о проделанной работе:");
                    sum.showSumMoney (atmMachine);
                    System.out.println("Ваш баланс составляет " + balance.getBalanceCard() + " рублей");
                    break;
                case 2:
                    replenish.replenish(atmMachine,balance);
                    balance.setBalanceCard( balance.getBalanceCard() + replenish.getSumReplenish());
                    System.out.println("Отет о проделанной работе:");
                    System.out.println("Ваш баланс пополнен на " + replenish.getSumReplenish() + " рублей.");
                    System.out.println("Ваш баланс составляет " + balance.getBalanceCard() + " рублей");
                    sum.showSumMoney(atmMachine);
                    break;
                case 3:
                    System.out.println(" Баланс вашей карты состовляет " + balance.getBalanceCard() + " рублей");
                    break;
                case 4:
                    sum.showSumMoney(atmMachine);
                    break;
                case 5:
                    exit.setValue(false);
                    break;
            }
        }
        scanner.close();
    }
        public static void MainMenu() {
            System.out.println("---------------------------------------------------------");
            System.out.println("Главное меню:");
            System.out.println("Для снятия наличных введите - 1");
            System.out.println("Для пополнения карточки введите - 2");
            System.out.println("Для просмотра баланса вашей карты введите - 3 ");
            System.out.println("Для просмотра максимальной суммы для снятия введите - 4");
            System.out.println("Выход - 5");
            System.out.println("---------------------------------------------------------");
        }
    }
