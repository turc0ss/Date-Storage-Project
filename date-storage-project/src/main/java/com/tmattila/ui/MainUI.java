package com.tmattila.ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmattila.model.Dates;
import com.tmattila.service.DateService;
import com.tmattila.utils.DateStringUtils;
import com.tmattila.utils.LoggerMessages;
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

/***
 * 
 * @author tapsa
 *
 */
@SpringUI(path = "/ui")
@Theme("valo")
@Title("Date Storage App")
public class MainUI extends UI {

	/***
	 * logging the state of the program to a logging file
	 */
	static final Logger logger = Logger.getLogger(MainUI.class);

	/***
	 * Main layout VerticalLayout rootLayout.
	 */
	private VerticalLayout rootLayout;

	/***
	 * Secondary layout VerticalLayout headerLayout.
	 */
	private VerticalLayout headerLayout;

	/***
	 * Secondary layout VerticalLayout buttonLayout.
	 */
	private VerticalLayout buttonLayout;

	/***
	 * Label headerLabel.
	 */
	private Label headerLabel;

	/***
	 * Label timeLabel.
	 */
	private Label timeLabel;

	/***
	 * Label dateLabel.
	 */
	private Label dateLabel;

	/***
	 * Button dateButton.
	 */
	private Button dateButton;

	/***
	 * Date date.
	 */
	private Date date;

	/***
	 * Format date to specific format to show time requested way. format in
	 * question is dd/MM/yyyy HH:mm:ss.
	 */
	private DateFormat dateF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	/***
	 * Model Dates variable name dates.
	 */
	private Dates dates;

	/***
	 * Connect the variables to each other with BeanFieldGroup<> variable name
	 * fieldGroup.
	 */
	private BeanFieldGroup<Dates> fieldGroup;

	@Override
	protected final void init(final VaadinRequest request) {

		fieldGroup = new BeanFieldGroup<Dates>(Dates.class);
		dates = new Dates();

		rootLayout = new VerticalLayout();
		rootLayout.setMargin(true);

		headerLayout = new VerticalLayout();

		headerLabel = new Label("<h2><b>" + DateStringUtils.HEADER_TEXT.getString() + "</b></h2>", ContentMode.HTML);
		headerLayout.addComponent(headerLabel);

		buttonLayout = new VerticalLayout();
		buttonLayout.setSpacing(true);

		dateButton = new Button(DateStringUtils.BUTTON_TEXT.getString());
		dateButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(final ClickEvent event) {

				logger.info("Inside button clicklistener");

				date = new Date();
				logger.info("Setting up a new date");
				String formattedDate = dateF.format(date);

				timeLabel = new Label("<b>" + DateStringUtils.DATE_TEXT.getString() + "</b>", ContentMode.HTML);
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

	/***
	 * Autowired DateService class for the MainUI Variable name dateService. This
	 * enables the MainUI class to use repository through service class.
	 */
	@Autowired
	private DateService dateService;

	/***
	 * saveDate() method for saving the dates in to the db.
	 */
	private void saveDate() {

		try {
			fieldGroup.commit();
			logger.info(LoggerMessages.DATE_SAVED.getString());
		} catch (Exception e) {
			logger.error(LoggerMessages.ERROR_SAVING_DATE.getString() + e.getMessage());
			System.out.println("ERROR");
			return;
		}

		dateService.saveDateToRepository(dates);
		logger.info(LoggerMessages.SAVE_SUCCESSFUL.getString());
	}
}
