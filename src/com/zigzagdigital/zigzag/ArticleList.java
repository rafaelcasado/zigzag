package com.zigzagdigital.zigzag;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ArticleList extends Activity implements OnClickListener {

	// Lista de elementos para probar lista simple
	String [] articulos = {	"Artículo largo: El pasado sábado un grupo de ladrones asaltó el local de Imán Joyeros, situado en el paseo Dolores Soria de Pinto. Los propietarios del negocio estiman que el delito se produjo alrededor de las 21.30 horas, ya que fue en ese momento cuando se interrumpió la grabación de las cámaras de seguridad.",
							"Artículo 1", "Artículo 2", "Artículo 3", "Artículo 4",
							"Artículo 5", "Artículo 6", "Artículo 7", "Artículo 8",
							"Artículo 9", "Artículo 10", "Artículo 11", "Artículo 12",
							"El pasado domingo 24 de febrero se celebró la tradicional repoblación popular que Ecologistas en Acción de Pinto realiza en nuestro municipio cada año. Pese al frío, “la convocatoria fue un éxito”, dicen los organizadores. Un centenar de personas participaron en la repoblación.Después de varios años repoblando el cerro Pelango, en el camino de Valdemoro, este año se decidió colonizar el cerro situado enfrente, nacido del movimiento de tierras de la M-506 y de las obras ferroviarias. En este lugar fueron plantados una buena cantidad de árboles y arbustos apropiados para esta zona, tales como encinas, coscojas y pinos, puesto que la elección de las especies es uno de los factores clave para el éxito de una repoblación."
							};
	
	private ListView listaArticulos = null;
	private ListAdapter adapterListaArticulos = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_article_list);
		Button botonAbout = (Button) findViewById(R.id.about_boton);
		botonAbout.setOnClickListener(this);
		
		listaArticulos = (ListView) findViewById(android.R.id.list);
		adapterListaArticulos = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, articulos);
		
		listaArticulos.setAdapter(adapterListaArticulos);
	}

	@Override
	public void onClick(View v) {
		// Pulsar el botón Acerca de... abre la actividad About
		
		switch (v.getId()) {
		case R.id.about_boton:
			Context context = this;
			Intent intent = new Intent (context, AboutActivity.class);
			startActivity(intent);
			break;
		}
	}
}
