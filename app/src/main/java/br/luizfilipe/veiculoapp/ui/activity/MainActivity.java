package br.luizfilipe.veiculoapp.ui.activity;

import static br.luizfilipe.veiculoapp.ui.activity.ConstantesActivities.CHAVE_VEICULO;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.util.List;

import br.luizfilipe.veiculoapp.R;
import br.luizfilipe.veiculoapp.model.Veiculo;
import br.luizfilipe.veiculoapp.repository.Dados;
import br.luizfilipe.veiculoapp.ui.adapter.VeiculoAdapter;

public class MainActivity extends AppCompatActivity {
    Button btnNovo;
    Button btnSair;
    ArrayAdapter<Veiculo> adapter;
    GridView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setComponents();
        configuraBotoes();
        configuraLista();

        exibirDialogoBoasVindas();
    }

    private void exibirDialogoBoasVindas() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Bem-vindo(a)!");
        builder.setMessage("Obrigado por usar o VeiculoApp. Explore suas funcionalidades para gerenciar seus veículos.");
        builder.setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.dismiss());
        builder.setCancelable(false);
        builder.show();
    }

    private void setComponents(){
        btnNovo = findViewById(R.id.button_novo);
        btnSair = findViewById(R.id.button_sair);
    }

    private void configuraLista(){
        lista = findViewById(R.id.lista);
        configuraAdapter();
        configuraListenerDeCliquePorItem(lista);
    }

    private void configuraAdapter() {
        List<Veiculo> veiculoList = Dados.getInstance().getVeiculoList();
        Log.i("ListaDeVeiculos", "configuraAdapter: " + veiculoList);
        adapter = new VeiculoAdapter(this, veiculoList);
        lista.setAdapter(adapter);
    }


    private void configuraBotoes(){
        btnNovo.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CadastroActivity.class)));
        btnSair.setOnClickListener(v -> finish());
    }

    private void configuraListenerDeCliquePorItem(GridView listaDeAlunos) {
        listaDeAlunos.setOnItemClickListener(((adapterView, view, position, id) -> {
            Veiculo veiculo = (Veiculo) adapterView.getItemAtPosition(position);
            abreFormularioModoEditaVeiculo(veiculo);
        }));
    }

    private void abreFormularioModoEditaVeiculo(Veiculo veiculo) {
        Intent abreCadastroAcitivity = new Intent(MainActivity.this, CadastroActivity.class);
        abreCadastroAcitivity.putExtra(CHAVE_VEICULO, veiculo);
        startActivity(abreCadastroAcitivity);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}