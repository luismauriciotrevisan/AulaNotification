package com.example.a2etapa_aulanotification;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button bt = (Button)findViewById(R.id.bt_1_view);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        TextView tv = (TextView)findViewById(R.id.tv_1_view);
        tv.setText("Usuário abriu a notificação. Por isso esta nova tela foi aberta!!!");



        //Você pode cancelar a Notificação aqui, ja que o usuario ja a leu
        //e uma nova tela fo i aberta, não há porque manter a notificação na barra de status
        //Experimente
    }
}
