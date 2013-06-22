package br.com.fatecpg.y3mviagemtranquila;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Button btnDicas;
	String dicas [];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//vetor com as dicas
		dicas = new String [] {"Aproveite as paradas durante a viagem para fazer breves caminhadas.",
				"Procure levar na bagagem os medicamentos que voc� normalmente usa.",
				"Antes de viajar, evite os excessos, as comidas gordurosas e a ingest�o de alimentos com os quais n�o est� habituado.",
				"Mantenha seu corpo hidratado, bebendo l�quidos durante o trajeto � mas n�o tome bebidas alco�licas!"};
		
		btnDicas = (Button) findViewById(R.id.buttonDicas);//associando o bot�o da activty com o btnDicas
		mostrarDicas();//chama o m�todo mostrarDicas
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void mostrarDicas() 
	{//tratar para n�o mostrar a mesma dica v�rias vezes
		btnDicas.setOnClickListener(new View.OnClickListener() {//coloca um evento no bot�o
			
			@Override
			public void onClick(View v) 
			{//sorteia um n�mero que � escolhido para aparecer uma das mensagens
				int n = (int) (Math.random() * dicas.length);
				mostrarAlert("" + dicas[n]);
			}
		});
	}
	
	//m�todo para exibir o AlertDialog com a dica de viagem
	public void mostrarAlert(String msg) 
	{
		AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);//cria um novo AlertDialog
		alert.setMessage(msg);//insere mensagem do alert com o par�metro (msg) desse m�todo
		alert.setNeutralButton("OK", null);//bot�o
		alert.show();//mostra o AlertDialog
	}

}
