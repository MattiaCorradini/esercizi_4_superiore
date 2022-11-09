import AInformatica.Punto;

public class Main {
    public static void main(String[] args) {
        Punto a = new Punto(2,3);
        Punto b = new Punto(1, -7);
        System.out.println("Punto A= " + a);
        System.out.println("Punto B= " + b);
        System.out.println("Distanza A,B= " + a.distanza(b));
        System.out.println("Distanza A,origine= " + a.distanzaOrigine());
        System.out.println("Distanza B,origine= " + b.distanzaOrigine());

        a.traslaX(10);
        b.trasla(1, 7);
        System.out.println("Punto A= " + a);
        System.out.println("Punto B= " + b);
        System.out.println("Distanza A,B= " + a.distanza(b));

        a=new Punto(1,1);
        System.out.println("Distanza A,origine= " + a.distanzaOrigine());
    }
}