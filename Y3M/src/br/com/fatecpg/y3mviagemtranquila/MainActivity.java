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
	String dicas[];
	int c = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnDicas = (Button) findViewById(R.id.buttonDicas);// associando o bot�o da activty com o btnDicas
		mostrarDicas();// chama o m�todo mostrarDicas
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	public static void embaralharVetor(String[] vet) 
	{// embaralha o vetor, assim n�o mostra sempre as dicas na mesma ordem
		Random r = new Random();
		String aux;
		int x;

		for (int i = (vet.length - 1); i >= 0; i--) {
			x = r.nextInt(i + 1);// sorteia um n�mero
			// efetua a troca
			aux = vet[x];
			vet[x] = vet[i];
			vet[i] = aux;
		}
	}

	// m�todo para mostrar as dicas quando clicar no bot�o
	public void mostrarDicas() 
	{
		// vetor com as dicas
		dicas = new String[] {
				"Respeite os limites do seu carro. Excesso de carga e objetos soltos dentro do ve�culo representam um grande risco.",
				"Aproveite as paradas durante a viagem para fazer breves caminhadas.",
				"Procure levar na bagagem os medicamentos que voc� normalmente usa.",
				"Verifique a validade dos documentos do carro.",
				"Crian�as de at� sete anos e meio devem ser transportadas no banco de tr�s, com equipamento especial (cadeirinha).",
				"Antes de viajar, evite os excessos, as comidas gordurosas e a ingest�o de alimentos com os quais n�o est� habituado.",
				"D� aten��o � press�o dos pneus, se n�o for o suficiente, o carro vai consumir mais combust�vel.",
				"Mantenha seu corpo hidratado, bebendo l�quidos durante o trajeto � mas n�o tome bebidas alco�licas!",
				"� poss�vel que as crian�as estejam com o cinto de seguran�a devidamente colocado e ainda assim confort�veis.",
				"Se beber, n�o dirija.",
				"Se a sua viagem for longa, verifique �gua, �leo, pneus e freios antes de viajar. Fa�a um breve checkup no carro.",
				"Durante uma viagem longa, a cada parada para abastecimento de combust�vel, sempre verifique os pneus, �gua e �leo.",
				"Antes de viajar, procure saber qual o melhor itiner�rio para percorrer e quais as rotas alternativas.",
				"Verifique a previs�o do tempo antes de viajar.",
				"Durante uma longa viagem, procure a cada parada, perguntar ao frentista a dist�ncia para o pr�ximo posto.",
				"Durante uma viagem longa, pare a cada duas horas para despertar. N�o corra o risco de cochilar durante o trajeto.",
				"Viaje a noite somente se necess�rio. Se voc� se perder, ficar� mais dif�cil para obter informa��es e retornar ao trajeto.",
				"Verifique sempre os equipamentos obrigat�rios de seguran�a, como macaco, chave de roda, tri�ngulo, estepe, e etc.",
				"Caso ocorra algum problema mec�nico, pare no acostamento e sinalize com o tri�ngulo em uma dist�ncia segura.",
				"N�o d� caronas a estranhos em beira de estrada. A sua seguran�a e da sua fam�lia s�o mais importantes." 
				};

		embaralharVetor(dicas);

		btnDicas.setOnClickListener(new View.OnClickListener() 
		{// coloca um evento no bot�o
			@Override
			public void onClick(View v) 
			{
				// pega a pr�xima mensagem do vetor e exibe
				mostrarAlert("" + dicas[c]);

				c++;

				if (c == dicas.length) {
					c = 0;
				}
			}
		});
	}

	// m�todo para exibir o AlertDialog com a dica de viagem
	public void mostrarAlert(String msg) {
		AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);// cria um novo  AlertDialog
		alert.setMessage(msg);// insere mensagem do alert com o par�metro (msg) desse m�todo
		alert.setNeutralButton("OK", null);// bot�o
		alert.show();// mostra o AlertDialog
	}

}
