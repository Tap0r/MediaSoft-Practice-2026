import java.time.LocalDateTime;
import java.util.Random;
import java.util.Objects;

public class BankAccount {
    private String ownerName;
    private int balance;
    private LocalDateTime openingDate;
    private boolean isBlocked;
    private String number;

    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0;
        this.openingDate = LocalDateTime.now();
        this.isBlocked = false;
        this.number = generateAccountNumber();
    }

    private String generateAccountNumber() {
        Random random = new Random();
        String num = "";

        for (int i = 0; i < 8; i++)
            num += random.nextInt(10);

        return num;
    }

    public boolean cantDeposit(int amount) {
        return (isBlocked || amount <= 0);
    }
    public boolean deposit(int amount) {
        if (cantDeposit(amount))
            return false;

        balance += amount;
        return true;
    }

    public boolean cantWithdraw(int amount) {
        return (isBlocked || amount <= 0 || amount > balance);
    }
    public boolean withdraw(int amount) {
        if (cantWithdraw(amount))
            return false;

        balance -= amount;
        return true;
    }

    public boolean cantTransfer(BankAccount target, int amount) {
        return (isBlocked || target == null || target == this || cantWithdraw(amount) || target.cantDeposit(amount));
    }
    public boolean transfer(BankAccount target, int amount) {
        if (cantTransfer(target, amount))
            return false;

        withdraw(amount);
        target.deposit(amount);
        return true;
    }

	@Override
	public String toString() {
		return String.format("BankAccount {ownerName = '%s', number = '%s', balance = %d, openingDate = %s, isBlocked = %s}",
			ownerName, number, balance, openingDate, isBlocked);
	}
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
			return true;
        if (obj == null || getClass() != obj.getClass())
			return false;

        BankAccount that = (BankAccount) obj;
        return Objects.equals(number, that.number);
    }
    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}