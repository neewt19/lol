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
        Pattern patternDouble = Pattern.compile("[0-90.0-9.0]{1,10}");
        Pattern patternString = Pattern.compile("[a-zA-Z0-9 ]{1,10}");
        Pattern patternPlaca = Pattern.compile("[A-Z]{4}[0-9]{4}");
        Pattern patternAno = Pattern.compile("[0-9]{4}");

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
            while (opcao == null){
                opcao = String.valueOf(6);
            }
            switch (opcao) {
                case "1" -> {
                    System.out.println("Adicione um carro a sua garagem: ");
                    String marc = JOptionPane.showInputDialog("Diga a marca do seu carro");
                    while (marc == null){
                        System.out.println("Marca inválida");
                        break;
                    }
                    while (!patternString.matcher(marc).matches()){
                        System.out.println("Marca inválida");
                        marc = JOptionPane.showInputDialog("Diga a marca do seu carro");
                        while (marc == null){
                            System.out.println("Marca inválida");
                            marc = JOptionPane.showInputDialog("Diga a marca do seu carro");
                        }
                    }

                    String mod = JOptionPane.showInputDialog("Diga o modelo");
                    while (mod == null){
                        System.out.println("Modelo inválido");
                        mod = JOptionPane.showInputDialog("Diga o modelo");
                    }
                    while (!patternString.matcher(mod).matches()){
                        System.out.println("Modelo inválido");
                        mod = JOptionPane.showInputDialog("Diga o modelo");
                        while (mod == null){
                            System.out.println("Modelo inválido");
                            mod = JOptionPane.showInputDialog("Diga o modelo");
                        }
                    }

                    String ano = JOptionPane.showInputDialog("Diga o ano:");
                    while (ano == null){
                        System.out.println("Ano inválido");
                        ano = JOptionPane.showInputDialog("Diga o ano:");
                    }
                    while (!patternAno.matcher(ano).matches()){
                        System.out.println("Ano inválido");
                        ano = JOptionPane.showInputDialog("Diga o ano:");
                        while (ano == null){
                            System.out.println("Ano inválido");
                            ano = JOptionPane.showInputDialog("Diga o ano:");
                        }
                    }

                    String placa = JOptionPane.showInputDialog("Qual a placa? ");
                    while (placa == null){
                        System.out.println("Placa inválida");
                        placa = JOptionPane.showInputDialog("Qual a placa? ");
                    }
                    while (!patternPlaca.matcher(placa).matches()){
                        System.out.println("Placa inválida");
                        placa = JOptionPane.showInputDialog("Qual a placa? ");
                        while (placa == null){
                            System.out.println("Placa inválida");
                            placa = JOptionPane.showInputDialog("Qual a placa? ");
                        }
                    }

                    String combustivel = JOptionPane.showInputDialog("Quantos litros de combustível tem no carro?");
                    while (combustivel == null){
                        System.out.println("Combustível inválido");
                        combustivel = JOptionPane.showInputDialog("Quantos litros de combustível tem no carro?");
                    }
                    while (!patternDouble.matcher(combustivel).matches()){
                        System.out.println("Combustível inválido");
                        combustivel = JOptionPane.showInputDialog("Quantos litros de combustível tem no carro?");
                        while (combustivel == null){
                            System.out.println("Combustível inválido");
                            combustivel = JOptionPane.showInputDialog("Quantos litros de combustível tem no carro?");
                        }
                    }

                    String km = JOptionPane.showInputDialog("Quantos km rodados?");
                    while (km == null){
                        System.out.println("Km inválido");
                        km = JOptionPane.showInputDialog("Quantos km rodados?");
                    }
                    while (!patternDouble.matcher(km).matches()){
                        System.out.println("Km inválido");
                        km = JOptionPane.showInputDialog("Quantos km rodados?");
                        while (km == null){
                            System.out.println("Km inválido");
                            km = JOptionPane.showInputDialog("Quantos km rodados?");
                        }
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
                            System.out.printf("carro[%d] %s %s\n",num, carros.get(i).getMarca(),carros.get(i).getModelo());
                        }
                        boolean loop = false;
                        while (!loop){
                            String escolha = JOptionPane.showInputDialog("Escolha um carro para remover");
                            while (escolha == null){
                                System.out.println("Carro inválido");
                                escolha = JOptionPane.showInputDialog("Escolha um carro para remover");
                            }
                            int escolhaTest = Integer.parseInt(escolha);
                            while (!patternInt.matcher(escolha).matches()){
                                System.out.println("isso não é um numero");
                                escolha = JOptionPane.showInputDialog("Escolha um carro para remover");
                                while (escolha == null){
                                    System.out.println("Carro inválido");
                                    escolha = JOptionPane.showInputDialog("Escolha um carro para remover");
                                }
                            }
                            if (carros.size() >= escolhaTest){
                                escolhaTest = escolhaTest -1;
                                System.out.println("carro removido com sucesso");
                                carros.remove(escolhaTest);
                                loop = true;
                            }else {
                                System.out.println("Carro não existe");
                                loop = true;
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
                        while (escolha == null){
                            System.out.println("Carro inválido");
                            escolha =JOptionPane.showInputDialog("Escolha um carro para andar");
                        }
                        while (!patternInt.matcher(escolha).matches()){
                            System.out.println("Carro inválido");
                            escolha =JOptionPane.showInputDialog("Escolha um carro para andar");
                            while (escolha == null){
                                System.out.println("Carro inválido");
                                escolha =JOptionPane.showInputDialog("Escolha um carro para andar");
                            }
                        }

                        int escolha1 = Integer.parseInt(escolha)-1;

                        int num = Integer.parseInt(escolha);

                        if (num <= carros.size()) {
                            String kmfin2 = JOptionPane.showInputDialog("Quantos km vc vai rodar?");

                            while (kmfin2 == null){
                                System.out.println("Km inválido");
                                kmfin2 = JOptionPane.showInputDialog("Quantos km vc vai rodar?");
                            }
                            while (!patternDouble.matcher(kmfin2).matches()){
                                System.out.println("Km inválido");
                                kmfin2 = JOptionPane.showInputDialog("Quantos km vc vai rodar?");
                                while (kmfin2 == null){
                                    System.out.println("Km inválido");
                                    kmfin2 = JOptionPane.showInputDialog("Quantos km vc vai rodar?");
                                }
                            }

                            double kmfin = Double.parseDouble(kmfin2);
                            double kmfin1 = kmfin;

                            if (carros.get(escolha1).getCombustivel() <= 0) {
                                System.out.println("Não tem combustível");
                            } else {
                                double litros = carros.get(escolha1).getCombustivel();
                                double kmteste =0;
                                while (kmfin > 0) {
                                    litros = litros - 0.1;
                                    kmfin -= 1;
                                    kmteste +=1;
                                    if (litros <= 0){
                                        kmfin = 0;
                                        kmteste -= 1;
                                        litros = 0;
                                    }
                                }
                                carros.get(escolha1).setCombustivel(litros);

                                if (carros.get(escolha1).getCombustivel() <=0){
                                    double Km = carros.get(escolha1).setKmInicial(carros.get(escolha1).getKmInicial() + kmteste);
                                    System.out.println("combustível acabou e seu carro parou");
                                    System.out.printf("Ele ainda tem: %.1f Litros\n", litros);
                                    System.out.println("Seu carro já andou: " + Km + " Km");
                                }else {
                                    double Km = carros.get(escolha1).setKmInicial(carros.get(escolha1).getKmInicial() + kmfin1);
                                    System.out.println("Seu carro já andou: " + Km + " Km");
                                    System.out.printf("Ele ainda tem: %.1f Litros\n", litros);
                                }
                            }
                        } else {
                            System.out.println("esse carro não existe na garagem");
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
                        while (escolha == null){
                            System.out.println("Carro inválido");
                            escolha = JOptionPane.showInputDialog("Escolha um carro para abastecer");
                        }
                        while (!patternInt.matcher(escolha).matches()){
                            System.out.println("Carro inválido");
                            escolha = JOptionPane.showInputDialog("Escolha um carro para abastecer");
                            while (escolha == null){
                                System.out.println("Carro inválido");
                                escolha = JOptionPane.showInputDialog("Escolha um carro para abastecer");
                            }
                        }

                        int escolha1 = Integer.parseInt(escolha) -1;
                        int num = Integer.parseInt(escolha);
                        if (num <= carros.size()) {
                            String abastecer = JOptionPane.showInputDialog("Quantos litros vai colocar?");
                            while (abastecer == null){
                                System.out.println("combustivel inválido");
                                abastecer = JOptionPane.showInputDialog("Quantos litros vai colocar?");
                            }
                            while (!patternDouble.matcher(abastecer).matches()){
                                System.out.println("combustivel inválido");
                                abastecer = JOptionPane.showInputDialog("Quantos litros de combustível tem no carro?");
                                while (abastecer == null){
                                    System.out.println("combustivel inválido");
                                    abastecer = JOptionPane.showInputDialog("Quantos litros vai colocar?");
                                }
                            }
                            double abs1 = Double.parseDouble(abastecer);
                            carros.get(escolha1).abastecer(abs1);
                            System.out.println("Seu carro tem "+ carros.get(escolha1).getCombustivel()+" litros");
                        }else {
                            System.out.println("esse carro não existe na garagem");
                        }
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
