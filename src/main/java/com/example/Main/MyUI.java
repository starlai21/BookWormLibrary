package com.example.Main;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.Page;
import com.vaadin.ui.UI;
import com.vaadin.server.Page.UriFragmentChangedEvent;
import com.vaadin.server.Page.UriFragmentChangedListener;


/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@StyleSheet({"https://fonts.googleapis.com/css?family=IM+Fell+DW+Pica+SC"})
public class MyUI extends UI {
	
	public static Authentication AUTH;
	
	@Override
	protected void init(VaadinRequest vaadinRequest) {
		new Navigator(this, this);
		getNavigator().addView(MainView.NAME, MainView.class);
		getNavigator().setErrorView(MainView.class);
		
		Page.getCurrent().addUriFragmentChangedListener(new UriFragmentChangedListener() {
			
			@Override
			public void uriFragmentChanged(UriFragmentChangedEvent event) {
				router(event.getUriFragment());
			}
		});
		router("");
    }
	
	private void router(String route){
		//Notification.show(route);
		if(getSession().getAttribute("user") != null){
			getNavigator().addView(SecurePage.NAME, SecurePage.class);
			getNavigator().addView(OtherSecurePage.NAME, OtherSecurePage.class);
			if(route.equals("!OtherSecure")){
				getNavigator().navigateTo(OtherSecurePage.NAME);
			}else{
				getNavigator().navigateTo(SecurePage.NAME);
			}
		}else{
			getNavigator().navigateTo(MainView.NAME);
		}
	}
	

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
