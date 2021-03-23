package main;

import entities.Soldier;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    /*
    * Trabalho de POO (4° Período)
    * Pedro Rafael Pereira de Araújo Siqueira
    */

    private static final Scanner sc = new Scanner(System.in);

    private static Soldier insertSoldier() {
        System.out.print("Insert Soldier's CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Insert Soldier's name: ");
        String name = sc.nextLine();
        System.out.print("Hometown: ");
        String hometown = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Height: ");
        double height = sc.nextDouble();
        System.out.print("Weight: ");
        double weight = sc.nextDouble();

        return new Soldier(cpf, name, hometown, age, height, weight);
    }

    private static void showSoldiers(List<Soldier> soldiers, int age){
        System.out.println("Soldiers with age above informed");
        soldiers.stream().filter(soldier -> soldier.getAge() > age).forEach(System.out::println);

        System.out.println("\nSoldiers with age below informed");
        for(Soldier soldier : soldiers){
            if(soldier.getAge() < age){
                System.out.println(soldier);
            }
        }
    }

    private static void showSoldiers(List<Soldier> soldiers, double height){
        System.out.println("Soldiers with height above informed");
        soldiers.stream().filter(soldier -> soldier.getAge() > height).forEach(System.out::println);

        System.out.println("\nSoldiers with height below informed");
        for(Soldier soldier : soldiers){
            if(soldier.getAge() < height){
                System.out.println(soldier);
            }
        }
    }

    private static void showSoldiers(List<Soldier> soldiers) {
        soldiers.forEach(System.out::println);
    }

    private static void newStatus(Soldier soldier) {
        if (soldier.getStatus() == Status.DECEASED) {
            throw new SoldierException("The soldier has already death and can not come back to life");
        }
        soldier.setStatus(Status.DECEASED);
    }

    private static Soldier searchByCpf(String cpf, List<Soldier> soldiers) {
        for (Soldier soldier : soldiers) {
            if (soldier.getCpf().equals(cpf)) {
                return soldier;
            }
        }

        return null;
    }

    private static Soldier searchByName(String name, List<Soldier> soldiers) {
        int cont = 0;
        Soldier aux = null;

        for (Soldier soldier : soldiers) {
            if (soldier.getName().equals(name)) {
                aux = soldier;
                cont++;
            }
        }

        if (cont > 1) {
            throw new SoldierException("There are more than one soldier with the same name. Please, search by CPF");
        } else {
            return aux;
        }
    }

    /* Data to mock */

    private static List<Soldier> dataMock (){
        List<Soldier> soldiers = new ArrayList<>();

        soldiers.add(new Soldier("1010","Matheus","Uberaba",22,1.42,68.42));
        soldiers.add(new Soldier("1020","Pedro","Uberlândia",21,1.62,72.2));
        soldiers.add(new Soldier("1030","João","Uberaba",27,1.55,89.1));
        soldiers.add(new Soldier("1040","Carlos","Brasília",19,1.65,52.8));
        soldiers.add(new Soldier("1050","Miguel","Uberaba",21,1.75,73.8));
        soldiers.add(new Soldier("1060","Jefferson","Uberaba",30,1.78,70.9));
        soldiers.add(new Soldier("1070","Gabriela","Curitiba",18,1.62,49.5));
        soldiers.add(new Soldier("1080","Thiago","Mato Grosso",23,1.75,67.3));
        soldiers.add(new Soldier("1090","Gustavo","Ribeirão Preto",29,1.82,90.3));

        return soldiers;
    }


    public static void main(String[] args) {
        // Switch lists to mock
        // List<Soldier> soldiers = dataMock();
        List<Soldier> soldiers = new ArrayList<>();

        int opc = 0;
        String search;
        Soldier aux;
        while (opc != 10) {
            System.out.print("Select one option: ");
            opc = sc.nextInt();
            try{
                switch (opc) {
                    case 1:
                        soldiers.add(insertSoldier());
                        break;
                    case 2:
                        showSoldiers(soldiers);
                        break;
                    case 3:
                        sc.nextLine();
                        System.out.print("Insert CPF to search: ");
                        search = sc.nextLine();
                        aux = searchByCpf(search,soldiers);

                        if(aux != null){
                            newStatus(aux);
                            System.out.println("Soldier deceased. Rest in peace");
                        } else {
                            System.out.println("Soldier doesn't exist");
                        }
                        break;
                    case 4:
                        sc.nextLine();
                        System.out.print("Insert Name to search: ");
                        search = sc.nextLine();
                        aux = searchByName(search,soldiers);

                        System.out.println(aux);
                        break;
                    case 5:
                        sc.nextLine();
                        System.out.print("Insert CPF to search: ");
                        search = sc.nextLine();
                        aux = searchByCpf(search,soldiers);

                        System.out.println(aux);
                        break;
                    case 6:
                        sc.nextLine();
                        System.out.print("Insert CPF to search: ");
                        search = sc.nextLine();
                        aux = searchByCpf(search,soldiers);

                        if(aux != null){
                            soldiers.remove(aux);
                            System.out.println("Soldier removed");
                        } else {
                            System.out.println("Soldier doesn't exist");
                        }
                        break;
                    case 7:
                        sc.nextLine();
                        System.out.print("Insert CPF to search: ");
                        search = sc.nextLine();
                        aux = searchByCpf(search,soldiers);

                        if(aux != null){
                            soldiers.remove(aux);
                            soldiers.add(insertSoldier());

                            System.out.println("Soldier's date updated");
                        } else {
                            System.out.println("Soldier doesn't exist");
                        }
                        break;
                    case 8:
                        sc.nextLine();
                        System.out.print("Insert Age to filter: ");
                        int age = sc.nextInt();
                        showSoldiers(soldiers,age);
                        break;
                    case 9:
                        sc.nextLine();
                        System.out.print("Insert Height to filter: ");
                        double height = sc.nextInt();
                        showSoldiers(soldiers,height);
                        break;
                    default:
                        opc = 10;
                        break;
                }

            } catch (SoldierException e){
                System.out.println(e.getMessage());
            }
        }
    }
}






