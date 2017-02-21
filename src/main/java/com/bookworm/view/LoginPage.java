package com.bookworm.view;

import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class LoginPage extends Window{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginPage(){
		setCaption("Log In");
		setClosable(true);
		setResizable(false);
		setDraggable(false);
		center();
		
		TextField username = new TextField("Username");
		PasswordField password = new PasswordField("Password");
		

		Button send = new Button("Log In");
		send.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				if(MainView.AUTH.authenticate(username.getValue(), password.getValue())){
					VaadinSession.getCurrent().setAttribute("user", username.getValue());
					getUI().getNavigator().addView(ProfilePage.NAME, ProfilePage.class);
					getUI().getNavigator().addView(OtherSecurePage.NAME, OtherSecurePage.class);
					Page.getCurrent().setUriFragment("!"+ProfilePage.NAME);
					close();
				}else{
					Notification.show("Invalid credentials", Notification.Type.ERROR_MESSAGE);
				}
			}
			
		});
		
		FormLayout content = new FormLayout();
		content.addComponent(username);
		content.addComponent(password);
		content.addComponent(send);
		content.setSizeUndefined();
		content.setMargin(true);
		
		VerticalLayout LoginLayout = new VerticalLayout();
		LoginLayout.setMargin(true);
		LoginLayout.addComponent(content);
		
		setContent(LoginLayout);
	}
	
}
