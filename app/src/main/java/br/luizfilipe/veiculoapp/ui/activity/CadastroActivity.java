package br.luizfilipe.veiculoapp.ui.activity;

import static br.luizfilipe.veiculoapp.ui.activity.ConstantesActivities.CHAVE_VEICULO;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.luizfilipe.veiculoapp.R;
import br.luizfilipe.veiculoapp.model.Veiculo;
import br.luizfilipe.veiculoapp.repository.Dados;

public class CadastroActivity extends AppCompatActivity {

    EditText campoNome;
    EditText campoMarca;
    EditText campoAno;
    Button btnNovo;
    ImageView btnClose;
    private Veiculo veiculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        setComponents();
        configuraBotoes();
        carregaVeiculo();
    }

    private void setComponents() {
        campoNome = findViewById(R.id.campoNome);
        campoMarca = findViewById(R.id.campoMarca);
        campoAno = findViewById(R.id.campoAno);
        btnNovo = findViewById(R.id.button_novo_cadastro);
        btnClose = findViewById(R.id.btn_close);
    }

    private void configuraBotoes() {
        btnClose.setOnClickListener(v -> {
            finish();
        });

        btnNovo.setOnClickListener(v -> {
            String nomeVeiculo = campoNome.getText().toString();
            String marcaVeiculo = campoMarca.getText().toString();
            String anoVeiculo = campoAno.getText().toString();

            if (nomeVeiculo.isEmpty() && marcaVeiculo.isEmpty() && anoVeiculo.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }
            if(veiculo != null){
                veiculo.setNome(nomeVeiculo);
                veiculo.setMarca(marcaVeiculo);
                veiculo.setAno(anoVeiculo);
                Dados.getInstance().atualizar(veiculo);
                Toast.makeText(this, "Veiculo atualizado", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Veiculo novoVeiculo = new Veiculo();
                novoVeiculo.setNome(nomeVeiculo);
                novoVeiculo.setMarca(marcaVeiculo);
                novoVeiculo.setAno(anoVeiculo);
                Dados.getInstance().salvar(novoVeiculo);
                Log.i("Save", "configuraBotoes: " + novoVeiculo);
                Toast.makeText(this, "Veiculo cadastrado com sucesso", Toast.LENGTH_SHORT).show();
            }
            finish();
        });

    }

    private void carregaVeiculo() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_VEICULO)) {
            TextView title = findViewById(R.id.title);
            title.setText("Editar Veiculo");
            btnNovo.setText("Salvar");
            veiculo = (Veiculo) intent.getSerializableExtra(CHAVE_VEICULO);
            preencheCampos();
        } else {
            veiculo = null;
        }
    }

    private void preencheCampos() {
        campoNome.setText(veiculo.getNome());
        campoMarca.setText(veiculo.getMarca());
        campoAno.setText(veiculo.getAno());
    }
}