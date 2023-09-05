public class WrongForamtOfPhoneNumberExeption extends NumberFormatException{
    public WrongForamtOfPhoneNumberExeption(String masege){
        super(masege);
    }

    public  WrongForamtOfPhoneNumberExeption(){
        super("Неправильный формат номера телефона" +
                "Попробуйте ещё раз ввести номер корректно, используя только цифры");
    }
}
