public class Main {

    public static void main(String[] args) {
        System.out.println("uma média: "+ calcularMediaNota(new Nota(5),new Nota(7)));
        
    }

    public static float calcularMediaNota(Nota nota1, Nota nota2){
        return (nota1.getValor() + nota2.getValor())/2;
    }
}
