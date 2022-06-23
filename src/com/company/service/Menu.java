package com.company.service;

import com.company.enums.ObjectType;
import com.company.enums.Position;
import com.company.enums.PurposeOfArrival;
import com.company.model.Car;
import com.company.model.DbObject;
import com.company.model.person.Client;
import com.company.model.person.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

import static com.company.enums.ObjectType.*;
import static com.company.enums.Position.*;
import static com.company.enums.PurposeOfArrival.REPAIR;
import static com.company.enums.PurposeOfArrival.REVIEW;
import static com.company.model.Db.getDb;

public class Menu {
    public static void createObject() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input;
            do {
                System.out.println("Wprowadź cyfre z przedziału 1-3, żeby wybrać typ obiektu.");
                System.out.println("Wybierz znak @, żeby wrócić do wyboru trybu pracy");
                System.out.println("1.Dodaj Samochód");
                System.out.println("2.Dodaj Klienta");
                System.out.println("3.Dodaj Pracownika");

                input = reader.readLine();
                switch (input) {
                    case "1":
                        System.out.println("Jesteś w trybie dodaj samochód.");

                        System.out.println("Podaj Marke i Model pojazdu.");
                        String name = reader.readLine();

                        System.out.println("Podaj date przyjęcia samochodu do warsztatu format YYYY-MM-DD np. 2021-12-24.");
                        String date = reader.readLine();

                        System.out.println("Podaj Imię i Nazwisko właściciela.");
                        String ownerNameSurname = reader.readLine();

                        System.out.println("Podaj rok produkcji samochodu.");
                        int yearOfProduction = getIntegerNumber();


                        PurposeOfArrival purposeOfArrival;
                        String inputCar;
                        do {
                            System.out.println("Wybierz cel przyjazdu");
                            System.out.println("1. Przegląd");
                            System.out.println("2. Naprawa");
                            inputCar = reader.readLine();
                            switch (inputCar) {
                                case "1":
                                    purposeOfArrival = REVIEW;
                                    break;
                                case "2":
                                    purposeOfArrival = REPAIR;
                                    break;
                                default:
                                    purposeOfArrival = null;
                                    System.out.println(input + " to niepoprawna wartość, prosze wybrać wartości z przedziału 1-2\n");
                                    break;
                            }
                        } while (!(inputCar.equals("1") || inputCar.equals("2")));

                        System.out.println("Podaj koszt");
                        int cost = getIntegerNumber();


                        Car car = new Car(name, date, CAR, ownerNameSurname, yearOfProduction, purposeOfArrival, cost);
                        getDb().add(car);
                        System.out.println("Samochód został dodany");
                        break;
                    case "2":
                        System.out.println("Jesteś w trybie dodaj klienta.");

                        System.out.println("Podaj imię i nazwisko klienta.");
                        String clientName = reader.readLine();

                        System.out.println("Podaj date przyjęcia klienta format YYYY-MM-DD np. 2021-12-24.");
                        String clientDate = reader.readLine();

                        System.out.println("Podaj saldo płatności klienta.");
                        double clientBalanceOfPayments = getDoubleNumber();


                        boolean loyaltyCard = false;
                        String inputClient;
                        do {
                            System.out.println("Czy klient posiada kartę stałego klienta?");
                            System.out.println("1. Tak");
                            System.out.println("2. Nie");
                            inputClient = reader.readLine();
                            switch (inputClient) {
                                case "1":
                                    loyaltyCard = true;
                                    break;
                                case "2":
                                    break;
                                default:
                                    System.out.println(inputClient + " to niepoprawna wartość, prosze wybrać wartości z przedziału 1-2\n");
                                    break;
                            }
                        } while (!(inputClient.equals("1") || inputClient.equals("2")));

                        Client client = new Client(clientName, clientDate, CLIENT, clientBalanceOfPayments, loyaltyCard);
                        getDb().add(client);
                        break;
                    case "3":
                        System.out.println("Jesteś w trybie dodaj pracownika.");

                        System.out.println("Podaj imię i nazwisko pracownika.");
                        String employeeName = reader.readLine();

                        System.out.println("Podaj date przyjęcia pracownika format YYYY-MM-DD np. 2021-12-24.");
                        String employeeDate = reader.readLine();

                        System.out.println("Podaj saldo płatności pracownika.");
                        double employeeBalanceOfPayments = getDoubleNumber();

                        System.out.println("Podaj pensje pracownika");
                        int employeeSalary = getIntegerNumber();

                        Position position;
                        String inputEmployee;
                        do {
                            System.out.println("Wybierz stanowisko pracownika");
                            System.out.println("1. Pomocnik mechanika");
                            System.out.println("2. Mechanik");
                            System.out.println("3. Starszy mechanik");
                            inputEmployee = reader.readLine();
                            switch (inputEmployee) {
                                case "1":
                                    position = MECHANIC_HELPER;
                                    break;
                                case "2":
                                    position = MECHANIC;
                                    break;
                                case "3":
                                    position = SENIOR_MECHANIC;
                                    break;
                                default:
                                    position = null;
                                    System.out.println(inputEmployee + " to niepoprawna wartość, prosze wybrać wartości z przedziału 1-2\n");
                                    break;
                            }
                        } while (!(inputEmployee.equals("1") || inputEmployee.equals("2") || inputEmployee.equals("3")));

                        Employee employee = new Employee(employeeName, employeeDate, EMPLOYEE, employeeBalanceOfPayments, employeeSalary, position);
                        getDb().add(employee);
                        break;
                    case "6":
                        break;
                    default:
                        System.out.println(input + " to niepoprawna wartość, prosze wybrać wartości z przedziału 1-3\n");
                        break;
                }
            } while (!input.equals("@"));
        } catch (IOException ex) {
            System.out.println("Niepoprawne wejsce");
        }
    }

    public static void removeObject() throws IOException {
        System.out.println("Jesteś w trybie usuwania obiektów, podaj identyfikator obiektu który chcesz usunąć");
        long getId = getIntegerNumber();
        for (int i = 0; i < getDb().size(); i++) {
            if (getDb().get(i).getId() == getId) {
                System.out.println("Usunięto obiekt o indeksie: " + getDb().get(i).getId());
                getDb().remove(i);
                break;
            }
            if(i == getDb().size() - 1) {
                System.out.println("Brak podanego indeksu w bazie wybierz 3. i spróbuj ponownie");
            }
        }
    }

    public static void showObjects() {
        for (int i = 0; i < getDb().size(); i++) {
            System.out.println(getDb().get(i).toString());
        }
    }

    public static void showSpecyficTypesOfObjects() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Jesteś w trybie wyświetla obiektów o poszczególnym podtypie.");
        System.out.println("Wybierz tryb 1-3.");
        System.out.println("Jeśli chcesz powrócić wybierz @.");
        System.out.println("1. Wyświetl wszystkie samochody.");
        System.out.println("2. Wyświetl wszystkich klientów.");
        System.out.println("3. Wyświetl wszystkich pracowników.");

        String typeInput = reader.readLine();
        switch (typeInput) {
            case "1":
                showType(CAR);
                break;
            case "2":
                showType(CLIENT);
                break;
            case "3":
                showType(EMPLOYEE);
                break;
        }
    }

    public static void showType(ObjectType objectType) {
        for (int i = 0; i < getDb().size(); i++) {
            if (getDb().get(i).getObjectType() == objectType) {
                System.out.println(getDb().get(i).toString());
            }
        }
    }

    public static void searchForSpecyficObject() throws IOException {

        System.out.println("Jesteś w trybie wyszukiwania obiektów po podanym ciągu znaków,wprowadź ciąg znaków");
        System.out.println("Program nie uwzględnia wielkości liter.");
        System.out.println("Jeśli chcesz wrócić do menu wpisz znak @");


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sInput = reader.readLine();
        String searchInput = sInput.toUpperCase(Locale.ROOT);
        int counter = 0;

        for (int i = 0; i < getDb().size(); i++) {

            String helpName = getDb().get(i).getName();
            helpName = helpName.toUpperCase(Locale.ROOT);

            for (int j = 0; j < getDb().get(i).getName().length(); j++) {

                if (j + searchInput.length() - 1 == getDb().get(i).getName().length()) break;

                String helpStr = helpName.substring(j, j + searchInput.length());

                if (helpStr.equals(searchInput)) {
                    System.out.println(getDb().get(i).toString());
                    counter++;
                    break;
                }
            }
        }
        switch (counter) {
            case 0: {
                if (sInput.equals("@")) break;
                System.out.println("Nie znaleziono obiektów zawierających podany ciąg znaków, wybierz tryb nr.5 i spróbuj ponownie");
                break;
            }
            case 1:
                System.out.println("Znaleziono " + counter + " obiekt zawierający ciąg znaków " + sInput);
                break;
            case 2, 3, 4:
                System.out.println("Znaleziono " + counter + " obiekty zawierające ciąg znaków " + sInput);
                break;
            default:
                System.out.println("Znaleziono " + counter + " obiektów zawierających ciąg znaków " + sInput);
        }
    }

    public static int promoteEmployee() throws IOException {

        System.out.println("Jesteś w trybie do awansowania swoich pracowników");
        System.out.println("Podaj indeks pracownika którego chcesz awansować");
        long id = getIntegerNumber();
        for (DbObject dbObject : getDb()) {
            if (dbObject.getId() == id && dbObject instanceof Employee) {
                Employee employee = ((Employee) dbObject);
                switch (employee.getPosition()) {
                    case MECHANIC_HELPER: {
                        employee.setPosition(Position.MECHANIC);
                        System.out.println(employee.getName() + " awansował na stanowisko " + employee.getPosition());
                    }
                        return 0;
                    case MECHANIC: {
                        employee.setPosition(Position.SENIOR_MECHANIC);
                        System.out.println(employee.getName() + " awansował na stanowisko " + employee.getPosition());
                        return 0;
                    }
                    case SENIOR_MECHANIC: {
                        System.out.println(employee.getName() + " posiada stanowisko SENIOR_MECHANIC, nie może awansować wyżej ");
                        return 0;
                    }
                }
            } else if(dbObject.getId() == id) {
                System.out.println("Obiekt o podanym indeksie nie jest Pracownikiem");
                return 0;
            }

        }
        System.out.println("Obiektu o tym indeksie nie ma w bazie danych");
        return 0;
    }

    public static int getIntegerNumber() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {

            try {
                String number = reader.readLine();
                return Integer.parseInt(number);
            } catch (NumberFormatException e) {
                System.out.println("Niepoprawy typ danych proszę wprowadzić liczbę");
            }
            catch (IOException e) {
                System.out.println("Nie udało się odczytać danych");
            }
        } while (true);
    }


    public static double getDoubleNumber() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            String number = reader.readLine();
            try {
                return Double.parseDouble(number);
            } catch (NumberFormatException e) {
                System.out.println("Niepoprawy typ danych proszę wprowadzić liczbę");
            }
        } while (true);
    }
}

