package ru.javabegin.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import ru.javabegin.hibernate.dao.*;
import ru.javabegin.hibernate.entity.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class Main {
    private final ActorDao actorDao;
    private final AddressDao addressDao;
    private final CategoryDao categoryDao;
    private final CityDao cityDao;
    private final CountryDao countryDao;
    private final CustomerDao customerDao;
    private final FilmDao filmDao;
    private final FilmActorDao filmActorDao;
    private final FilmCategoryDao filmCategoryDao;
    private final FilmTextDao filmTextDao;
    private final InventoryDao inventoryDao;
    private final LanguageDao languageDao;
    private final PaymentDao paymentDao;
    private final StoreDao storeDao;
    private final RentalDao rentalDao;
    private final StaffDao staffDao;




    private final SessionFactory sessionFactory;
    public Main() {
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/movie");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "root");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.put(Environment.HBM2DDL_AUTO, "validate");

        sessionFactory = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Film.class)
                .addAnnotatedClass(FilmText.class)
                .addAnnotatedClass(Inventory.class)
                .addAnnotatedClass(Language.class)
                .addAnnotatedClass(Payment.class)
                .addAnnotatedClass(Rental.class)
                .addAnnotatedClass(Staff.class)
                .addAnnotatedClass(Store.class)
                .addProperties(properties)
                .buildSessionFactory();

        actorDao = new ActorDao(sessionFactory);
        addressDao = new AddressDao(sessionFactory);
        categoryDao = new CategoryDao(sessionFactory);
        cityDao = new CityDao(sessionFactory);
        countryDao = new CountryDao(sessionFactory);
        customerDao = new CustomerDao(sessionFactory);
        filmDao = new FilmDao(sessionFactory);
        filmActorDao = new FilmActorDao(sessionFactory);
        filmCategoryDao = new FilmCategoryDao(sessionFactory);
        filmTextDao = new FilmTextDao(sessionFactory);
        inventoryDao = new InventoryDao(sessionFactory);
        languageDao = new LanguageDao(sessionFactory);
        paymentDao = new PaymentDao(sessionFactory);
        rentalDao = new RentalDao(sessionFactory);
        staffDao = new StaffDao(sessionFactory);
        storeDao = new StoreDao(sessionFactory);


    }
    public static void main(String[] args) {
        Main main = new Main();
        // Customer customer = main.createCustomer();

       // main.customerReturn();

        //main.customerRentInventory(customer);

        main.rentFilmedFilm();
    }

    private void rentFilmedFilm() {
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();

            Language language = languageDao.getItems(0,5).stream().unordered().findAny().get();
            List<Category> categoryList = categoryDao.getItems(0,5);
            List<Actor> actors = actorDao.getItems(0,5);

            Film film = new Film();
            film.setActorSet(new HashSet<>(actors));
            film.setDescription("QWERTY");
            film.setLanguage(language);
            film.setLength((short) 42);
            film.setRating(Rating.NC_17);
            film.setSpecialFeatures(Set.of(SpecialFeatures.TRAILERS, SpecialFeatures.COMMENTARIES));
            film.setReplacementCost(BigDecimal.valueOf(1.1));
            film.setRentalRate(BigDecimal.valueOf(4));
            film.setTitle("YTREWQ");
            film.setRentalDuration((byte) 2);
            film.setOriginalLanguage(language);
            film.setCategorySet(new HashSet<>(categoryList));
            film.setReleaseYear(Year.now());
            filmDao.save(film);

            FilmText filmText = new FilmText();
            filmText.setFilm(film);
            filmText.setFilmId(film.getFilmID());
            filmText.setDescription("QWERTY");
            filmText.setTitle("YTREWQ");
            filmTextDao.save(filmText);

            session.getTransaction().commit();

        }
    }

    private void customerRentInventory(Customer customer) {
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();

            Film film = filmDao.getFirstAvaliableFilmForRent();
            Store store = storeDao.getItems(0,1).get(0);

            Inventory inventory = new Inventory();
            inventory.setFilm(film);
            inventory.setStore(store);
            inventoryDao.save(inventory);

            Staff staff = store.getStaff();

            Rental rental = new Rental();
            rental.setRentalDate(LocalDateTime.now());
            rental.setCustomer(customer);
            rental.setInventory(inventory);
            rental.setStaff(staff);
            rentalDao.save(rental);

            Payment payment = new Payment();
            payment.setRental(rental);
            payment.setPaymentDate(LocalDateTime.now());
            payment.setCustomer(customer);
            payment.setAmount(BigDecimal.valueOf(1));
            payment.setStaff(staff);
            paymentDao.save(payment);

            session.getTransaction().commit();
        }
    }

    private void customerReturn() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Rental rental = rentalDao.getUntouchedRental();
            rental.setReturnDate(LocalDateTime.now());

            rentalDao.save(rental);
            session.getTransaction().commit();

        }
    }

    private Customer createCustomer() {
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();

            Store store = storeDao.getItems(0,1).get(0);

            City city = cityDao.getByName("Barcelona");

            Address address = new Address();
            address.setAddress("AAA");
            address.setPhone("88005553535");
            address.setCity(city);
            address.setDistrict("Kolotyshkina");
            addressDao.save(address);

            Customer customer = new Customer();
            customer.setActive(true);
            customer.setEmail("qwerty@mail.ru");
            customer.setAddress(address);
            customer.setStore(store);
            customer.setFirstName("Imya");
            customer.setLastName("Familiya");
            customerDao.save(customer);

            session.getTransaction().commit();
            return customer;
        }
    }
}