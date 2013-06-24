package br.com.fatecpg.y3mviagemtranquila;
//Criado por Maria Cleib Reis

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MelhorOpcaoActivity extends Activity {
	
	//Declaração de variaveis locais a serem utilizadas
	
	EditText n1;
	EditText n2;
	Button cal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_melhor_opcao);
		//Atribuição de valores passados pelo usuário para as variaveis citadas acima
		n1 = (EditText) findViewById(R.id.alcool);
		n2 = (EditText) findViewById(R.id.gasolina);
		
		cal = (Button) findViewById(R.id.cal);
		cal.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//Atribuições
				double num1 = Double.parseDouble(n1.getText().toString());
				double num2 = Double.parseDouble(n2.getText().toString());
				double r = num1/num2;
				
				//Condição que mostrará ao usuário a opção de acordo com o calculo.
				if(r < 0.7){
					AlertDialog.Builder dialogo = new AlertDialog.Builder(MelhorOpcaoActivity.this);
					dialogo.setTitle("Resposta");
					dialogo.setMessage("Pode confiar é mais vantajoso abastecer com álcool");
					dialogo.setNeutralButton("OK", null);
					dialogo.show();
					
				}else {
					AlertDialog.Builder dialogo = new AlertDialog.Builder(MelhorOpcaoActivity.this);
					dialogo.setTitle("Resposta");
					dialogo.setMessage("Não é vantajoso abastecer com álcool");
					dialogo.setNeutralButton("OK", null);
					dialogo.show();
				}
				
			}
		});
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.melhor_opcao, menu);
		return true;
	}
	//Método que fará com que a Activity secundária retorne para a tela principal
	public void voltar(View v) {
		Intent voltarIntent = new Intent(this, MainActivity.class);
		startActivity(voltarIntent);
		
	}

}
