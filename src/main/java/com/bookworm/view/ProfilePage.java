package com.bookworm.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.VerticalSplitPanel;

public class ProfilePage extends VerticalLayout implements View{
	private static final long serialVersionUID = 1L;
	private VerticalLayout layout;
	private Label secure;
	private Label currentUser;
	private Button otherSecure;
	private Label header;
	private Button login;
	private TextField searchText;
	private Button searchBtn;

	public static final String NAME = "Profile";

	public ProfilePage() {
		//configureComponents();
		setupLayout();
		buildHeader();
		buildSearch();
		buildSide();
	}
	
	/*
	private void configureComponents(){
		otherSecure = new Button("OtherSecure");
		otherSecure.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				Page.getCurrent().setUriFragment("!"+OtherSecurePage.NAME);
			}
		});
		
		logout = new Button("Logout");
		logout.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().removeView(ProfilePage.NAME);
				getUI().getNavigator().removeView(OtherSecurePage.NAME);
				VaadinSession.getCurrent().setAttribute("user", null);
				Page.getCurrent().setUriFragment("");
			}
		});
		
		secure = new Label("secure");
		currentUser = new Label("Current User");
		addComponent(secure);
		addComponent(currentUser);
		addComponent(otherSecure);
		addComponent(logout);
	}
	*/
	
	private void setupLayout() {
		layout = new VerticalLayout();
		layout.setMargin(true);
		layout.addStyleName("background");
		addComponent(layout);
	}
	
	private void buildHeader() {
		header = new Label("Bookworms Library");
		header.addStyleName(ValoTheme.LABEL_H1);
		header.addStyleName("header");
		
		login = new Button();
		login.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		login.addStyleName(ValoTheme.BUTTON_LARGE);
		login.addStyleName("white");
		login.setIcon(FontAwesome.USER);

		HorizontalLayout headerLayout = new HorizontalLayout(header, login);
		headerLayout.setWidth("100%");
		headerLayout.setComponentAlignment(login, Alignment.MIDDLE_RIGHT);
		headerLayout.setComponentAlignment(header, Alignment.MIDDLE_LEFT);
		
		layout.addComponent(headerLayout);
	}
	
	private void buildSearch() {
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
		
		layout.addComponent(searchBar);
	}
	
	private void buildSide(){
		VerticalLayout sideBar = new VerticalLayout();
		sideBar.setMargin(true);
		sideBar.setWidth("20%");
		sideBar.setHeight("100%");
		
		Label profile = new Label();
		profile.addStyleName(ValoTheme.LABEL_H2);
		profile.addStyleName("header");
		sideBar.addComponent(profile);
		sideBar.setComponentAlignment(profile, Alignment.MIDDLE_CENTER);
		
		Button logout = new Button("Log Out");
		logout.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().removeView(ProfilePage.NAME);
				getUI().getNavigator().removeView(OtherSecurePage.NAME);
				VaadinSession.getCurrent().setAttribute("user", null);
				Page.getCurrent().setUriFragment(MainView.NAME);
			}
		});
		sideBar.addComponent(logout);
		
		layout.addComponent(sideBar);
	}


	@Override
	public void enter(ViewChangeEvent event) {
		login.setCaption(VaadinSession.getCurrent().getAttribute("user").toString());
	}

}
