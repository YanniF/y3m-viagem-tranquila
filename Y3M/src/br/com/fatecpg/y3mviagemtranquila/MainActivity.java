package br.com.fatecpg.y3mviagemtranquila;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Button btnDicas;
	String dicas [];
	int c = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//vetor com as dicas
		dicas = new String [] {
				"Respeite os limites do seu carro. Excesso de carga e objetos soltos dentro do ve�culo representam um grande risco.",
				"Aproveite as paradas durante a viagem para fazer breves caminhadas.",
				"Procure levar na bagagem os medicamentos que voc� normalmente usa.",
				"Verifique a validade dos documentos do carro.",
				"Crian�as de at� sete anos e meio devem ser transportadas no banco de tr�s, com equipamento especial (cadeirinha).",
				"Antes de viajar, evite os excessos, as comidas gordurosas e a ingest�o de alimentos com os quais n�o est� habituado.",
				"D� aten��o � press�o dos pneus, se n�o for o suficiente, o carro vai consumir mais combust�vel.",
				"Mantenha seu corpo hidratado, bebendo l�quidos durante o trajeto � mas n�o tome bebidas alco�licas!",
				"� poss�vel que as crian�as estejam com o cinto de seguran�a devidamente colocado e ainda assim confort�veis.",
				"Se beber, n�o dirija."
				};
		
		embaralharVetor(dicas);
		
		btnDicas = (Button) findViewById(R.id.buttonDicas);//associando o bot�o da activty com o btnDicas
		mostrarDicas();//chama o m�todo mostrarDicas
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	static void embaralharVetor (String[] vet)
	{//embaralha o vetor, assim n�o mostra sempre as dicas na mesma ordem
	    Random r = new Random();
	    String aux;
	    int x;
	    
	    for (int i = (vet.length - 1); i >= 0; i--)
	    {
	      x = r.nextInt(i + 1);//sorteia um n�mero
	      //efetua a troca
	      aux = vet[x];
	      vet[x] = vet[i];
	      vet[i] = aux;
	    }
	  }
	
	public void mostrarDicas() 
	{
		btnDicas.setOnClickListener(new View.OnClickListener() {//coloca um evento no bot�o
			
			@Override
			public void onClick(View v) 
			{
				//pega a pr�xima mensagem do vetor e exibe
				mostrarAlert("" + dicas[c]);
				
				c++;
		        
		        if(c == dicas.length) {
		            c = 0;
		        }
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