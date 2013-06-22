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
				"Respeite os limites do seu carro. Excesso de carga e objetos soltos dentro do veículo representam um grande risco.",
				"Aproveite as paradas durante a viagem para fazer breves caminhadas.",
				"Procure levar na bagagem os medicamentos que você normalmente usa.",
				"Verifique a validade dos documentos do carro.",
				"Crianças de até sete anos e meio devem ser transportadas no banco de trás, com equipamento especial (cadeirinha).",
				"Antes de viajar, evite os excessos, as comidas gordurosas e a ingestão de alimentos com os quais não está habituado.",
				"Dê atenção à pressão dos pneus, se não for o suficiente, o carro vai consumir mais combustível.",
				"Mantenha seu corpo hidratado, bebendo líquidos durante o trajeto – mas não tome bebidas alcoólicas!",
				"É possível que as crianças estejam com o cinto de segurança devidamente colocado e ainda assim confortáveis.",
				"Se beber, não dirija."
				};
		
		embaralharVetor(dicas);
		
		btnDicas = (Button) findViewById(R.id.buttonDicas);//associando o botão da activty com o btnDicas
		mostrarDicas();//chama o método mostrarDicas
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	static void embaralharVetor (String[] vet)
	{//embaralha o vetor, assim não mostra sempre as dicas na mesma ordem
	    Random r = new Random();
	    String aux;
	    int x;
	    
	    for (int i = (vet.length - 1); i >= 0; i--)
	    {
	      x = r.nextInt(i + 1);//sorteia um número
	      //efetua a troca
	      aux = vet[x];
	      vet[x] = vet[i];
	      vet[i] = aux;
	    }
	  }
	
	public void mostrarDicas() 
	{
		btnDicas.setOnClickListener(new View.OnClickListener() {//coloca um evento no botão
			
			@Override
			public void onClick(View v) 
			{
				//pega a próxima mensagem do vetor e exibe
				mostrarAlert("" + dicas[c]);
				
				c++;
		        
		        if(c == dicas.length) {
		            c = 0;
		        }
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
