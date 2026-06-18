package ejercicios.tres;

public class Main {

    public static void main(String[] args) {

        Golondrina pepita = new Golondrina();

        System.out.println(pepita.getEnergia()); // 45

        pepita.realizarDeseo();

        System.out.println(pepita.getEnergia()); // 295

        pepita.comer(50);

        System.out.println(pepita.getEnergia()); // 545

        pepita.realizarDeseo();

        System.out.println(pepita.getEnergia()); // 525
    }
}