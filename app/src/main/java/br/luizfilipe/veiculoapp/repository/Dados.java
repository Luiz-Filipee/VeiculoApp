package br.luizfilipe.veiculoapp.repository;

import java.util.LinkedList;
import java.util.List;

import br.luizfilipe.veiculoapp.model.Veiculo;

public class Dados {
    public List<Veiculo> veiculoList;
    public static Dados dados;

    private Dados(){ veiculoList = new LinkedList<>();}

    public static Dados getInstance(){
        if(dados==null)
            dados = new Dados();
        return dados;
    }

    public void salvar(Veiculo veiculo){
        veiculoList.add(veiculo);
    }

    public List<Veiculo> getVeiculoList(){
        return veiculoList;
    }

    public void atualizar(Veiculo veiculo) {
        for (int i = 0; i < veiculoList.size(); i++) {
            if(veiculoList.get(i).getId().equals(veiculo.getId())){
                veiculoList.set(i, veiculo);
                break;
            }
        }
    }

    public void remover(Veiculo veiculo) {
        veiculoList.removeIf(v -> v.getId().equals(veiculo.getId()));
    }
}
