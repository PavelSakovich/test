import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class AtmMachine {
   public int[] account = new int[]{20, 40, 60};
    // под индексом 0 купюры 10 руб.
    // под индексом 1 купюры 50 руб.
    // под индексом 2 купюры 100 руб.

    public int[] getAccount() {
        return account;
    }

    public void setAccount(int[] account) {
        this.account = account;
    }
}


