import java.time.LocalDateTime;
import java.util.Scanner;

public class fichaje {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        String green = "\u001B[92m";
        String resetColorCode = "\u001B[0m";
        String red = "\u001B[31m";
        boolean fichcomp = false;
        int menu1 = 0;
        int segtotales = 0;
        int contadorfichaje = 0;
        int horastotales = 0;

        do {
            menuprint(green, resetColorCode);
            menu1 = menuswitch(menu1, red, resetColorCode, horastotales, fichcomp, segtotales);
            if(menu1 == 1){
                fichcomp = esfichado(fichcomp);
                if (fichcomp == true){
                    segtotales = iniciofichaje(segtotales);
                }else{
                    segtotales = finfichaje(segtotales);
                }
            }
        } while (menu1 != 3);
    }

    private static int finfichaje(int segtotales) {
        LocalDateTime locaDate = LocalDateTime.now();
        int hoursfin = locaDate.getHour();
        int minutesfin = locaDate.getMinute();
        int secondsfin = locaDate.getSecond();
        System.out.println("Fichaje finalizado a las: " + hoursfin + ":" + minutesfin + ":" + secondsfin);
        segtotales = calcminutosfichados(segtotales, hoursfin, minutesfin, secondsfin);
        convertirsegundosfin(segtotales);
        locaDate = null;
        return segtotales;
    }

    private static void convertirsegundosfin(int segtotales) {
        int horas = segtotales / 3600;
        int minutos = (segtotales % 3600) / 60;
        int segundos = segtotales % 60;

        System.out.println("Has estado fichado: "+horas+"h "+minutos+"m "+segundos+"s");

    }

    private static int calcminutosfichados(int segtotales, int hoursfin, int minutesfin, int secondsfin) {
        int totalsegfin = hoursfin * 3600 + minutesfin * 60 + secondsfin;
        segtotales = totalsegfin - segtotales ;
        return segtotales;
    }

    private static boolean esfichado(boolean fichcomp) {
        if (fichcomp == true){
            fichcomp = false;
        }else{
            fichcomp = true;
        }
        return fichcomp;
    }

    private static void menuprint (String green, String resetColorCode){
        System.out.println(green + "=======================");
        System.out.println("  CALCULADORA FICHAJE");
        System.out.println("=======================" + resetColorCode);
        System.out.println("Elige una opción: ");
        System.out.println("1. Fichar / Desfichar");
        System.out.println("2. Ver horas totales fichadas");
        System.out.println("3. Salir");
    }
    private static int menuswitch(int menu1, String red, String resetColorCode, int horastotales, boolean fichcomp, int segtotales) {
        menu1 = input.nextInt();
        switch (menu1){
            case 1:
                System.out.println("Has elegido: Fichar / Desfichar");
                break;
            case 2:
                mostrartotal(segtotales);
                break;
            case 3:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println(red+"ERROR"+resetColorCode);
                break;
        }
        return (menu1);
    }

    private static void mostrartotal(int segtotales) {
        segtotales = segtotales + segtotales;
        int horasmostrar = segtotales / 3600;
        int minutosmostrar = (segtotales % 3600) / 60;
        int segundosmostrar = segtotales % 60;

        System.out.println("Has estado fichado una totalidad de: "+horasmostrar+"h "+minutosmostrar+"m "+segundosmostrar+"s");
    }

    private static int iniciofichaje (int segtotales) {
        LocalDateTime locaDate = LocalDateTime.now();
        int hoursinicio = locaDate.getHour();
        int minutesinico = locaDate.getMinute();
        int secondsinicio = locaDate.getSecond();
        System.out.println("Fichaje iniciado a las: " + hoursinicio + ":" + minutesinico + ":" + secondsinicio);
        segtotales = segtotal(hoursinicio, minutesinico, secondsinicio, segtotales);
        return segtotales;
    }
    private static int segtotal(int hoursinicio, int minutesinico, int secondsinicio, int segtotales) {
        segtotales = hoursinicio * 3600 + minutesinico * 60 + secondsinicio;
        return  segtotales;
    }
}