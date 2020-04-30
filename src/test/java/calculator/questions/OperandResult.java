package calculator.questions;

import calculator.ui.NumberPad;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class OperandResult implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        WebElementFacade lbResult= NumberPad.OPERAND_RESULT.resolveFor(actor);
        return lbResult.getText().replace("=", "").trim();
    }
}
