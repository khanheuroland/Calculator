package calculator.ui;

import calculator.tasks.Calculate;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import javax.sound.midi.MidiChannel;

public class NumberPad {
    public static Target PLUS_OPERATOR = Target.the("plus operator")
            .located(By.xpath("//*[@dcg-command=\"+\"]"));

    public static Target MINUS_OPERATOR = Target.the("minus operator")
            .located(By.xpath("//*[@dcg-command=\"-\"]"));

    public static Target MUL_OPERATOR = Target.the("multiply operator")
            .located(By.xpath("//*[@dcg-command=\"*\"]"));

    public static Target DIV_OPERATOR = Target.the("divide operator")
            .located(By.xpath("//*[@dcg-command=\"/\"]"));

    public static Target FULL_OPERANDS = Target.the("full operands")
            .located(By.cssSelector("div.dcg-math-field"));

    public static Target OPERAND_RESULT = Target.the("operand result")
            .located(By.cssSelector("div.dcg-basic-expression-value .dcg-mq-root-block"));

    public static Target GET_NUMBER(int number)
    {
        return Target.the("the number #"+ number)
                .located(By.xpath("//*[@dcg-command=\""+number+"\"]"));

    }

    public static Target GET_NUMBER(char number)
    {
        return Target.the("the number #"+ number)
                .located(By.xpath("//*[@dcg-command=\""+number+"\"]"));

    }

    public static Target GET_OPERATOR(Calculate.Operator operator)
    {
        switch (operator)
        {
            case ADD:
                return PLUS_OPERATOR;
            case SUB:
                return MINUS_OPERATOR;
            case MUL:
                return MUL_OPERATOR;
            default:
                return DIV_OPERATOR;
        }
    }
}
