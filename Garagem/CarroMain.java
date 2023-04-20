package Garagem;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class CarroMain {

    public static void main(String[] args) {
        Garagem garagem = new Garagem();

        ArrayList<CarroClass> carros = new ArrayList<>();
        Pattern patternInt = Pattern.compile("[0-9]{0,10}");
        Pattern patternDouble = Pattern.compile("[0-90.0-9.0]{0,10}");
        Pattern patternString = Pattern.compile("[a-zA-Z0-9 ]{1,10}");
        Pattern patternPlaca = Pattern.compile("[a-zA-Z0-9]{8}");

        Scanner entrada = new Scanner(System.in);
        String opcao = " ";
        while (!opcao.equals("6")) {
            opcao = JOptionPane.showInputDialog("""
                    Escolha uma opção:
                    1 - Adicionar carro
                    2 - Remover carro
                    3 - Listar carros
                    4 - Rodar com um carro
                    5 - Abastecer um carro
                    6 - Sair""");
            switch (opcao) {
                case "1" -> {
                    System.out.println("Adicione um carro a sua garagem: ");
                    String marc = JOptionPane.showInputDialog("Diga a marca do seu carro");
                    while (!patternString.matcher(marc).matches()){
                        System.out.println("marca inválida");
                        marc = JOptionPane.showInputDialog("Diga a marca do seu carro");
                    }
                    String mod = JOptionPane.showInputDialog("Diga o modelo");
                    if (!patternString.matcher(mod).matches()){
                        System.out.println("modelo inválido");
                        mod = JOptionPane.showInputDialog("Diga o modelo");
                    }
                    String ano = JOptionPane.showInputDialog("Diga o ano:");
                    while (!patternInt.matcher(ano).matches()){
                        System.out.println("Ano inválido");
                        ano = JOptionPane.showInputDialog("Diga o ano:");
                    }
                    String placa = JOptionPane.showInputDialog("Qual a placa? ");
                    while (!patternPlaca.matcher(placa).matches()){
                        System.out.println("deu certo POOORAA");
                        placa = JOptionPane.showInputDialog("Qual a placa? ");
                    }
                    String combustivel = JOptionPane.showInputDialog("Quantos litros de combustível tem no carro?");
                    while (!patternDouble.matcher(combustivel).matches()){
                        System.out.println("cpmbustivel inválido");
                        combustivel = JOptionPane.showInputDialog("Quantos litros de combustível tem no carro?");
                    }
                    String km = JOptionPane.showInputDialog("Quantos km rodados?");
                    while (!patternDouble.matcher(km).matches()){
                        System.out.println("km inválido");
                        km = JOptionPane.showInputDialog("Quantos km rodados?");
                    }

                    CarroClass novoCarro = new CarroClass();
                    novoCarro.setMarca(marc);
                    novoCarro.setModelo(mod);
                    novoCarro.setAno(Integer.parseInt(ano));
                    novoCarro.setPlaca(placa);
                    novoCarro.setCombustivel(Double.parseDouble(combustivel));
                    novoCarro.setKmInicial(Double.parseDouble(km));
                    carros.add(novoCarro);
                    System.out.println(novoCarro.detalhes());
                }
                case "2" -> {
                    if (carros.size() > 0) {
                        for (int i = 0; i < carros.size(); i++) {
                            int num = i+1;
                            System.out.println(num + " - " + carros.get(i).detalhes());
                        }
                        boolean loop = false;
                        while (!loop){
                            String escolha = JOptionPane.showInputDialog("Escolha um carro para remover");
                            int escolhaTest = Integer.parseInt(escolha) -1;
                            if (!patternInt.matcher(escolha).matches()){
                                System.out.println("isso não é um numero");
                                break;
                            }else {
                                if (carros.size() > escolhaTest){
                                    carros.remove(escolhaTest);
                                    System.out.printf("""
                                            Carro[%d]
                                                    Marca: %s
                                                    Modelo: %s
                                                    Placa: %s""",escolha,carros.get(escolhaTest).getMarca(),carros.get(escolhaTest).getModelo(),carros.get(escolhaTest).getPlaca());
                                    loop = true;
                                }else {
                                    System.out.println("Carro não existe");
                                    loop = true;
                                }
                            }
                        }
                    } else {
                        System.out.println("Não há carros na garagem.");
                    }
                }
                case "3" -> {
                    if (carros.size() > 0){
                        for (int i =0;carros.size() > i;i++){
                            int num = i+1;
                            System.out.printf("""
                Carro[%d]:
                          marca:%s
                          modelo:%s
                          ano:%d
                          Placa:%s\n""",num,carros.get(i).getMarca(),carros.get(i).getModelo(),carros.get(i).getAno(),carros.get(i).getPlaca());

                        }
                    }else {
                        System.out.println("Não há carros na garagem.");
                    }
                }
                case "4" -> {
                    if (carros.size() > 0) {
                        System.out.println("escolha um carro para usar");
                        for (int i = 0; i < carros.size(); i++) {
                            System.out.printf("[%d] %s \n", i + 1, carros.get(i).getModelo());
                        }
                        String escolha =JOptionPane.showInputDialog("Escolha um carro para andar");
                        while (!patternInt.matcher(escolha).matches()){
                            System.out.println("ERRO!");
                            escolha =JOptionPane.showInputDialog("Escolha um carro para andar");
                        }
                        int escolha1 = Integer.parseInt(escolha)-1;
                        if (escolha1 <= carros.size()) {
                            String kmfin2 = JOptionPane.showInputDialog("Quantos km vc vai rodar?");
                            while (!patternDouble.matcher(kmfin2).matches()){
                                System.out.println("ERRO");
                                kmfin2 = JOptionPane.showInputDialog("Quantos km vc vai rodar?");
                            }
                            double kmfin = Double.parseDouble(kmfin2);
                            if (carros.get(escolha1).getCombustivel() <= 0) {
                                System.out.println("Não tem combustível");
                            } else {
                                double Km = carros.get(escolha1).setKmInicial(carros.get(escolha1).getKmInicial() + kmfin);
                                double litros = carros.get(escolha1).getCombustivel();
                                while (kmfin > 0) {
                                    litros = litros - 0.1;
                                    kmfin -= 1;
                                }
                                carros.get(escolha1).setCombustivel(litros);
                                System.out.println("Seu carro já andou: " + Km + " Km");
                                System.out.printf("Ele ainda tem: %.1f Litros\n", litros);
                            }
                        } else {
                            System.out.println("Não há carros na garagem");
                        }
                    }else {
                        System.out.println("Não há carros na garagem");
                    }
                }
                case "5" -> {
                    if (carros.size() > 0){
                        for (int i = 0; i < carros.size(); i++) {
                            System.out.printf("[%d] %s \n", i + 1, carros.get(i).getModelo());
                        }
                        String escolha = JOptionPane.showInputDialog("Escolha um carro para abastecer");
                        if (!patternInt.matcher(escolha).matches()){
                            System.out.println("erro");
                            break;
                        }
                        int escolha1 = Integer.parseInt(escolha) -1;
                        carros.get(escolha1).abastecer(Double.parseDouble(JOptionPane.showInputDialog("Quantos litros vai colocar?")));
                        System.out.println("Seu carro tem "+ carros.get(escolha1).getCombustivel()+" litros");
                    }else {
                        System.out.println("Não há carros na garagem");
                    }
                }
                case "6" -> System.out.println("Programa encerrado.");
                default -> System.out.println("Opção inválida.");
            }
        }
        entrada.close();
    }
}
