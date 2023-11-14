import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Hotel {
    private ArrayList<Hospede> hospedes;
    private ArrayList<Quarto> quartos;
    private ArrayList<Hospedagem> hospedagens;

    public Hotel() {
        hospedes = new ArrayList<>();
        quartos = new ArrayList<>();
        hospedagens = new ArrayList<>();
    }

    //////////////////////////////////////////////// Hospedes //////////////////////////////////////////////////////////

    public void cadastrarHospedes(String nome, String cpf, int idadeHospede) {
        Hospede hospede = new Hospede(nome, cpf, idadeHospede);
        hospedes.add(hospede);
        JOptionPane.showMessageDialog(null, "Hospede cadastrado com sucesso!");

        
    }

    public void editarHospede(String cpf, String novoNome) {
        Hospede hospede = buscarHospede(cpf);
        if (hospede != null) {
            hospede.setNome(novoNome);
            JOptionPane.showMessageDialog(null, "Hóspede editado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Hóspede não encontrado!");
        }
    }

    public void excluirHospede(String cpf) {
        Hospede hospede = buscarHospede(cpf);
        if (hospede != null) {
            hospedes.remove(hospede);
            JOptionPane.showMessageDialog(null, "Hóspede excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Hóspede não encontrado.");
        }
    }


    

    public void listarHospedes() {
        StringBuilder mensagem = new StringBuilder("–––––– Lista de Hospedes ––––––\n");
        for (Hospede hospede : hospedes) {
            mensagem.append("Nome: ").append(hospede.getNome()).append("\n");
            mensagem.append("CPF: ").append(hospede.getCpf()).append("\n");
            mensagem.append("Idade: ").append(hospede.getIdade()).append("\n");
            mensagem.append("––––––––––––––––––––––––––––––––––\n");

    

        }
        JOptionPane.showMessageDialog(null, mensagem.toString());
    }

    //////////////////////////////////////////////// Quartos //////////////////////////////////////////////////////

    public void cadastrarQuartos(String tipoQuarto, String tamanhoQuarto, double valorQuarto, int numeroQuarto) {
        Quarto quarto = new Quarto(tipoQuarto, tamanhoQuarto, valorQuarto, numeroQuarto);
        quartos.add(quarto);
        JOptionPane.showMessageDialog(null, "Quarto cadastrado com sucesso!");
    }

    public void editarQuarto(int numeroQuarto, double novoValorQuarto) {
        Quarto quarto = buscarQuarto(numeroQuarto);
        if (quarto != null) {
            quarto.setValorQuarto(novoValorQuarto);
            JOptionPane.showMessageDialog(null, "Quarto editado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Quarto não encontrado.");
        }
    }

    public void excluirQuartos(int numeroQuarto) {
        Quarto quarto = buscarQuarto(numeroQuarto);
        if (quarto != null) {
            quartos.remove(quarto);
            JOptionPane.showMessageDialog(null, "Quarto excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Quarto não encontrado.");
        }
    }

  

    public void listarQuartos() {
        StringBuilder mensagem = new StringBuilder("–––––– Lista de Quartos ––––––\n");
        for (Quarto quarto : quartos) {
            mensagem.append("Número: ").append(quarto.getNumeroQuarto()).append("\n");
            mensagem.append("Tamanho de Quarto: ").append(quarto.getTamanhoQuarto()).append("\n");
            mensagem.append("Tipo de Quarto: ").append(quarto.getTipoQuarto()).append("\n");
            mensagem.append("Valor da Diária: ").append(quarto.getValorQuarto()).append("\n");
            mensagem.append("––––––––––––––––––––––––––––––––––\n");
        }
        JOptionPane.showMessageDialog(null, mensagem.toString());
    }

    //////////////////////////////////////////////// Check-in ////////////////////////////////////////////////////

    public void realizarCheckin(String cpf, int numeroQuarto, int dias) {
        Hospede hospede = buscarHospede(cpf);
        Quarto quarto = buscarQuarto(numeroQuarto);

        if (hospede == null || quarto == null) {
            JOptionPane.showMessageDialog(null, "Hóspede ou quarto não encontrado.");
            return;
        }

        if (quartoOcupado(quarto)) {
            JOptionPane.showMessageDialog(null, "Quarto já ocupado.");
            return;
        }
        

        Hospedagem hospedagem = new Hospedagem(hospede, quarto, dias);
        hospedagens.add(hospedagem);
        hospedagem.realizarCheckin();
        JOptionPane.showMessageDialog(null, "Check-in realizado com sucesso!");

        
    }

    //////////////////////////////////////////////// Check-out /////////////////////////////////////////////////////


    public void realizarCheckout(int numeroQuarto) {
        Quarto quarto = buscarQuarto(numeroQuarto);

        if (quarto == null) {
            JOptionPane.showMessageDialog(null, "Quarto não encontrado.");
            return;
        }

        Hospedagem hospedagem = buscarHospedagem(quarto);

        if (hospedagem == null || !hospedagem.isCheckin()) {
            JOptionPane.showMessageDialog(null, "Não há hospedagem ativa para o quarto.");
            return;
        }

        double valorTotal = quarto.getValorQuarto() * hospedagem.getDias();
        hospedagem.realizarCheckout();
        JOptionPane.showMessageDialog(null, "Valor total da estadia: R$" + valorTotal);   
        JOptionPane.showMessageDialog(null, "Check-out realizado com sucesso!");
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private Hospede buscarHospede(String cpf) {
        for (Hospede hospede : hospedes) {
            if (hospede.getCpf().equals(cpf)) {
                return hospede;
            }
        }
        return null;
    }

    private Quarto buscarQuarto(int numero) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumeroQuarto() == numero) {
                return quarto;
            }
        }
        return null;
    }

    private Hospedagem buscarHospedagem(Quarto quarto) {
        for (Hospedagem hospedagem : hospedagens) {
            if (hospedagem.getQuarto().equals(quarto) && !hospedagem.isCheckout()) {
                return hospedagem;
            }
        }
        return null;
    }


    private boolean quartoOcupado(Quarto quarto) {
        for (Hospedagem hospedagem : hospedagens) {
            if (hospedagem.getQuarto().equals(quarto) && !hospedagem.isCheckout()) {
                return true;
            }
        }
        return false;
    }
}
