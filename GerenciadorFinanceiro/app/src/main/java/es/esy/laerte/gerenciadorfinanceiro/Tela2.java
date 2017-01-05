package es.esy.laerte.gerenciadorfinanceiro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Tela2 extends AppCompatActivity {

    //widgets

    private TextView etNome;
    private TextView etValor;
    private TextView etDataVencimento;
    private Spinner tipo;
    private RadioGroup rgStatus;
    private RadioButton rbPago;
    private RadioButton rbNaoPago;
    private Button btnSalvar;
    private Button btnCancelar;

    private String stringCadastro;

    //log
    private static final String TAG_LOG = "LogsMainActvity";
    //adapter
    private ArrayAdapter adapter;

    //objeto
    private Cadastro cad;

    //ArrayList
    private ArrayList<Cadastro> cadastro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        cadastro = new ArrayList<>();

        etNome = (TextView) findViewById(R.id.t2_et_nome);
        etValor = (TextView) findViewById(R.id.t2_et_valor);
        etDataVencimento = (TextView) findViewById(R.id.t2_et_data);
        tipo = (Spinner) findViewById(R.id.t2_spinner);
        rgStatus = (RadioGroup) findViewById(R.id.t2_rg_status);
        rbPago = (RadioButton) findViewById(R.id.t2_rb_sim);
        rbNaoPago = (RadioButton) findViewById(R.id.t2_rb_nao);
        btnSalvar = (Button) findViewById(R.id.t2_btn_salvar);
        btnCancelar = (Button) findViewById(R.id.t2_btn_cancelar);

        Log.d(TAG_LOG,"pegou refererencia tela 2");

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it = new Intent(Tela2.this, Tela1.class);
               // Bundle bundle = new Bundle();

                cad = new Cadastro();
                cad.setNome(etNome.getText().toString());
                cad.setValor(etValor.getText().toString());
                cad.setDataVenc(etDataVencimento.getText().toString());
                cad.setTipo(tipo.getSelectedItem().toString());
                if (rgStatus.getCheckedRadioButtonId() == rbNaoPago.getId()){
                    cad.setStatus(rbNaoPago.getText().toString());
                }else{
                    cad.setStatus(rbPago.getText().toString());
                }
                cadastro.add(cad);

                stringCadastro = cadastro.toString();

                it.putExtra("cadastro",stringCadastro);
                setResult(1, it);
                finish();

            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
