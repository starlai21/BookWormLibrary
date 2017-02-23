package com.bookworm;

import javax.servlet.annotation.WebServlet;

import com.bookworm.services.Authentication;
import com.bookworm.ui.MainView;
import com.bookworm.ui.OtherSecurePage;
import com.bookworm.ui.ProfileView;
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
 * The main UI of the Library App. Navigator can set views for different content that we 
 * implemented in separated class
 * 
 */
@Theme("mytheme")
@StyleSheet({"https://fonts.googleapis.com/css?family=IM+Fell+DW+Pica+SC"})
public class LibraryUI extends UI {
	
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
	
	/**
	 * Router provides the navigation function be able to change 
	 * current view by passing URI fragment
	 * 
	 * @param route	URI String
	 */
	private void router(String route){
		//Notification.show(route);
		if(getSession().getAttribute("user") != null){
			getNavigator().addView(ProfileView.NAME, ProfileView.class);
			getNavigator().addView(OtherSecurePage.NAME, OtherSecurePage.class);
			if(route.equals("!OtherSecure")){
				getNavigator().navigateTo(OtherSecurePage.NAME);
			}else{
				getNavigator().navigateTo(ProfileView.NAME);
			}
		}else{
			getNavigator().navigateTo(MainView.NAME);
		}
	}
	

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = LibraryUI.class, productionMode = false)
    public static class LibraryUIServlet extends VaadinServlet {
    }
}
