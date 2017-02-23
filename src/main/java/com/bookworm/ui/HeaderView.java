package com.bookworm.ui;

import com.bookworm.services.Authentication;
import com.bookworm.ui.login.LoginWindow;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ValoTheme;

public class HeaderView extends VerticalLayout implements View{
	
	private Button header;
	private Button login;
	private TextField searchText;
	private Button searchBtn;
	public static Authentication AUTH;
	
	public HeaderView(){
		//setupLayout();
		setMargin(true);
		addStyleName("background");
        addHeader();
        addSearch();
	}
	
	private void addHeader() {
		header = new Button("Bookworms Library");
		header.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		header.addStyleName(ValoTheme.BUTTON_LARGE);
		header.addStyleName("white");
		header.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().removeView(ProfileView.NAME);
				getUI().getNavigator().removeView(OtherSecurePage.NAME);
				VaadinSession.getCurrent().setAttribute("user", null);
				Page.getCurrent().setUriFragment("");
			}
		});
		
		login = new Button("Log in");
		login.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		login.addStyleName(ValoTheme.BUTTON_LARGE);
		login.addStyleName("white");
		login.setIcon(FontAwesome.USER);
		login.addClickListener(new Button.ClickListener() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
		    public void buttonClick(ClickEvent event) {
				AUTH = new Authentication();
				LoginWindow loginWindow = new LoginWindow();
				UI.getCurrent().addWindow(loginWindow);
		    }
		});
		
		HorizontalLayout headerLayout = new HorizontalLayout(header, login);
		headerLayout.setWidth("100%");
		headerLayout.setComponentAlignment(login, Alignment.MIDDLE_RIGHT);
		headerLayout.setComponentAlignment(header, Alignment.MIDDLE_LEFT);
		
		addComponent(headerLayout);
	}
	
	private void addSearch() {
		searchText = new TextField();
		searchText.setWidth("60%");
		searchText.setInputPrompt("Search by author, title or ISBN");
		searchText.addStyleName("white");
		
		searchBtn = new Button("Search");
		searchBtn.setWidth(null);
		searchBtn.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		searchBtn.addStyleName(ValoTheme.BUTTON_LARGE);
		searchBtn.addStyleName("white");
		searchBtn.setIcon(FontAwesome.SEARCH);
		
		HorizontalLayout searchBar = new HorizontalLayout(searchText, searchBtn);
		searchBar.setWidth("100%");
		searchBar.setMargin(true);
		searchBar.setExpandRatio(searchText, 5);
		searchBar.setExpandRatio(searchBtn, 2);
		searchBar.setComponentAlignment(searchText, Alignment.MIDDLE_RIGHT);
		searchBar.setComponentAlignment(searchBtn, Alignment.MIDDLE_LEFT);
		
		addComponent(searchBar);
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

}
