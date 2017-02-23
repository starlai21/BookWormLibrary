package com.bookworm.ui.login;

import com.bookworm.ui.HeaderView;
import com.bookworm.ui.OtherSecurePage;
import com.bookworm.ui.ProfileView;
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

public class LoginWindow extends Window{

	private static final long serialVersionUID = 1L;
	private TextField username;
	private PasswordField password;
	private Button send;
	private FormLayout form;
	private VerticalLayout LoginLayout;

	public LoginWindow(){	
		setLayout();
		buildComponent();
	}

	private void setLayout() {
		setCaption("Log In");
		setClosable(true);
		setResizable(false);
		setDraggable(false);
		center();
	}

	private void buildComponent() {
		username = new TextField("Username");
		password = new PasswordField("Password");
		
		send = new Button("Log In");
		send.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				if(HeaderView.AUTH.authenticate(username.getValue(), password.getValue())){
					VaadinSession.getCurrent().setAttribute("user", username.getValue());
					getUI().getNavigator().addView(ProfileView.NAME, ProfileView.class);
					getUI().getNavigator().addView(OtherSecurePage.NAME, OtherSecurePage.class);
					Page.getCurrent().setUriFragment("!"+ProfileView.NAME);
					close();
				}else{
					Notification.show("Invalid credentials", Notification.Type.ERROR_MESSAGE);
				}
			}
			
		});
		form = new FormLayout();
		form.setSizeUndefined();
		form.addComponent(username);
		form.addComponent(password);
		form.addComponent(send);
		form.setMargin(true);
		
		addToLayout();
	}
	
	private void addToLayout(){
		LoginLayout = new VerticalLayout();
		LoginLayout.setMargin(true);
		LoginLayout.addComponent(form);
		setContent(LoginLayout);
	}

}
