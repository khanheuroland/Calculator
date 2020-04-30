package calculator.tasks;

import calculator.ui.NumberPad;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

public class Calculate implements Task {
    public enum Operator {
        ADD, SUB, MUL, DIV;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    private Operator operator;
    private int firstNumber;
    private int secondNumber;

    public static CalculateBuilder Add() {
        return new CalculateBuilder(Operator.ADD);
    }

    public static CalculateBuilder Subtract() {
        return new CalculateBuilder(Operator.SUB);
    }

    public static CalculateBuilder Divide() {
        return new CalculateBuilder(Operator.DIV);
    }

    public static CalculateBuilder Multiply() {
        return new CalculateBuilder(Operator.MUL);
    }

    public Calculate(Operator operator, int firstNumber, int secondNumber)
    {
        this.operator = operator;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Step("Make the #operator between #firstNumber and #secondNumber")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(NumberPad.GET_NUMBER(this.firstNumber)),
                Click.on(NumberPad.GET_OPERATOR(this.operator)),
                Click.on(NumberPad.GET_NUMBER(this.secondNumber))
        );
    }

    public static class CalculateBuilder
    {
        private Operator operator;
        private int firstNumber;

        public CalculateBuilder(Operator operator)
        {
            this.operator = operator;
        }

        public CalculateBuilder between(int firstNumber) {
            this.firstNumber = firstNumber;
            return this;
        }

        public Calculate and(int secondNumber)
        {
            return instrumented(Calculate.class, this.operator, this.firstNumber, secondNumber);
        }
    }
}
