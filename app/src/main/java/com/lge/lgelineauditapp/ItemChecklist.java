package com.lge.lgelineauditapp;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemChecklist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_checklist);

        Button btnCriarItem = (Button) findViewById(R.id.btnCriarItem);

        btnCriarItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    final Context context = v.getContext();
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    final View formElementsView = inflater.inflate(R.layout.form_item, null, false);
                    final EditText edtSecao = (EditText) formElementsView.findViewById(R.id.edtSecao);
                    final EditText edtItem = (EditText) formElementsView.findViewById(R.id.edtItem);
                    final EditText edtDetalhe = (EditText) formElementsView.findViewById(R.id.edtDetalhe);
                    final EditText edtEspecificacao = (EditText) formElementsView.findViewById(R.id.edtEspecificacao);
                    final EditText edtLinha = (EditText) formElementsView.findViewById(R.id.edtLinha);
                    final EditText edtPeso = (EditText) formElementsView.findViewById(R.id.edtPeso);

                    new AlertDialog.Builder(context)
                            .setView(formElementsView)
                            .setTitle("Criar Item do Checklist")
                            .setPositiveButton("Incluir",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String secao = edtSecao.getText().toString();
                                            String item = edtItem.getText().toString();
                                            String detalhe = edtDetalhe.getText().toString();
                                            String especificacao = edtEspecificacao.getText().toString();
                                            String linha = edtLinha.getText().toString();
                                            int peso = Integer.parseInt(edtPeso.getText().toString());

                                            ClassItemChecklist itemChecklist = new ClassItemChecklist();
                                            itemChecklist.setSecao(secao);
                                            itemChecklist.setItem(item);
                                            itemChecklist.setDetalhe(detalhe);
                                            itemChecklist.setEspecificacao(especificacao);
                                            itemChecklist.setLinha(linha);
                                            itemChecklist.setPeso(peso);

                                            LineAuditREST iItensREST = LineAuditREST.retrofit.create(LineAuditREST.class);
                                            final Call<Void> call = iItensREST.postItem(itemChecklist);
                                            call.enqueue(new Callback<Void>() {
                                                @Override
                                                public void onResponse(Call<Void> call, Response<Void> response) {
                                                    Toast.makeText(getBaseContext(), "Item inserido com sucesso", Toast.LENGTH_SHORT).show();
                                                }

                                                @Override
                                                public void onFailure(Call<Void> call, Throwable t) {
                                                    Toast.makeText(getBaseContext(), "Não foi possível fazer a conexão", Toast.LENGTH_SHORT).show();
                                                }
                                            });
                                        }
                                    }
                            ).show();
            }
        });
    }
}
