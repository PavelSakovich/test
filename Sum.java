import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Sum extends AtmMachine{
    private int maxSum;
    public int getMaxSum(AtmMachine atmMachine)
    {
        int [] array = atmMachine.getAccount();
        maxSum = array[0] * 10 + array[1] * 50 + array[2] * 100;
        return maxSum;
    }

    public void setMaxSum(int maxSum) {
        this.maxSum = maxSum;
    }
    public void showSumMoney (AtmMachine atmMachine){
        int [] array = atmMachine.getAccount();
        System.out.println("Купюр в банкомате номиналом 10 рублей" + " = " + array[0]);
        System.out.println("Купюр в банкомате номиналом 50 рублей" + " = " + array[1]);
        System.out.println("Купюр в банкомате номиналом 100 рублей" + " = " + array[2]);
        maxSum = array[0] * 10 + array[1] * 50 + array[2] * 100;
        System.out.println( "В банкомате: " + getMaxSum(atmMachine) + " рублей.");


    }

}
