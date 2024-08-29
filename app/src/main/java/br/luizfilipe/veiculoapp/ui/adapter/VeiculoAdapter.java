package br.luizfilipe.veiculoapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import br.luizfilipe.veiculoapp.R;
import br.luizfilipe.veiculoapp.model.Veiculo;

public class VeiculoAdapter  extends ArrayAdapter<Veiculo> {
    public VeiculoAdapter(@NonNull Context context, @NonNull List<Veiculo> veiculos) {
        super(context, 0, veiculos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_veiculo, parent, false);
        }

        Veiculo veiculo = getItem(position);

        TextView nomeVeiculo = convertView.findViewById(R.id.nome_veiculo);
        TextView marcaVeiculo = convertView.findViewById(R.id.marca_veiculo);
        TextView anoVeiculo = convertView.findViewById(R.id.ano_veiculo);

        if (veiculo != null) {
            nomeVeiculo.setText(veiculo.getNome());
            marcaVeiculo.setText(veiculo.getMarca());
            anoVeiculo.setText(String.valueOf(veiculo.getAno()));
        }

        return convertView;
    }
}
