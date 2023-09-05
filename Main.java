import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        String[] userData = getUserData();
        boolean exeption = true;
        do{
        try{chekUserData(userData);
            exeption=false;
        }catch (WrongForamtOfPhoneNumberExeption e){
            System.out.println(e.getMessage());
            userData[4] = scanner.nextLine();

        }catch (WrongFormatOfDateExeption e){
            System.out.println(e.getMessage());
            userData[3] = scanner.nextLine();

        }catch (WrongGenderExeption e){
            System.out.println(e.getMessage());
            userData[5] = scanner.nextLine();
        }

        }while (exeption);


        try {writeUserToFile(userData);
        }catch (IOException e){
            System.out.println("Ошибка записи данных о пользователе в файл");
        }
    }

    public static String []  getUserData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя в формате 'Фамилия Имя Отчество датарождения номертелефона пол'");
        boolean d = true;

        String[] userData;
        do {
            String user = scanner.nextLine();
            userData = user.split(" ");
            if (userData.length == 6) {
                d = false;
            } else {
                System.out.println("Некорректный ввод, попробуйте ещё раз, обязательно разделяйте данные пробелами, у вас должно быть 6 полей");
            }
        } while (d);
        return userData;
    }

    public static void chekUserData(String[]userData) throws WrongForamtOfPhoneNumberExeption, WrongGenderExeption, WrongFormatOfDateExeption {
        try {
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            int number = Integer.parseInt(userData[4]);
            Date bornDate = df.parse(userData[3]);
            checkDate(bornDate);
            chekGender(userData[5]);
        }catch (NumberFormatException e){
            throw  new WrongForamtOfPhoneNumberExeption();
        }catch (ParseException e ){
            throw new WrongFormatOfDateExeption();
        }catch (WrongGenderExeption e){
            throw new WrongGenderExeption();

        }

    }

    public static void writeUserToFile(String[] userData) throws IOException {
        String fileName = userData[0];

        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            for (int i = 0; i < userData.length; i++) {

                fileWriter.append("<").append(userData[i]).append(">");
            }
            fileWriter.append("\n");
        }
    }


public static void checkDate(Date date) throws WrongFormatOfDateExeption {
        LocalDate simpleDate = LocalDate.now();
        LocalDate date1 = LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
        if(simpleDate.isBefore(date1)){
            throw new WrongFormatOfDateExeption();
        }
}
    public static void chekGender(String gender) throws WrongGenderExeption{
if(!(gender.equals("m")||gender.equals("f"))){
    throw new WrongGenderExeption();
}
    }

}
