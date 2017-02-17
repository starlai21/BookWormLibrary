package com.example.Main;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ValoTheme;

public class MainView extends VerticalLayout implements View{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VerticalLayout layout;
	private Label header;
	private Button login;
	private TextField searchText;
	private Button searchBtn;
	public static Authentication AUTH;
	public static final String NAME = "MainView";
	
	public MainView(){
		setupLayout();
        addHeader();
        addSearch();
        addMiddle();
	}
	

	private void setupLayout() {
		layout = new VerticalLayout();
		layout.setMargin(true);
		layout.addStyleName("background");
		addComponent(layout);
	}

	private void addHeader() {
		header = new Label("Bookworms Library");
		header.addStyleName(ValoTheme.LABEL_H1);
		header.addStyleName("header");
		
		login = new Button("Log in");
		login.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		login.addStyleName(ValoTheme.BUTTON_LARGE);
		login.addStyleName("white");
		login.setIcon(FontAwesome.USER);
		login.addClickListener(new Button.ClickListener() {
			@Override
		    public void buttonClick(ClickEvent event) {
				AUTH = new Authentication();
				LoginPage loginWindow = new LoginPage();
				UI.getCurrent().addWindow(loginWindow);
		    }
		});
		
		HorizontalLayout headerLayout = new HorizontalLayout(header, login);
		headerLayout.setWidth("100%");
		headerLayout.setComponentAlignment(login, Alignment.MIDDLE_RIGHT);
		headerLayout.setComponentAlignment(header, Alignment.MIDDLE_LEFT);
		
		layout.addComponent(headerLayout);
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
		
		layout.addComponent(searchBar);
	}

	private void addMiddle() {

		Embedded image = new Embedded(null,new ThemeResource("../book.jpg"));
		image.setWidth("100%");
		
		VerticalLayout bookSelf = new VerticalLayout();
		bookSelf.setMargin(true);
		bookSelf.addComponent(new Label("Books"));
		bookSelf.addComponent(image);
		bookSelf.addStyleName("background");
		
		Panel panel = new Panel("<center>Recommend Books<center>");
		panel.setHeight(200.0f, Unit.PERCENTAGE);
		panel.setContent(bookSelf);
		panel.addStyleName(ValoTheme.PANEL_BORDERLESS);
		
		VerticalLayout middle = new VerticalLayout();
		middle.setSizeFull();
		middle.addComponent(panel);
		
		layout.addComponent(middle);
    }

	@Override
	public void enter(ViewChangeEvent event) {
		
	}
}
