package Aplikacja_do_treningu_konsultantow.database.tablesdata;

import Aplikacja_do_treningu_konsultantow.database.model.Zadania;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class ZadaniaData {

    public static void loadZadaniaData(ConnectionSource connectionSource) throws SQLException {

        Dao<Zadania, ?> dao1 = DaoManager.createDao(connectionSource, Zadania.class);

        //kl. 1
        Zadania zadanie = new Zadania();

        zadanie.setTemat("Proszę powiedzieć mi jaki jest numer do lekarza?");
        zadanie.setTemat_odp_a("Niestety nie wiem jaki jest numer do pana lekarza ale mogę podać numer na pogotowie jeżeli potrzebuje Pan pomocy.");
        zadanie.setTemat_odp_b("Niestety rozmowa staje się niemerytoryczna jestem zmuszony zakończyć połączenie.");
        zadanie.setTemat_odp_c("Nie wiem.");
        zadanie.setTemat_odp_poprawna("Niestety nie wiem jaki jest numer do pana lekarza ale mogę podać numer na pogotowie jeżeli potrzebuje Pan pomocy.");
        zadanie.setTemat_podpowiedz("Czy pytanie dotyczy spraw telekomunikacyjnych?");

        zadanie.setWeryfikacja("Dzień dobry, chciałem porozmawiać o moim numerze 543654765.");
        zadanie.setWeryfikacja_odp_a("Czy rozmawiam z właścicielem?");
        zadanie.setWeryfikacja_odp_b("Niestety jestem zmuszony się rozłączyć.");
        zadanie.setWeryfikacja_odp_c("Nie mogę teraz rozmawiać.");
        zadanie.setWeryfikacja_odp_poprawna("Czy rozmawiam z właścicielem?");

        zadanie.setWeryfikacja2("Tak, jestem właścicielem.");
        zadanie.setWeryfikacja2_odp_a("Rozumiem w takim razie już sprawdzam Pana numer.");
        zadanie.setWeryfikacja2_odp_b("W takim razie poproszę o Pana imię i nazwisko oraz hasło do konta.");
        zadanie.setWeryfikacja2_odp_c("Niestety nie mogę Panu pomóc.");
        zadanie.setWeryfikacja2_odp_poprawna("W takim razie poproszę o Pana imię i nazwisko oraz hasło do konta.");

        zadanie.setWeryfikacja3("Nazywam się Tadeusz Sznuk, a moje hasło to tadek.sznuk.");
        zadanie.setWeryfikacja3_odp_a("Niestety podane dane się nie zgadzają, nie mam możliwości weryfikacji, proszę sprawdzić poprawność danych i oddzwonić.");
        zadanie.setWeryfikacja3_odp_b("Żegnam.");
        zadanie.setWeryfikacja3_odp_c("Dziękuję, wszystkie dane są poprawne, proszę powiedzieć jak mogę Panu pomóc?");
        zadanie.setWeryfikacja3_odp_poprawna("Dziękuję, wszystkie dane są poprawne, proszę powiedzieć jak mogę Panu pomóc?");

        zadanie.setZaliczenie("Zaliczone");
        zadanie.setTyp("Usługi");
        zadanie.setOpis("Klient ze zgłoszeniem nietelekomunikacyjnym.");
        zadanie.setBledy(0);

        dao1.create(zadanie);

        //kl. 2
        Zadania zadanie2 = new Zadania();

        zadanie2.setTemat("Dobrze to ja jeszcze sprawdzę i oddzwonię później");
        zadanie2.setTemat_odp_a("Rozumiem, życzę miłego dnia, do usłyszenia.");
        zadanie2.setTemat_odp_b("Niestety rozmowa staje się niemerytoryczna jestem zmuszony zakończyć połączenie.");
        zadanie2.setTemat_odp_c("Może jednak nie będę przestrzegał tajemnicy telekomunikacyjnekj i udzielę Panu informacji o koncie.");
        zadanie2.setTemat_odp_poprawna("Rozumiem, życzę miłego dnia, do usłyszenia.");
        zadanie2.setTemat_podpowiedz("Czy klient został poprawnie zweryfikowany.");

        zadanie2.setWeryfikacja("Dzień dobry, chciałem porozmawiać o koncie 123123");
        zadanie2.setWeryfikacja_odp_a("Czy rozmawiam z właścicielem?");
        zadanie2.setWeryfikacja_odp_b("Proszę podać numer dowodu osobistego.");
        zadanie2.setWeryfikacja_odp_c("Czy rozmawiam z użytkownikiem?");
        zadanie2.setWeryfikacja_odp_poprawna("Czy rozmawiam z właścicielem?");

        zadanie2.setWeryfikacja2("Tak, jestem właścicielem.");
        zadanie2.setWeryfikacja2_odp_a("Rozumiem w takim razie już sprawdzam Pana numer.");
        zadanie2.setWeryfikacja2_odp_b("W takim razie poproszę o Pana imię i nazwisko oraz hasło do konta.");
        zadanie2.setWeryfikacja2_odp_c("Niestety nie mogę Panu pomóc.");
        zadanie2.setWeryfikacja2_odp_poprawna("W takim razie poproszę o Pana imię i nazwisko oraz hasło do konta.");

        zadanie2.setWeryfikacja3("Nazywam się Janusz Sznuk, a moje hasło to janusz.sznuk.");
        zadanie2.setWeryfikacja3_odp_a("Niestety podane dane się nie zgadzają, nie mam możliwości weryfikacji, proszę sprawdzić poprawność danych i oddzwonić.");
        zadanie2.setWeryfikacja3_odp_b("Żegnam.");
        zadanie2.setWeryfikacja3_odp_c("Dziękuję, wszystkie dane są poprawne, proszę powiedzieć jak mogę Panu pomóc?");
        zadanie2.setWeryfikacja3_odp_poprawna("Niestety podane dane się nie zgadzają, nie mam możliwości weryfikacji, proszę sprawdzić poprawność danych i oddzwonić.");

        zadanie2.setZaliczenie("Zaliczone");
        zadanie2.setTyp("Weryfikacja");
        zadanie2.setOpis("Podane przez klienta dane do weryfikacji były nieprawidłowe.");
        zadanie2.setBledy(0);

        dao1.create(zadanie2);

        //kl. 3
        Zadania zadanie3 = new Zadania();

        zadanie3.setTemat("Proszę powiedzieć ile mam na koncie na numerze 543654765, niestety nie mam teraz przy sobie tego telefonu i nie jestem w stanie sprawdzić.");
        zadanie3.setTemat_odp_a("Ma Pan na koncie 0 zł.");
        zadanie3.setTemat_odp_b("Niestety rozmowa staje się niemerytoryczna jestem zmuszony zakończyć połączenie.");
        zadanie3.setTemat_odp_c("Stan konta wynosi 100 zł.");
        zadanie3.setTemat_odp_poprawna("Ma Pan na koncie 0 zł.");
        zadanie3.setTemat_podpowiedz("Stan konta można sprawdzić w zakładce Salda bieżące");

        zadanie3.setWeryfikacja("Dzień dobry, chciałem porozmawiać o numerze 543654765.");
        zadanie3.setWeryfikacja_odp_a("Dzień dobry, czy rozmawiam z właścicielem?");
        zadanie3.setWeryfikacja_odp_b("Dzień dobry, czy pamięta Pan hasło?");
        zadanie3.setWeryfikacja_odp_c("Dzień dobry, proszę podać numer dowodu osobistego.");
        zadanie3.setWeryfikacja_odp_poprawna("Dzień dobry, czy rozmawiam z właścicielem?");

        zadanie3.setWeryfikacja2("Tak, jestem właścicielem.");
        zadanie3.setWeryfikacja2_odp_a("Rozumiem w takim razie już sprawdzam Pana numer.");
        zadanie3.setWeryfikacja2_odp_b("W takim razie poproszę o Pana imię i nazwisko oraz hasło do konta.");
        zadanie3.setWeryfikacja2_odp_c("Niestety nie mogę Panu pomóc, dane przekazujemy tylko użytkownikom.");
        zadanie3.setWeryfikacja2_odp_poprawna("W takim razie poproszę o Pana imię i nazwisko oraz hasło do konta.");

        zadanie3.setWeryfikacja3("Nazywam się Tadeusz Sznuk, a moje hasło to tadusz.sznuk.");
        zadanie3.setWeryfikacja3_odp_a("Niestety podane dane się nie zgadzają, nie mam możliwości weryfikacji, proszę sprawdzić poprawność danych i oddzwonić.");
        zadanie3.setWeryfikacja3_odp_b("Niestety do weryfikacji będzie potrzebny jeszcze numer dowodu osobistego.");
        zadanie3.setWeryfikacja3_odp_c("Dziękuję, wszystkie dane są poprawne, proszę powiedzieć jak mogę Panu pomóc?");
        zadanie3.setWeryfikacja3_odp_poprawna("Dziękuję, wszystkie dane są poprawne, proszę powiedzieć jak mogę Panu pomóc?");

        zadanie3.setZaliczenie("Brak");
        zadanie3.setTyp("Salda bieżące");
        zadanie3.setOpis("Klient chciał sprawdzić stan konta");
        zadanie3.setBledy(0);

        dao1.create(zadanie3);
    }

}
