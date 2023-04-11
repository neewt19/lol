package Garagem;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class CarroMain {

    public static void main(String[] args) {

        ArrayList<CarroClass> carros = new ArrayList<>();

        CarroClass c1 = new CarroClass();
        System.out.println("Adicione um carro a sua garagem: ");
        c1.setMarca(JOptionPane.showInputDialog("Diga a marca do seu carro"));
        c1.setModelo(JOptionPane.showInputDialog("Diga o modelo"));
        c1.setAno(Integer.parseInt(JOptionPane.showInputDialog("Diga o ano:")));
        c1.setCombustivel(Double.parseDouble(JOptionPane.showInputDialog("Quantos litros de combustível tem no carro?")));
        c1.setKmInicial(Double.parseDouble(JOptionPane.showInputDialog("Quantos km rodados?")));

        carros.add(c1);

        System.out.println(c1.detalhes());

        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 6) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                    Escolha uma opção:
                    1 - Adicionar carro
                    2 - Remover carro
                    3 - Listar carros
                    4 - Rodar com um carro
                    5 - Abastecer um carro
                    6 - Sair"""));
            switch (opcao) {
                case 1 -> {
                    CarroClass novoCarro = new CarroClass();
                    System.out.println("Adicione um carro a sua garagem: ");
                    novoCarro.setMarca(JOptionPane.showInputDialog("Diga a marca do seu carro"));
                    novoCarro.setModelo(JOptionPane.showInputDialog("Diga o modelo"));
                    novoCarro.setAno(Integer.parseInt(JOptionPane.showInputDialog("Diga o ano:")));
                    novoCarro.setCombustivel(Double.parseDouble(JOptionPane.showInputDialog("Quantos litros de combustível tem no carro?")));
                    novoCarro.setKmInicial(Double.parseDouble(JOptionPane.showInputDialog("Quantos km rodados?")));
                    carros.add(novoCarro);
                    System.out.println(novoCarro.detalhes());
                }
                case 2 -> {
                    if (carros.size() > 0) {
                        System.out.println("Escolha um carro para remover: ");
                        for (int i = 0; i < carros.size(); i++) {
                            System.out.println(i + " - " + carros.get(i).detalhes());
                        }
                        int escolha = entrada.nextInt();
                        carros.remove(escolha);
                        System.out.println("Carro removido com sucesso!");
                    } else {
                        System.out.println("Não há carros na garagem.");
                    }
                }
                case 3 -> {
                    if (carros.size() > 0){
                        for (int i = 0; i < carros.size(); i++) {
                            System.out.printf("[%d] %s %s \n", i + 1,carros.get(i).getMarca() , carros.get(i).getModelo());
                        }
                    }else {
                        System.out.println("Não há carros na garagem");
                    }
                }
                case 4 -> {
                    if (carros.size() > 0){
                        System.out.println("escolha um carro para usar");
                        for (int i = 0; i < carros.size(); i++) {
                            System.out.printf("[%d] %s \n", i + 1, carros.get(i).getModelo());
                        }
                        int escolha = Integer.parseInt(JOptionPane.showInputDialog("Escolha um carro para usar"));
                        double kmfin = Double.parseDouble(JOptionPane.showInputDialog("Quantos km vc vai rodar?"));

                        if (carros.get(escolha-1).getCombustivel() <=0){
                            System.out.println("Não tem combustível");
                        }else {
                            carros.get(escolha-1).setKmInicial(carros.get(escolha-1).getKmInicial() + kmfin);
                            System.out.println("Seu carro já andou: "+ carros.get(escolha-1).getKmInicial()+" Km");
                        }
                    }else {
                        System.out.println("Não há carros na garagem");
                    }
                }
                case 5 -> {
                    if (carros.size() > 0){
                        for (int i = 0; i < carros.size(); i++) {
                            System.out.printf("[%d] %s \n", i + 1, carros.get(i).getModelo());
                        }
                        int escolha = Integer.parseInt(JOptionPane.showInputDialog("Escolha um carro para usar"));
                        carros.get(escolha-1).abastecer(Double.parseDouble(JOptionPane.showInputDialog("Quantos litros vai colocar?")));
                        System.out.println("Seu carro tem "+ carros.get(escolha-1).getCombustivel()+" litros");
                    }else {
                        System.out.println("Não há carros na garagem");
                    }
                }
                case 6 -> System.out.println("Programa encerrado.");
                default -> System.out.println("Opção inválida.");
            }
        }
        entrada.close();
    }
}
