package com.bookworm.ui;

import com.bookworm.services.Authentication;
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

	
	public static final String NAME = "MainView";
	
	public MainView(){
		addComponent(new HeaderView());
        addMiddle();
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
		
		addComponent(middle);
    }

	@Override
	public void enter(ViewChangeEvent event) {
		
	}
}
