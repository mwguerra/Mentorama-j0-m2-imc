import java.text.DecimalFormat;
import java.util.*;

public class ImcCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df2 = new DecimalFormat("#.##");
        String faixa = "Desconhecido";

        NavigableMap<Double, String> map = new TreeMap<>();

        map.put(16.0, "Muito abaixo do peso");
        map.put(17.0, "Abaixo do peso");
        map.put(18.5, "Peso normal");
        map.put(25.0, "Acima do peso");
        map.put(30.0, "Obesidade grau I");
        map.put(35.0, "Obesidade grau II");
        map.put(40.0, "Obesidade grau III");

        System.out.println("\n--- Calculadora IMC ---");

        System.out.print("Peso (kg): ");
        double peso = scanner.nextDouble();
        System.out.print("Altura (m): ");
        double altura = scanner.nextDouble();

        double imc = peso / (altura * altura);

        if (imc < 16) {
            System.out.println("Altura ou peso incompatíveis para o cálculo. IMC inferior a 16.");
            return;
        }

        for (Map.Entry<Double, String> entry : map.entrySet()) {
            Map.Entry<Double, String> next = map.higherEntry(entry.getKey());
            Map.Entry<Double, String> prev = map.lowerEntry(entry.getKey());

            if (imc < entry.getKey() && imc > prev.getKey()) {
                faixa = prev.getValue();
            }

            if (next == null && imc > entry.getKey()) {
                faixa = entry.getValue();
            }
        }

        System.out.println("IMC " + df2.format(imc) + " kg/m2 - " + faixa);
    }
}
