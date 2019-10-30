package com.zhaluobox.crazyjava.第16章多线程.practice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountXu {

    private String accountNo;
    private double balance;

    /**
     * 从写equals
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        AccountXu accountXu = (AccountXu) o;
        return Double.compare(accountXu.balance, balance) == 0 &&
                Objects.equals(accountNo, accountXu.accountNo);
    }

    /**
     * 从写hashcode
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(accountNo, balance);
    }
}
