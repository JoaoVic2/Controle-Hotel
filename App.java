// Integrantes do Grupo: 

// João Marcelo T. ALmeida - RA: 323119157 
// João Victor - RA: 323124976 
// Hygor Souza Cravo - RA: 319133918
// Bruna Barosa de Oliveira - RA: 32318763
// Bruno Henrique S. Nunes - RA: 323119872
// Bruno Fernandes Tomé - RA: 32317977
// Arthur Samuel S Alves - RA: 323125493
// Gabriel Vitor Souza da Silva - RA: 323111123



import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        int opcao = 0;

        principalMenu: while (opcao != 5) {
            String menu = "–––––– Sistema de Gestão Hotel São Meubinlau ––––––\n"
                    + "1. Hospedes\n"
                    + "2. Quartos\n"
                    + "3. Check-in\n"
                    + "4. Check-out\n"
                    + "5. Sair\n"
                    + "–––––– Escolha uma opção ––––––";
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, menu));

            switch (opcao) {
                case 1:
                    int opcaoHospedes = 0;
                    do {
                        String menuHospede = "Hospedes\n"
                                + "1. Cadastrar Hóspede\n"
                                + "2. Editar Hóspede\n"
                                + "3. Excluir Hóspede\n"
                                + "4. Listar Hóspedes\n"
                                + "5. Voltar\n";
                        opcaoHospedes = Integer.parseInt(JOptionPane.showInputDialog(null, menuHospede));

                    switch (opcaoHospedes) {
                            case 1:
                                String nomeHospede = JOptionPane.showInputDialog(null, "Nome do Hóspede:");
                                String cpfHospede = JOptionPane.showInputDialog(null, "CPF do Hóspede:");
                                int idadeHospede = Integer
                                        .parseInt(JOptionPane.showInputDialog(null, "Idade do Hóspede:"));

                                hotel.cadastrarHospedes(nomeHospede, cpfHospede, idadeHospede);
                                break;

                            case 2:
                                cpfHospede = JOptionPane.showInputDialog(null, "CPF do Hóspede:");
                                String novoNomeHospede = JOptionPane.showInputDialog(null, "Novo nome do Hóspede:");
                                hotel.editarHospede(cpfHospede, novoNomeHospede);
                                break;

                            case 3:
                                cpfHospede = JOptionPane.showInputDialog(null, "CPF do Hóspede:");
                                hotel.excluirHospede(cpfHospede);
                                break;

                            case 4:
                                hotel.listarHospedes();
                                break;

                            case 5:
                                continue principalMenu;
                        }
                    } while (opcaoHospedes != 5);

                    break;

                case 2:
                    int opcaoQuartos = 0;
                    do {
                        String menuQuartos = "Quartos\n"
                                + "1. Cadastrar Quarto\n"
                                + "2. Editar Quarto\n"
                                + "3. Excluir Quarto\n"
                                + "4. Listar Quartos\n"
                                + "5. Voltar\n";
                        opcaoQuartos = Integer.parseInt(JOptionPane.showInputDialog(null, menuQuartos));

                        switch (opcaoQuartos) {
                            case 1:
                                String tipoQuarto = JOptionPane.showInputDialog(null, "Tipo do Quarto:");
                                String tamanhoQuarto = JOptionPane.showInputDialog(null, "Tamanho do Quarto:");
                                double valorQuarto = Double.parseDouble(JOptionPane.showInputDialog(null, "Valor da Hospedagem:"));
                                hotel.cadastrarQuartos(tipoQuarto, tamanhoQuarto, valorQuarto, opcao);
                                break;

                            case 2:
                                int numeroQuarto = Integer.parseInt(JOptionPane.showInputDialog(null, "Número do Quarto:"));
                                double novoValorDiaria = Double
                                        .parseDouble(JOptionPane.showInputDialog(null, "Novo valor da Diária:"));
                                hotel.editarQuarto(numeroQuarto, novoValorDiaria);
                                break;

                            case 3:
                                numeroQuarto = Integer.parseInt(JOptionPane.showInputDialog(null, "Número do Quarto:"));
                                hotel.excluirQuartos(numeroQuarto);
                                break;

                            case 4:
                                hotel.listarQuartos();
                                break;

                            case 5:
                                continue principalMenu;

                        }
                    } while (opcaoQuartos != 5);
                    break;

                case 3:
                    String cpfCheckin = JOptionPane.showInputDialog(null, "CPF do Hóspede:");
                    int numeroCheckin = Integer.parseInt(JOptionPane.showInputDialog(null, "Número do Quarto:"));
                    int dias = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o numero de Dias de hospedagem:"));
                    
                    hotel.realizarCheckin(cpfCheckin, numeroCheckin, dias);
                    break;

                case 4:
                    int numeroCheckout = Integer.parseInt(JOptionPane.showInputDialog(null, "Número do Quarto:"));
                    hotel.realizarCheckout(numeroCheckout);
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");
                    opcao = 5;
                    break;
            }
        }
    }

}