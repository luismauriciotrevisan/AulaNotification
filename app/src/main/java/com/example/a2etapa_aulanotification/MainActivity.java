package com.example.a2etapa_aulanotification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView)findViewById(R.id.tv_1_view);
        tv.setText("Uma notificação foi disparada");

        //Passo 1: Crie um Intent exlicito para chamar a Activity que exibirá a Notificação
        Intent intent = new Intent(this, SecondActivity.class);

        //Crie um método que recebe todos os parâmetros e exibe a notificação na barra de statua
        criarNotificacao(
                this,
                "NomeQuemEnviou",//no título colocamos, neste exemplo o remetente da msg -> titulo
                "Você está aprendendo a criar Notificações Android", // mensgem enviada é exibida se notificacao for aberta
                R.mipmap.ic_launcher,//icone a ser exibido
                1, //id da notificação deverá ser usado para cancelá-la
                intent); //intent a ser associada à notificação
    }

    // criarNotificacao: cria e exibe uma notificação na barra de statua
    // input
    //      context

    protected void criarNotificacao(Context context, CharSequence title,
                                    CharSequence message, int icon, int id, Intent intent){

        //Passo 1: Crie o PendingIntent para disparar o Intent ao se clicar a notificação
        //Note que o PendingIntent é criado sobre o Intent passado como parâmetro
        PendingIntent p = PendingIntent.getActivity(context, 0, intent, 0);

        //Passo 2.1: Instancie um objeto builder de notificação que será utilizado para construir a notificação
        //parâmetro por parâmetro
        Notification.Builder builder = new Notification.Builder(context);
        //Passo 2.3: Utilize o builder recém criado e set o conteúdo da notificação
        builder.setContentText(message);
        //Passo 2.4: Utilize o builder recém criado e set o título da notificação
        builder.setContentTitle(title);
        //Passo 2.5: Set um ícone pequeno e um outro grande
        builder.setSmallIcon(icon);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(),icon));
        //Passo 2.6: Associe à solicitação o PendingIntent criado no passo 2) para que a atividade ExibeNotificacao seja criada
        //caso a notificação seja aberta
        builder.setContentIntent(p);
        //Que tal criar uma progress bar para a sua notificação?
        //Use o builder para isto!
        //Experimente este exercício!!!


        //!!! Todos os parâmetros da notificação estão preenchidos, mas o builder não é a notificação
        //O builder é o construtor da notificação.
        //Passo 3: Solicite ao builder que ele instancie uma notificação com base nos parâmetros fornecidos
        Notification n = builder.build(); // n sim é uma instância da notificação que você quer exibir!
        //Notification n = new Notification();

        //Passo 4: Ache uma referência para o serviço de Notificações do Android.
        NotificationManager nm = (NotificationManager) context.getSystemService(Activity.NOTIFICATION_SERVICE);

        //Passo 5:Você deve solicitar ao NotificatioManager que ele exiba a sua notificação na barra de status
        nm.notify(id, n);
    }
}
