package calculator.features;

import calculator.questions.FullOperands;
import calculator.questions.OperandResult;
import calculator.tasks.Calculate;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import calculator.tasks.OpenTheApplication;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class CalculatorStory {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void shows_the_result_of_addition_between_two_numbers() {

        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(
                Calculate.Add().between(60).and(90)
        );

        then(anna).should(
                seeThat(new FullOperands(), equalTo("60+90")),
                seeThat(new OperandResult(), equalTo("150")));

    }

    @Test
    public void shows_the_result_of_subtraction_between_two_numbers() {

        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(
                Calculate.Subtract().between(90).and(60)
        );

        then(anna).should(
                seeThat(new FullOperands(), equalTo("90−60")),
                seeThat(new OperandResult(), equalTo("30")));

    }

    @Test
    public void shows_the_result_of_multiplication_between_two_numbers() {

        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(
                Calculate.Multiply().between(90).and(6)
        );

        then(anna).should(
                seeThat(new FullOperands(), equalTo("90·6")),
                seeThat(new OperandResult(), equalTo("540")));

    }

    @Test
    public void shows_the_result_of_division_between_two_numbers() {

        givenThat(anna).wasAbleTo(openTheApplication);

        when(anna).attemptsTo(
                Calculate.Divide().between(90).and(6)
        );

        then(anna).should(
                seeThat(new OperandResult(), equalTo("15")));

    }
}