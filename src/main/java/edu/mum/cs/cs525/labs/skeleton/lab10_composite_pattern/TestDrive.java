package edu.mum.cs.cs525.labs.skeleton.lab10_composite_pattern;

public class TestDrive {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Thinh", 1000);
        Employee employee2 = new Employee("Nhat", 2000);
        Employee employee3 = new Employee("Duy", 3000);

        Manager manager = new Manager("Vu", 10000, 100);
        manager.addHire(employee1);
        manager.addHire(employee2);
        manager.addHire(employee3);

        Manager ceo = new Manager("CEO", 100000, 1000);
        ceo.addHire(manager);

        HireCounterConsumer counter = new HireCounterConsumer();
        ceo.process(counter);
        System.out.println("Total number of hires: " + counter.getCounter());

        CalculateSalary calculateSalary = new CalculateSalary();
        ceo.process(calculateSalary);
        System.out.println("Total salary: " + calculateSalary.getTotalSalary());

        TotalBudgetConsumer totalBudgetConsumer = new TotalBudgetConsumer();
        ceo.process(totalBudgetConsumer);
        System.out.println("Total budget: " + totalBudgetConsumer.getTotalBudget());
    }
}
