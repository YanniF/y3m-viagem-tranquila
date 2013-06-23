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

		btnDicas = (Button) findViewById(R.id.buttonDicas);// associando o botão da activty com o btnDicas
		mostrarDicas();// chama o método mostrarDicas
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	public static void embaralharVetor(String[] vet) 
	{// embaralha o vetor, assim não mostra sempre as dicas na mesma ordem
		Random r = new Random();
		String aux;
		int x;

		for (int i = (vet.length - 1); i >= 0; i--) {
			x = r.nextInt(i + 1);// sorteia um número
			// efetua a troca
			aux = vet[x];
			vet[x] = vet[i];
			vet[i] = aux;
		}
	}

	// método para mostrar as dicas quando clicar no botão
	public void mostrarDicas() 
	{
		// vetor com as dicas
		dicas = new String[] {
				"Respeite os limites do seu carro. Excesso de carga e objetos soltos dentro do veículo representam um grande risco.",
				"Aproveite as paradas durante a viagem para fazer breves caminhadas.",
				"Procure levar na bagagem os medicamentos que você normalmente usa.",
				"Verifique a validade dos documentos do carro.",
				"Crianças de até sete anos e meio devem ser transportadas no banco de trás, com equipamento especial (cadeirinha).",
				"Antes de viajar, evite os excessos, as comidas gordurosas e a ingestão de alimentos com os quais não está habituado.",
				"Dê atenção à pressão dos pneus, se não for o suficiente, o carro vai consumir mais combustível.",
				"Mantenha seu corpo hidratado, bebendo líquidos durante o trajeto – mas não tome bebidas alcoólicas!",
				"É possível que as crianças estejam com o cinto de segurança devidamente colocado e ainda assim confortáveis.",
				"Se beber, não dirija.",
				"Se a sua viagem for longa, verifique água, óleo, pneus e freios antes de viajar. Faça um breve checkup no carro.",
				"Durante uma viagem longa, a cada parada para abastecimento de combustível, sempre verifique os pneus, água e óleo.",
				"Antes de viajar, procure saber qual o melhor itinerário para percorrer e quais as rotas alternativas.",
				"Verifique a previsão do tempo antes de viajar.",
				"Durante uma longa viagem, procure a cada parada, perguntar ao frentista a distância para o próximo posto.",
				"Durante uma viagem longa, pare a cada duas horas para despertar. Não corra o risco de cochilar durante o trajeto.",
				"Viaje a noite somente se necessário. Se você se perder, ficará mais difícil para obter informações e retornar ao trajeto.",
				"Verifique sempre os equipamentos obrigatórios de segurança, como macaco, chave de roda, triângulo, estepe, e etc.",
				"Caso ocorra algum problema mecânico, pare no acostamento e sinalize com o triângulo em uma distância segura.",
				"Não dê caronas a estranhos em beira de estrada. A sua segurança e da sua família são mais importantes." 
				};

		embaralharVetor(dicas);

		btnDicas.setOnClickListener(new View.OnClickListener() 
		{// coloca um evento no botão
			@Override
			public void onClick(View v) 
			{
				// pega a próxima mensagem do vetor e exibe
				mostrarAlert("" + dicas[c]);

				c++;

				if (c == dicas.length) {
					c = 0;
				}
			}
		});
	}

	// método para exibir o AlertDialog com a dica de viagem
	public void mostrarAlert(String msg) {
		AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);// cria um novo  AlertDialog
		alert.setMessage(msg);// insere mensagem do alert com o parâmetro (msg) desse método
		alert.setNeutralButton("OK", null);// botão
		alert.show();// mostra o AlertDialog
	}

}
