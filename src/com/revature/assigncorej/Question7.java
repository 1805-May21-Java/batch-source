package com.revature.assigncorej;

import java.util.*;

public class Question7 {
    public static void main(String args[]){
        Employee e = new Employee();
        Employee g = new Employee();

        e.setAge(24);
        g.setAge(30);

        e.setDepartment("Sales");
        g.setDepartment("Accounting");

        e.setName("Aleks Wilke");
        g.setName("Jello Americana");

        Employee[] arr = new Employee[]{e, g};
        LinkedList<Employee> tSet = new LinkedList<>();
        tSet.add(e);
        tSet.add(g);

        Collections.sort(tSet, new NameComparator());
        System.out.print(tSet);
        System.out.println();

        Collections.sort(tSet, new DepComparator());
        System.out.print(tSet);
        System.out.println();


        Collections.sort(tSet, new AgeComparator());
        System.out.print(tSet);
        System.out.println();
    }
}

class Employee implements Comparable{
    String name;
    String department;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", department='").append(department).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}

class NameComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class DepComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getDepartment().compareTo(o2.getName());
    }
}
class AgeComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        if(o1.age>o2.age) return 0;
        else return -1;
    }
}
