package chap1_3;

public class Practice1 {
    public static void main(String[] args) {

        BankAccount acc = new BankAccount();
        acc.accountNumber = "1111-222-333333";
        acc.owner = "pororo";
        acc.deposit(500);
        acc.withdraw(300);
        acc.displayBalance();

        System.out.println("===========================");

        Student student = new Student();
        student.updateGrade();
        student.printStudentInfo();

    }
}

class BankAccount {
    String accountNumber;
    String owner;
    int balance;

    void deposit(double amount) {
        balance += amount;
    }
    void withdraw(double amount) {
        balance -= amount;
        if (balance < 0) {
            System.out.println("잔액 부족");
            balance += amount;
        }
    }
    void displayBalance() {
        System.out.println("잔고 = " + balance);
    }
}

class Student {
    String studentId;
    String name;
    String grade;

    Student() {
        studentId = "213";
        name = "heartping";
        grade = "1";
    }

    void updateGrade() {
        int tempGrade = Integer.parseInt(grade);
        tempGrade += 1;
        grade = Integer.toString(tempGrade);
    }
    void printStudentInfo() {
        System.out.printf("학생ID: %s, 학생이름: %s, 학년: %s",studentId, name, grade);
    }

}
