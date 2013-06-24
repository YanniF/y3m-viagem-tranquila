package br.com.fatecpg.y3mviagemtranquila;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class LigacoesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ligacoes);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ligacoes, menu);
		return true;
	}
	
	// -------------CRIA��O DOS M�TODOS QUE EXECUTAM AS LIGA��ES-----------
	
	public void ligarParaPoliciaMilitar(View view){
		Uri number = Uri.parse("tel:190"); // passando o n�mero que vai ser ligado - chamando o dial
		Intent callIntent = new Intent(Intent.ACTION_DIAL,number);
		// verificando se h� activies para a intent atrav�s do m�todo queryIntentActivities do PackageManager
		if (getPackageManager().queryIntentActivities(callIntent, 0).size()>0){
			startActivity(callIntent);
		}else{ // caso n�o haja exibe mensagem de falta de aplicativo
			String mensagem = "N�o h� um aplicativo para esta a��o!";
			new AlertDialog.Builder(this).setTitle("Erro").setMessage(mensagem).setNeutralButton("Close",null).show();
			
		}
	}
	
	
	public void ligarParaPoliciaRodoviaria(View view){
		Uri number = Uri.parse("tel:191"); // passando o n�mero que vai ser ligado - chamando o dial
		Intent callIntent = new Intent(Intent.ACTION_DIAL,number);
		// verificando se h� activies para a intent atrav�s do m�todo queryIntentActivities do PackageManager
		if (getPackageManager().queryIntentActivities(callIntent, 0).size()>0){ 
			startActivity(callIntent);
		}else{ // caso n�o haja exibe mensagem de falta de aplicativo
			String mensagem = "N�o h� um aplicativo para esta a��o!";
			new AlertDialog.Builder(this).setTitle("Erro").setMessage(mensagem).setNeutralButton("Close",null).show();
			
		}
	}
	
	
	public void ligarParaAmbulancia(View view){
		Uri number = Uri.parse("tel:192"); // passando o n�mero que vai ser ligado - chamando o dial
		Intent callIntent = new Intent(Intent.ACTION_DIAL,number);
		// verificando se h� activies para a intent atrav�s do m�todo queryIntentActivities do PackageManager
		if (getPackageManager().queryIntentActivities(callIntent, 0).size()>0){
			startActivity(callIntent);
		}else{ // caso n�o haja exibe mensagem de falta de aplicativo
			String mensagem = "N�o h� um aplicativo para esta a��o!";
			new AlertDialog.Builder(this).setTitle("Erro").setMessage(mensagem).setNeutralButton("Close",null).show();
			
		}
	}
	
	public void ligarParaBombeiro(View view){
		Uri number = Uri.parse("tel:193"); // passando o n�mero que vai ser ligado - chamando o dial
		Intent callIntent = new Intent(Intent.ACTION_DIAL,number);
		// verificando se h� activies para a intent atrav�s do m�todo queryIntentActivities do PackageManager
		if (getPackageManager().queryIntentActivities(callIntent, 0).size()>0){
			startActivity(callIntent);
		}else{ // caso n�o haja exibe mensagem de falta de aplicativo
			String mensagem = "N�o h� um aplicativo para esta a��o!";
			new AlertDialog.Builder(this).setTitle("Erro").setMessage(mensagem).setNeutralButton("Close",null).show();
			
		}
	}
	
	// ------------ FIM DOS M�TODOS QUE EXECUTAM AS LIGA��ES  --------------
	
	
	// M�todo que retorna para a activity main
	public void voltar(View v){
		finish();
	}
}


