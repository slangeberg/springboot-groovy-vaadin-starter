package app.ui

import app.service.TimeService
import com.vaadin.annotations.Theme
import com.vaadin.annotations.Widgetset
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.Button
import com.vaadin.ui.Label
import com.vaadin.ui.UI
import com.vaadin.ui.themes.ValoTheme
import org.springframework.beans.factory.annotation.Autowired
import org.vaadin.viritin.layouts.MVerticalLayout

@SpringUI
@Theme('app')
@Widgetset('app')
class AppUI extends UI {

    @Autowired TimeService timeService

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        def layout = new MVerticalLayout().withSpacing(true).withMargin(true)

        layout.addComponent(new Label('Hello Vaadin').with {
            setStyleName(ValoTheme.LABEL_H1)
            it
        })

        // def editor = new org.vaadin.openesignforms.ckeditor.CKEditorTextField()
        // layout.addComponent(editor)

        layout.addComponents(new Button('Click for time', {
            layout.addComponent(new Label("The service time?: ${timeService.getCurrentTime()}"))
        } as Button.ClickListener))

        setContent(layout)
    }
}
