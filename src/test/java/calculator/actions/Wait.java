package calculator.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Wait implements Interaction {
    int interval;
    public Wait(int interval)
    {
        this.interval = interval;
    }
    @Override
    @Step("{0} wait ")
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(interval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Interaction aBit(int timeInSecond)
    {
        return instrumented(Wait.class, timeInSecond);
    }

    public static class WaitBuilder
    {
        private int time=1;
        public WaitBuilder(int time)
        {
            this.time = time;
        }

        public Interaction inSecond()
        {
            int timeInSecond = this.time * 1000;
            return instrumented(Wait.class, timeInSecond);
        }

        public Interaction inMiniSecond()
        {
            return instrumented(Wait.class, time);
        }

        public Interaction inMinute()
        {
            int timeInMinute = this.time*60*1000;
            return instrumented(Wait.class, timeInMinute);
        }
    }

}
