package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.exception.NotEnoughBalanceException;

import java.util.*;
import java.util.stream.Collectors;

public class VendingMachine {

    private int balance;

    private ProductContainer productContainer;

    private CoinContainer coinContainer;

    public VendingMachine(int balance, ProductContainer productContainer, CoinContainer coinContainer) {
        this.balance = balance;
        this.productContainer = productContainer;
        this.coinContainer = coinContainer;
    }

    public void sellProduct(String productName) {
        Product product;

        product = productContainer.getProduct(productName);

        if (balance < product.getPrice()) {
            throw new NotEnoughBalanceException(ErrorMessage.NOT_ENOUGH_BALANCE.getCompleteMessage());
        }

        balance -= product.getPrice();
        product.sell();
    }
}
