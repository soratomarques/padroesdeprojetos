package com.example.dev.fretex;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by dev on 15/04/2018.
 */

public class CepListener implements TextWatcher {
    private Context context;

    public CepListener(Context context){
        this.context = context;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }
    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void afterTextChanged(Editable editable) {
        String cep = editable.toString();
        if(editable.length() == 8){
            new CepRequest((CadastroActivity) context).execute();
        }

    }
}
