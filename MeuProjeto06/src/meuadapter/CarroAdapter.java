package meuadapter;

import java.util.List;

import com.exemplo.meuprojeto06.R;

//import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import entidade.*;

public class CarroAdapter extends BaseAdapter {

	Context ctx;
	List<Carro> carros;
	
	public CarroAdapter(Context ctx, List<Carro> lista) {
		// TODO Auto-generated constructor stub
		this.ctx = ctx;
		this.carros = lista;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		//Este método é usado pelo ListView para perguntar ao Adapter
		//qual a quantidade de objetos a apresentar
		return carros.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		//Este método é usado pelo ListView para recuperar do Adapter
		//um objeto carro a partir de uma posição
		return carros.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		//Usado para recuper o id de um objeto
		//Usado quando temos interação com um Banco de Dados
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		//Este método é usado pelo ListView para pedir ao Adapter
		//uma linha (view) a ser apresentada na ListView
		//Recuperar um objeto carro da lista
		Carro carro = carros.get(position);
		//Transforma o Arquivo de layout item_carro.xml em um objeto Java
		//que permite recuperar os demais objetos pertecentes ao arquivo
		//usando o método findViewById.
		//No caso a View retornada será um objeto RelativeLayout, pois esta
		//é a tag principal do arquivo de layout item_carro.xml
		View linha = LayoutInflater.from(ctx).inflate(R.layout.item_carro, null);
		//Recuperamos cada objeto do arquivo item_carro.xml usando findViewById
		ImageView imglogo = (ImageView) linha.findViewById(R.id.imglogo);
		//De acordo com a marca mostramos um imagem diferente no objeto imglogo
		if (carro.getMarca().equals("Fiat")) {
			imglogo.setImageResource(R.drawable.fiatlogo);
		}
		if (carro.getMarca().equals("Chevrolet")) {
			imglogo.setImageResource(R.drawable.chevroletlogo);
		}
		if (carro.getMarca().equals("Volkswagen")) {
			imglogo.setImageResource(R.drawable.vwlogo);
		}
		
		TextView txtmarca = (TextView) linha.findViewById(R.id.txtMarca);
		txtmarca.setText(carro.getMarca());
		TextView txtmodelo = (TextView) linha.findViewById(R.id.txtModelo);
		txtmodelo.setText(carro.getModelo());
		TextView txtano = (TextView) linha.findViewById(R.id.txtAno);
		txtano.setText(String.valueOf(carro.getAno()));
		
		return linha;
	}

}
