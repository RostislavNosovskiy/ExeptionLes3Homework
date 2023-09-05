import java.text.ParseException;

public class WrongFormatOfDateExeption extends ParseException {


    public WrongFormatOfDateExeption() {
        super("Неправильный формат даты или дата указанная вами дата рождения невозможна, " +
                "Попробуйте ввести дату ещё раз в формате 'дд.мм.гггг' ",1);
    }
}
