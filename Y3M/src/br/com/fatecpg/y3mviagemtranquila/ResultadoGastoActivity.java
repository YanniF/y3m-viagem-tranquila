package br.com.fatecpg.y3mviagemtranquila;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ResultadoGastoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resultado_gasto);
		
		Intent intent = getIntent();
		double litros = intent.getDoubleExtra("LITROS", 0);
		double valor = intent.getDoubleExtra("VALOR", 0);
		
		String litrosString = String.format("%.2f", litros);
		String valorString = String.format("%.2f", valor);
		
		litrosString = litrosString.replace(".", ",");
		valorString = valorString.replace(".", ",");
		
		TextView tvTotalLitros = (TextView) findViewById(R.id.textViewTotalLitros);
		TextView tvValor = (TextView) findViewById(R.id.textViewValor);
		
		tvTotalLitros.setText("Total de combustível que será consumido: \n" + litrosString + " litro(s)");
		tvValor.setText("Valor total aproximado: \nR$ " + valorString);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.resultado_gasto, menu);
		return true;
	}
	
	public void voltar(View v) {
		Intent voltarIntent = new Intent(this, MainActivity.class);
		startActivity(voltarIntent);
		
	}

}
