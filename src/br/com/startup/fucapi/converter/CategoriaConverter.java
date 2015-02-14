package br.com.startup.fucapi.converter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.startup.com.dao.CategoriaDAO;
import br.com.startup.fucapi.model.CategoriaCongresso;


@FacesConverter("categoriaConverter")
public class CategoriaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent conmponent, String valor) {
		try {
			Integer id = Integer.parseInt(valor);
			CategoriaDAO dao = new CategoriaDAO();
			CategoriaCongresso  categoriaCongresso = dao.pesquisarID(id);
			return categoriaCongresso;
			
		} catch (RuntimeException e) {
			return null;
		}

	}


	@Override
	public String getAsString(FacesContext facesContext, UIComponent conmponent, Object objeto) {
		try {
			CategoriaCongresso categoriaCongresso = (CategoriaCongresso) objeto;	
			Integer codigo = categoriaCongresso.getId();
			String id = codigo.toString();
			System.out.println("Para id");
			return id;
		} catch (RuntimeException e) {
			System.out.println("Erro ID");
			return null;
		}
		
	}

}
