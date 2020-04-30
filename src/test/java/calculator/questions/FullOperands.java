package calculator.questions;

import calculator.ui.NumberPad;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class FullOperands implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        WebElementFacade fullOperands = NumberPad.FULL_OPERANDS.resolveFor(actor);
        return fullOperands.getText();
    }
}
