package com.tmattila.ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmattila.model.Dates;
import com.tmattila.service.DateService;
import com.tmattila.utils.DateStringUtils;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path="/ui")
@Theme("valo")
@Title("Date Storage App")
public class MainUI extends UI {

	private VerticalLayout rootLayout;
	private VerticalLayout headerLayout;
	private VerticalLayout buttonLayout;
	
	private Label headerLabel;
	private Label timeLabel;
	private Label dateLabel;
	
	private Button dateButton;
	
	private Date date;
	private DateFormat dateF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Dates dates;
	private BeanFieldGroup<Dates> fieldGroup;
	
	@Override
	protected void init(VaadinRequest request) {
		
		fieldGroup = new BeanFieldGroup<Dates>(Dates.class);
		dates = new Dates();
		
		rootLayout = new VerticalLayout();
		rootLayout.setMargin(true);
		
		headerLayout = new VerticalLayout();
		
		headerLabel = new Label("<h2><b>"+DateStringUtils.HEADER_TEXT.getString()+"</b></h2>", ContentMode.HTML);
		headerLayout.addComponent(headerLabel);
		
		buttonLayout = new VerticalLayout();
		buttonLayout.setSpacing(true);
		buttonLayout.setMargin(true);
		
		dateButton = new Button(DateStringUtils.BUTTON_TEXT.getString());
		dateButton.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				
				date = new Date();
				String formattedDate = dateF.format(date);
				
				timeLabel = new Label("<b>"+DateStringUtils.DATE_TEXT.getString()+"</b>", ContentMode.HTML);
				dateLabel = new Label(timeLabel + formattedDate, ContentMode.HTML);
				buttonLayout.addComponent(dateLabel);
				
				saveDate();
			}
		});
		
		fieldGroup.bindMemberFields(this);
		fieldGroup.setItemDataSource(dates);
		
		buttonLayout.addComponent(dateButton);
		
		rootLayout.addComponent(headerLayout);
		rootLayout.addComponent(dateButton);
		rootLayout.addComponent(buttonLayout);
		setContent(rootLayout);
	}
	
	@Autowired
	private DateService dateService;
	
	private void saveDate() {
		
		try {
			fieldGroup.commit();
		} catch (Exception e) {
			System.out.println("ERROR");
			return;
		}
		
		dateService.saveDateToRepository(dates);
	}
}
