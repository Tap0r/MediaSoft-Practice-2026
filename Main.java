public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Иван Петров");
        BankAccount acc2 = new BankAccount("Мария Смирнова");
        
        System.out.println("=== Начальное состояние ===");
        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println("acc1.equals(acc2): " + acc1.equals(acc2));
        
        System.out.println("\n=== Пополнение счета ===");
        System.out.println("acc1.deposit(1000): " + acc1.deposit(1000));
        System.out.println("acc1.deposit(-100): " + acc1.deposit(-100));
        System.out.println("acc1: " + acc1);
        
        System.out.println("\n=== Снятие денег ===");
        System.out.println("acc1.withdraw(300): " + acc1.withdraw(300));
        System.out.println("acc1.withdraw(1000): " + acc1.withdraw(1000));
        System.out.println("acc1: " + acc1);
        
        System.out.println("\n=== Перевод ===");
        System.out.println("acc1.transfer(acc2, 500): " + acc1.transfer(acc2, 500));
        System.out.println("acc1.transfer(acc2, 1000): " + acc1.transfer(acc2, 1000));
        System.out.println("acc1.transfer(null, 100): " + acc1.transfer(null, 100));
        System.out.println("acc1.transfer(acc1, 100): " + acc1.transfer(acc1, 100));
        System.out.println("После переводов:");
        System.out.println(acc1);
        System.out.println(acc2);
        
        System.out.println("\n=== Итоговое состояние ===");
        System.out.println(acc1);
        System.out.println(acc2);
    }
}