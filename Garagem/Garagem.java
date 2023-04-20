package Garagem;

import javax.swing.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Garagem extends CarroClass {
    Pattern patternInt = Pattern.compile("[0-9]{0,10}");
    Pattern patternString = Pattern.compile("[a-zA-Z]{1,10}");
    ArrayList<CarroClass> carros = new ArrayList<>();
    CarroClass novoCarro = new CarroClass();
    public void AdicionarCarro(){
        System.out.println("Adicione um carro a sua garagem: ");
        novoCarro.setMarca(JOptionPane.showInputDialog("Diga a marca do seu carro"));
        novoCarro.setModelo(JOptionPane.showInputDialog("Diga o modelo"));
        novoCarro.setAno(Integer.parseInt(JOptionPane.showInputDialog("Diga o ano:")));
        novoCarro.setPlaca(JOptionPane.showInputDialog("Qual a placa? "));
        novoCarro.setCombustivel(Double.parseDouble(JOptionPane.showInputDialog("Quantos litros de combustível tem no carro?")));
        novoCarro.setKmInicial(Double.parseDouble(JOptionPane.showInputDialog("Quantos km rodados?")));
        carros.add(novoCarro);
        System.out.println(novoCarro.detalhes());
    }

    public void RemoverCarro(){
        if (carros.size() > 0) {
            for (int i = 0; i < carros.size(); i++) {
                System.out.println(i + " - " + carros.get(i).detalhes());
            }
            boolean loop = false;
            while (!loop){
                String escolha = String.valueOf(Integer.parseInt(JOptionPane.showInputDialog("Escolha um carro para remover")));
                int escolhaTest = Integer.parseInt(escolha);
                if (!patternInt.matcher(escolha).matches()){
                    System.out.println("isso não é um numero");
                    break;
                }else {
                    if (carros.size() > escolhaTest){
                        carros.remove(escolhaTest);
                        System.out.println("Carro removido com sucesso!");
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

    public void DetalhesList(){
        if (carros.size() > 0){

            for (int i =0;carros.size() < i;i++){
                System.out.printf("""
                Carro[%d]:
                          marca:%s
                          modelo:%s
                          ano:%d
                          Placa:%s""",i,carros.get(i).getMarca(),carros.get(i).getModelo(),carros.get(i).getAno(),carros.get(i).getPlaca());
            }
        }else {
            System.out.println("lol");
        }
    }

    public void RodarCCarro(){
        if (carros.size() > 0){
            System.out.println("escolha um carro para usar");
            for (int i = 0; i < carros.size(); i++) {
                System.out.printf("[%d] %s \n", i + 1, carros.get(i).getModelo());
            }

            int escolha = Integer.parseInt(JOptionPane.showInputDialog("Escolha um carro para andar"));
            double kmfin = Double.parseDouble(JOptionPane.showInputDialog("Quantos km vc vai rodar?"));

            if (carros.get(escolha-1).getCombustivel() <=0){
                System.out.println("Não tem combustível");
            }else {
                carros.get(escolha-1).setKmInicial(carros.get(escolha-1).getKmInicial() + kmfin);
                double litros = carros.get(escolha-1).getCombustivel() - ((kmfin/0.5)/carros.get(escolha-1).getCombustivel());
                carros.get(escolha - 1).setCombustivel(litros);
                System.out.println("Seu carro já andou: "+ carros.get(escolha-1).getKmInicial()+" Km");
                System.out.printf("Ele ainda tem: %.1f Litros\n",carros.get(escolha-1).getCombustivel());
            }

        }else {
            System.out.println("Não há carros na garagem");
        }

    }
    public void abastecerCarro(){
        if (carros.size() > 0){
            for (int i = 0; i < carros.size(); i++) {
                System.out.printf("[%d] %s \n", i + 1, carros.get(i).getModelo());
            }
            int escolha = Integer.parseInt(JOptionPane.showInputDialog("Escolha um carro para abastecer"));
            carros.get(escolha-1).abastecer(Double.parseDouble(JOptionPane.showInputDialog("Quantos litros vai colocar?")));
            System.out.println("Seu carro tem "+ carros.get(escolha-1).getCombustivel()+" litros");
        }else {
            System.out.println("Não há carros na garagem");
        }
    }
}
