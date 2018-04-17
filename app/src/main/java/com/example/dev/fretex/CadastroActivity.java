package com.example.dev.fretex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class CadastroActivity extends AppCompatActivity {

    private Spinner spinnerEstado;
    private EditText caixaCpf;
    private EditText caixaCep;
    private EditText caixaCidade;
    private EditText caixaLogradouro;
    private EditText caixaTelefone;
    private List CEPs;
    private  Util util;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        spinnerEstado = (Spinner) findViewById(R.id.spinner_estado_id);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this,R.array.listaEstado,android.R.layout.simple_spinner_item);
        spinnerEstado.setAdapter(arrayAdapter);

        caixaCpf = (EditText) findViewById(R.id.caixa_cpf_id);
        caixaCep = (EditText) findViewById(R.id.caixa_cep_id);
        caixaLogradouro = (EditText) findViewById(R.id.caixa_rua_id);
        caixaTelefone = (EditText) findViewById(R.id.caixa_telefone_id);
        String cpf = caixaCpf.toString().trim();
        ValidaCPF validarCpf = new ValidaCPF(cpf);
        caixaCidade = (EditText) findViewById(R.id.caixa_cidade_id);

        caixaCep.addTextChangedListener(new CepListener(this));

        caixaCpf.addTextChangedListener(MaskEditUtil.mask(caixaCpf,MaskEditUtil.FORMAT_CPF));
        //caixaCep.addTextChangedListener(MaskEditUtil.mask(caixaCep,MaskEditUtil.FORMAT_CEP));
        caixaTelefone.addTextChangedListener(MaskEditUtil.mask(caixaTelefone,MaskEditUtil.FORMAT_FONE));

        util = new Util(this,
                R.id.caixa_cep_id,
                R.id.caixa_cidade_id,
                R.id.caixa_bairro_id,
                R.id.caixa_rua_id,
                R.id.spinner_estado_id);

    }



    public  String getUriCep(){
        return "https://viacep.com.br/ws/"+caixaCep.getText()+"/json/";
    }

    public void lockFields(boolean isToLock){
        util.lockFields(isToLock);
    }

    public void setDataView(Cadastro cadastro){
        setFields(R.id.caixa_cidade_id,cadastro.getLocalidade());
        setFields(R.id.caixa_bairro_id,cadastro.getBairro());
        setFields(R.id.caixa_rua_id,cadastro.getLogradouro());
        setSpinner(R.id.spinner_estado_id,R.array.listaEstado,cadastro.getUf());
    }

    public  void setFields(int id,String data){
        EditText caixa = ((EditText) findViewById(id));
        caixa.setText(data);
    }

    public  void setSpinner(int id,int arrayId,String data){
        String[] itens = getResources().getStringArray(R.array.listaEstado);
        Spinner state = ((Spinner) findViewById(id));

        for(int i = 0; i < itens.length; i++){

            if(itens[i].endsWith("("+data+")")){
                state.setSelection(i);
                return;
            }
            state.setSelection(0);

        }
    }



        }




