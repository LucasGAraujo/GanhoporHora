//import Classes.Employees;
//import Classes.Funcionario;
//import Classes.Rectangle;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//import java.util.Scanner;
//import java.util.stream.Collectors;

import Entite.Department;
import Entite.HourContract;
import Entite.Worker;
import Entite.enums.WorkLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.print("Enter department's name: ");
        String department = sc.nextLine();
        System.out.println("Enter worker date: ");
        System.out.println("Name:");
        String workerName = sc.nextLine();
        System.out.println("Level");
        System.out.println("JUNIOR,\n" +
                "    SENIOR,\n" +
                "    PLENO,");
        String workerLevel = sc.nextLine();
        System.out.print("Base salary");
        double workerBaseSalary = sc.nextDouble();
        Worker worker = new Worker(workerName, WorkLevel.valueOf(workerLevel),workerBaseSalary,new Department(department));
        System.out.println("How many contracts to this worker? ");
        int n = sc.nextInt();
        for(int i =1; i <= n ; i++){
            System.out.println("Enter contract"+ i +" data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate =  sdf.parse(sc.next());
            System.out.println("Value per hour");
            double valuePer = sc.nextDouble();
            System.out.println("Duration (hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePer,hours);
            worker.addContract(contract);
        }
        System.out.println("---------------------------");
        System.out.println("Enter month and year to calculate income (MM/YYY)");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int yers = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(yers, month)));
        sc.close();
    }

}