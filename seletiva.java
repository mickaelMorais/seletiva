import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class seletiva {
    public static void main(String[] args) {
        String [] candidatos = {"mickael", "nayla", "adeilson", "camilla", "mariane", "vallentina", "miguel", "sinistra", "roberto", "debora", "jhon", "carlos"};
        ArrayList<String> selecionadosLista = new ArrayList<String>();
        for(int i = 0; candidatos.length > i && selecionadosLista.size() < 5; i ++){
            int salario = valorPretendido();
            if (salario <= 2000) {
                selecionadosLista.add(candidatos[i]);
            }
        }
        for (String selecionado : selecionadosLista) {
            System.out.println("O candidato selecionado foi " + selecionado);
        }
        for(int indexSelecionados = 0; selecionadosLista.size() > indexSelecionados; indexSelecionados++){
            int tentativas = 1;
            boolean atendeu = false;
            boolean continuarTentando = true;
            do {
                atendeu = ligar();
                tentativas ++;
                continuarTentando = !atendeu;
            } while (continuarTentando && tentativas < 3);
            if (atendeu) {
                System.out.println("conseguimos contato com o " + selecionadosLista.get(indexSelecionados) + " depois de " + tentativas + " tentativas");
            }else{
                System.out.println("não conseguimos entrar em contato com o " + selecionadosLista.get(indexSelecionados));
            }
        }
    }

    static int valorPretendido() {
        return ThreadLocalRandom.current().nextInt(1800, 2200);
    }
    static boolean ligar() {
        return new Random().nextInt(3) == 1;
    }
}
