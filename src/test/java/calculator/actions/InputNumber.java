package calculator.actions;

import calculator.ui.NumberPad;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class InputNumber implements Interaction {
    int Number;
    public InputNumber(int number)
    {
        this.Number = number;
    }

    @Override
    @Step("{0} input the number #Number")
    public <T extends Actor> void performAs(T actor) {
        String numberInString = String.valueOf(this.Number);

        for(int i=0; i< numberInString.length(); i++)
        {
            NumberPad.GET_NUMBER(numberInString.charAt(i)).resolveFor(actor).click();
        }
    }

    public static Interaction with(int Number)
    {
        return instrumented(InputNumber.class, Number);
    }
}
