package patterns.in.use.task6;

/**
 * Created by eugene on 10.08.17.
 */
public class SecretaryApp {
    public static void main(String[] args) {
        Secretary secretary = new Secretary(new Director());
        secretary.sendToEmployee();
        secretary.setEmployee(new Manager());
        secretary.sendToEmployee();
        secretary.setEmployee(new Accountant());
        secretary.sendToEmployee();
    }
}

class Secretary {
    Employee employee;

    public Secretary(Employee employee) {
        this.employee = employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public void sendToEmployee(){
        employee.work();
    }
}

interface Employee {
    void work();
}

class Director implements Employee {
    @Override
    public void work() {
        System.out.println("Director.work");
    }
}

class Accountant implements Employee {
    @Override
    public void work() {
        System.out.println("Accountant.work");
    }
}

class Manager implements Employee {
    @Override
    public void work() {
        System.out.println("Manager.work");
    }
}
