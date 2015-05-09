package app.web;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.websocket.Session;

@ManagedBean
@SessionScoped
public class IdiomaBean {

	private String locale= "es";
	//FacesContext.getCurrentInstance().getViewRoot().getLocale().toLanguageTag();

	private final String[][] imgURL={{"/img/spain1.png","/img/spain1.png"},{"/img/inglaterra1.png","/img/inglaterra1.png"},{"/img/euskal1.png","/img/euskal1.png"}};
	public void cambiarIdioma(String idioma){
		locale = idioma;
		FacesContext context = FacesContext.getCurrentInstance();
		context.getViewRoot().setLocale(new Locale(idioma));
	}

	public String getLocale4JS() {
		return "'"+locale+"'";
	}
	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getLocaleImgURL(String loc,boolean over){



		switch(loc){
		case "es":
			if(loc.equals(locale)){
				return "/img/es2.png";
			}
			else{
				if(over)
					return "/img/es2.png";

				else
					return "/img/es1.png";

			}
		case "eu":
			if(loc.equals(locale)){
				return "/img/eu2.png";
			}
			else{
				if(over)
					return "/img/eu2.png";

				else
					return "/img/eu1.png";

			}

		case "en":
			if(loc.equals(locale)){
				return "/img/en2.png";
			}
			else{
				if(over)
					return "/img/en2.png";

				else
					return "/img/en1.png";
			}

		}
		return "";

	}

}
