public class WrongGenderExeption extends RuntimeException{

    public WrongGenderExeption(){
        super("Неправильный формат пола, " +
                "Попробуйте ввести пол ещё раз в формате 'f' или 'm')");
    }
}
