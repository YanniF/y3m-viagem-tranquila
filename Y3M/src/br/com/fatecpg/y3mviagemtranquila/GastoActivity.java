package br.com.fatecpg.y3mviagemtranquila;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class GastoActivity extends Activity {

	EditText etKmViagem, etKmLitro, etPreco;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gasto);
		
		etKmViagem = (EditText) findViewById(R.id.editTextKmViagem);
		etKmLitro = (EditText) findViewById(R.id.editTextKmLitro);
		etPreco = (EditText) findViewById(R.id.editTextPrecoMedio);
		
		etKmViagem.requestFocus();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gasto, menu);
		return true;
	}
	
	public void voltar(View v) {
		finish();
	}
	
	public void limparCaixasDeTexto(View v) {
		etKmViagem.setText("");
		etKmLitro.setText("");
		etPreco.setText("");
		etKmViagem.requestFocus();
	}
	
	public void calcularGasto(View v) {
		
		try {
			Intent intent = new Intent(this, ResultadoGastoActivity.class);
			
			double kmViagem, kmLitro, preco, totalLitros, valorTotal;
			
			kmViagem = Double.parseDouble(etKmViagem.getText().toString());
			kmLitro = Double.parseDouble(etKmLitro.getText().toString());
			preco = Double.parseDouble(etPreco.getText().toString());
			
			if(kmViagem == 0 || kmLitro == 0 || preco == 0) {
				mostrarAlert("Aviso", "Digite valores diferentes de zero.");
				limparCaixasDeTexto(v);
			}
			else {
				totalLitros = kmViagem / kmLitro;
	            valorTotal = totalLitros * preco;
	            
	            intent.putExtra("LITROS", totalLitros);
	            intent.putExtra("VALOR", valorTotal);
	            startActivity(intent);
			}

		}
		catch(Exception e) {
			mostrarAlert("Erro", "Erro: " + e.getMessage());
			limparCaixasDeTexto(v);
		}
	}
	
	public void mostrarAlert(String titulo, String msg) {
		AlertDialog.Builder alert = new AlertDialog.Builder(GastoActivity.this);
		alert.setTitle(titulo);
		alert.setMessage(msg);
		alert.setNeutralButton("OK", null);
		alert.show();
	}
}
