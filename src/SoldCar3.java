import java.util.Scanner;

class Gora3 {
    String name, cord;
    double square;

    @Override
    public String toString() {
        return "Gora3{" +
                "name='" + name + '\'' +
                ", cord='" + cord + '\'' +
                ", square=" + square +
                '}';
    }
}

public class SoldCar3 {


    public static Gora3[] setCountrArr(int k) {
        Scanner sc = new Scanner(System.in, "cp1251");
        Gora3 count[] = new Gora3[k];
        System.out.println("Введите информацию о горах: ");
        for (int i = 0; i < count.length; i++) {
            count[i] = new Gora3();
            System.out.print("Название " + (i + 1) + "-й горы => ");
            count[i].name = sc.nextLine();
            System.out.println("Место расположения " + (i + 1) + "-й горы");
            count[i].cord = sc.nextLine();
            System.out.print("Высота " + (i + 1) + "-й горы => ");
            count[i].square = sc.nextDouble();
            sc.nextLine();
        }
        return count;
    }

    public static void showArray(Gora3[] cntr) {
        for (int i = 0; i < cntr.length; i++) {
            System.out.println("" + cntr[i].name + " \t" + cntr[i].square + "м");
        }
    }

    public static void showCountry(Gora3 cntr) {
        System.out.println("" + cntr.name + "\t" + cntr.square + "м");
    }

    public static int NomMax(Gora3[] st) {
        int nommax = 0;
        double max = st[nommax].square;
        for (int i = 0; i < st.length; i++)
            if (st[i].square > max) {
                max = st[i].square;
                nommax = i;
            }
        return nommax;
    }

    public static void sortSquare(Gora3[] cntr) {
        for (int i = 0; i < cntr.length - 1; i++)
            for (int j = 0; j < cntr.length - 1 - i; j++)
                if (cntr[j].square > cntr[j + 1].square) {
                    Gora3 rab = cntr[j];
                    cntr[j] = cntr[j + 1];
                    cntr[j + 1] = rab;
                }
    }

    public static void avgSquar(Gora3[] cntr) {
        for (int i = 0; i < cntr.length; i++) {
            if (cntr[i].square > 1000) {
                System.out.println("" + cntr[i].name + "\t" + cntr[i].cord + "\t" + cntr[i].square + "м");
            }
        }
    }

    public static int typeSearch(Gora3[] count, String nameSearch) {
        int nomS = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i].name.equals(nameSearch)) {
                nomS = i;
            }
        }
        return nomS;
    }

    public static void redCount(Gora3 count) {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.println("Введите индекс поля");
        System.out.println("name, coord, square");
        String strPole = sc.nextLine();
        switch (strPole) {
            case "name": {
                System.out.println("Введите новое имя");
                String newName = sc.nextLine();
                count.name = newName;
                break;
            }
            case "coord": {
                System.out.println("Введите новое место");
                String newCord = sc.nextLine();
                count.cord = newCord;
                break;
            }
            case "square": {
                System.out.println("Введите новую высоту");
                double newSquare = sc.nextDouble();
                count.square = newSquare;
                break;
            }
        }
    }

    public static void main(String[] args) { // ГЛАВНЫЙ КЛАСС С МЕТОДАМИ
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.print("Введите количество гор=> ");
        int n = sc.nextInt();
        sc.nextLine();
        Gora3 count[] = setCountrArr(n);
        System.out.println("Горы с высотой больше 1000м ");
        avgSquar(count);
        int nommax = NomMax(count);
        System.out.println("\nСамая высокая гора:");
        showCountry(count[nommax]);
        System.out.println("\nОтсортированный список по площади:");
        showArray(count);
        System.out.println("Что хотите найти?");
        String nameSearch = sc.nextLine();
        int nomS = typeSearch(count,nameSearch);
        if(nomS!=-1){
            System.out.println("Информация о найденной горе");
            System.out.println(count[nomS]);
            redCount(count[nomS]);
            System.out.println("Отредактированная информация");
            System.out.println(count[nomS]);
        }
        else{
            System.out.println("Ничего не найдено");
        }
    }
}