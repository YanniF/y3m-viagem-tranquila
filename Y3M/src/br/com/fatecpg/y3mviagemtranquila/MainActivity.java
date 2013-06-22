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
				"Procure levar na bagagem os medicamentos que você normalmente usa.",
				"Antes de viajar, evite os excessos, as comidas gordurosas e a ingestão de alimentos com os quais não está habituado.",
				"Mantenha seu corpo hidratado, bebendo líquidos durante o trajeto – mas não tome bebidas alcoólicas!"};
		
		btnDicas = (Button) findViewById(R.id.buttonDicas);//associando o botão da activty com o btnDicas
		mostrarDicas();//chama o método mostrarDicas
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void mostrarDicas() 
	{//tratar para não mostrar a mesma dica várias vezes
		btnDicas.setOnClickListener(new View.OnClickListener() {//coloca um evento no botão
			
			@Override
			public void onClick(View v) 
			{//sorteia um número que é escolhido para aparecer uma das mensagens
				int n = (int) (Math.random() * dicas.length);
				mostrarAlert("" + dicas[n]);
			}
		});
	}
	
	//método para exibir o AlertDialog com a dica de viagem
	public void mostrarAlert(String msg) 
	{
		AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);//cria um novo AlertDialog
		alert.setMessage(msg);//insere mensagem do alert com o parâmetro (msg) desse método
		alert.setNeutralButton("OK", null);//botão
		alert.show();//mostra o AlertDialog
	}

}
